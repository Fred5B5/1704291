package ca.cours5b5.FredericEngland.controleurs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.cours5b5.FredericEngland.controleurs.interfaces.ListenerChargement;
import ca.cours5b5.FredericEngland.controleurs.interfaces.ListenerGetModele;
import ca.cours5b5.FredericEngland.donnees.Server;
import ca.cours5b5.FredericEngland.donnees.SourceDeDonnees;
import ca.cours5b5.FredericEngland.exceptions.ErreurModele;
import ca.cours5b5.FredericEngland.modeles.Identifiable;
import ca.cours5b5.FredericEngland.modeles.MParametres;
import ca.cours5b5.FredericEngland.modeles.MPartie;
import ca.cours5b5.FredericEngland.modeles.MPartieReseau;
import ca.cours5b5.FredericEngland.modeles.Modele;
import ca.cours5b5.FredericEngland.donnees.Disque;
import ca.cours5b5.FredericEngland.usagers.UsagerCourant;

public final class ControleurModeles {

    private ControleurModeles(){}

    private static SourceDeDonnees[] sequenceDeChargement;
    private static Map<String, Modele> modelesEnMemoire;
    private static List<SourceDeDonnees> listeDeSauvegardes;

    static {

        modelesEnMemoire = new HashMap<>();
        listeDeSauvegardes = new ArrayList<>();
        listeDeSauvegardes.add(Disque.getInstance());
        listeDeSauvegardes.add(Server.getInstance());
    }

    public static void sauvegarderModeleDansCetteSource(String nomModele, SourceDeDonnees sourceDeDonnees) {

        Modele modele = modelesEnMemoire.get(nomModele);
        if(modele != null){
            Map<String, Object> objetJson = modele.enObjetJson();

            sourceDeDonnees.sauvegarderModele(getCheminSauvegarde(nomModele), objetJson);
        }
    }

    public static void setSequenceDeChargement(SourceDeDonnees... sequenceDeChargement){
        ControleurModeles.sequenceDeChargement = sequenceDeChargement;
    }

    public static void sauvegarderModele(String nomModele) throws ErreurModele {

        for(SourceDeDonnees sourceDonne : listeDeSauvegardes){
            sauvegarderModeleDansCetteSource(nomModele, sourceDonne);

        }
    }

    static void getModele(String nomModele, ListenerGetModele listenerGetModele){
        Modele modele = modelesEnMemoire.get(nomModele);

        if(modele == null){
            creerModeleEtChargerDonnees(nomModele, listenerGetModele);
        } else {
            listenerGetModele.reagirAuModele(modele);
        }

    }

    /*public static void detruireModele(String nomModele) {
        Modele modele = modelesEnMemoire.get(nomModele);
        if(modele != null){
            modelesEnMemoire.remove(nomModele);
            ControleurObservation.detruireObservation(modele);
            if(modele instanceof Fournisseur){
                ControleurAction.oublierFournisseur((Fournisseur) modele);
            }
        }
    }*/

    private static void creerModeleSelonNom(String nomModele, final ListenerGetModele listenerGetModele) throws ErreurModele {
        if(nomModele.equals(MParametres.class.getSimpleName())){
            listenerGetModele.reagirAuModele(new MParametres());

        }else if(nomModele.equals(MPartie.class.getSimpleName())){

            getModele(MParametres.class.getSimpleName(), new ListenerGetModele() {
                @Override
                public void reagirAuModele(Modele modele) {
                    MParametres modeleParam = (MParametres) modele;
                    MPartie modelePartie = new MPartie(modeleParam.parametresPartie.cloner());
                    listenerGetModele.reagirAuModele(modelePartie);

                }

            });

        } else if(nomModele.equals(MPartieReseau.class.getSimpleName())){
            getModele(MParametres.class.getSimpleName(), new ListenerGetModele() {
                @Override
                public void reagirAuModele(Modele modele) {

                    MParametres modeleParam = (MParametres) modele;

                    MPartieReseau modelePartieReseau = new MPartieReseau(modeleParam.parametresPartie.cloner());
                    listenerGetModele.reagirAuModele(modelePartieReseau);
                }

            });

        } else {


            throw new ErreurModele("Modèle pas connu: " + nomModele);

        }
    }

    static String getCheminSauvegarde(String nomModele){

        String cheminSauvegarde;
        Modele modele = modelesEnMemoire.get(nomModele);

        if(modele != null && modele instanceof Identifiable){
            cheminSauvegarde =  nomModele + "/" + ((Identifiable) modele).getId();
        } else {
            cheminSauvegarde =  nomModele + "/" + UsagerCourant.getId();
        }

        return cheminSauvegarde;

    }

    private static void chargerDonnees(Modele modele, String nomModele, ListenerGetModele listenerGetModele){
        chargementViaSequence(modele, getCheminSauvegarde(nomModele),listenerGetModele,0 );
    }

    private static void creerModeleEtChargerDonnees(final String nomModele, final ListenerGetModele listenerGetModele){

        creerModeleSelonNom(nomModele, new ListenerGetModele() {
            @Override
            public void reagirAuModele(Modele modele) {
                modelesEnMemoire.put(nomModele, modele);
                chargerDonnees(modele,nomModele,listenerGetModele);

            }
        });

    }

    private static void chargementViaSequence(Modele modele, String cheminDeSauvegarde, ListenerGetModele listenerGetModele, int indiceSourceCourante){

        if(indiceSourceCourante >= sequenceDeChargement.length){

            terminerChargement(modele, listenerGetModele);

        } else {

            chargementViaSourceCouranteOuSuivante(modele,cheminDeSauvegarde,listenerGetModele,indiceSourceCourante);

        }

    }

    private static void terminerChargementAvecDonnees(Map<String, Object> objetJson, Modele modele, ListenerGetModele listenerGetModele){
        modele.aPartirObjetJson(objetJson);
        terminerChargement(modele, listenerGetModele);

    }

    private static void chargementViaSourceSuivante(Modele modele, String cheminDeSauvegarde, ListenerGetModele listenerGetModele, int indiceSourceCourante){
        chargementViaSequence(modele, cheminDeSauvegarde, listenerGetModele,indiceSourceCourante + 1);
    }

    private static void chargementViaSourceCouranteOuSuivante(final Modele modele, final String cheminDeSauvegarde, final ListenerGetModele listenerGetModele, final int indiceSourceCourante){

        final SourceDeDonnees sourceCourante = sequenceDeChargement[indiceSourceCourante];

        sourceCourante.chargerModele(cheminDeSauvegarde, new ListenerChargement() {
            @Override
            public void reagirSucces(Map<String, Object> objetJson) {
                terminerChargementAvecDonnees(objetJson, modele,listenerGetModele);
            }

            @Override
            public void reagirErreur(Exception e) {
                chargementViaSourceSuivante(modele, cheminDeSauvegarde,listenerGetModele, indiceSourceCourante);
            }
        });

    }

    private static void terminerChargement(Modele modele, ListenerGetModele listenerGetModele){
        listenerGetModele.reagirAuModele(modele);
    }

}
