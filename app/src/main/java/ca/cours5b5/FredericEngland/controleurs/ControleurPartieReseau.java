package ca.cours5b5.FredericEngland.controleurs;

import ca.cours5b5.FredericEngland.controleurs.interfaces.ListenerGetModele;
import ca.cours5b5.FredericEngland.donnees.Server;
import ca.cours5b5.FredericEngland.global.GCommande;
import ca.cours5b5.FredericEngland.global.GConstantes;
import ca.cours5b5.FredericEngland.modeles.MPartieReseau;
import ca.cours5b5.FredericEngland.modeles.Modele;
import ca.cours5b5.FredericEngland.proxy.ProxyListe;
import ca.cours5b5.FredericEngland.usagers.UsagerCourant;

public final class ControleurPartieReseau {

    private static final ControleurPartieReseau instance = new ControleurPartieReseau();
    public static ControleurPartieReseau getInstance(){
        return instance;
    }

    private ProxyListe proxyRecevoirCoups;
    private ProxyListe proxyEmettreCoups;

    public void connecterAuServeur(){
        ControleurModeles.getModele(MPartieReseau.class.getSimpleName(), new ListenerGetModele() {
            @Override
            public void reagirAuModele(Modele modele) {
                MPartieReseau modelePartieReseau = (MPartieReseau) modele;
                connecterAuServeur(modelePartieReseau.idJoueurHote);
            }
        });
    }

    private void connecterEnTantQueJoueurInvite(String cheminCoupsJoueurH, String cheminCoupsJoueurI) {
        proxyRecevoirCoups = new ProxyListe(cheminCoupsJoueurH);
        proxyEmettreCoups = new ProxyListe(cheminCoupsJoueurI);
    }

    private void connecterAuServeur(String idJoueurH) {
        if(UsagerCourant.getId().equals(idJoueurH)){
            connecterEnTantQueJoueurHote(getCheminCoupsJoueurHote(idJoueurH), getCheminCoupsJoueurInvite(idJoueurH));
        } else {
            connecterEnTantQueJoueurInvite(getCheminCoupsJoueurHote(idJoueurH), getCheminCoupsJoueurInvite(idJoueurH));
        }
        proxyRecevoirCoups.setActionNouvelItem(GCommande.RECEVOIR_COUP_RESEAU);
        proxyRecevoirCoups.connecterAuServeur();
        proxyEmettreCoups.connecterAuServeur();
    }

    private void connecterEnTantQueJoueurHote(String cheminCoupsJoueurH, String cheminCoupsJoueurI) {
        proxyEmettreCoups = new ProxyListe(cheminCoupsJoueurH);
        proxyRecevoirCoups = new ProxyListe(cheminCoupsJoueurI);
    }

    public void transmettreCoup(Integer idColonne){
        proxyEmettreCoups.ajouterValeur(idColonne);
    }

    public void deconnecterDuServeur(){
        proxyEmettreCoups.deconnecterDuServeur();
        proxyRecevoirCoups.deconnecterDuServeur();
    }

    private String getCheminCoupsJoueurHote(String idJoueurHote){
        return getCheminPartie(idJoueurHote) + '/' + GConstantes.CLE_COUPS_JOUEUR_HOTE;
    }

    public void detruireSauvegardeServeur() {
        Server.getInstance().detruireSauvegarde(getCheminPartie(UsagerCourant.getId()));
    }

    private String getCheminCoupsJoueurInvite(String idJoueurHote){
        return getCheminPartie(idJoueurHote) + '/' + GConstantes.CLE_COUPS_JOUEUR_INVITE;
    }

    private String getCheminPartie(String idJoueurHote){
        return MPartieReseau.class.getSimpleName() + '/' + idJoueurHote;
    }

}