package ca.cours5b5.FredericEngland.modeles;

import java.util.Map;

import ca.cours5b5.FredericEngland.controleurs.ControleurAction;
import ca.cours5b5.FredericEngland.controleurs.ControleurPartieReseau;
import ca.cours5b5.FredericEngland.controleurs.interfaces.Fournisseur;
import ca.cours5b5.FredericEngland.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.FredericEngland.exceptions.ErreurAction;
import ca.cours5b5.FredericEngland.exceptions.ErreurSerialisation;
import ca.cours5b5.FredericEngland.global.GCommande;
import ca.cours5b5.FredericEngland.serialisation.AttributSerialisable;

public class MPartieReseau extends MPartie implements Fournisseur, Identifiable {

    @AttributSerialisable
    public String idJoueurHote;
    private String __idJoueurHote = "idJoueurHote";

    @AttributSerialisable
    public String idJoueurInvite;
    private String __idJoueurInvite = "idJoueurInvite";

    public MPartieReseau(MParametresPartie parametres) {
        super(parametres);
        fournirActionRecevoirCoup();
    }

    private void fournirActionRecevoirCoup() {

        ControleurAction.fournirAction(this, GCommande.RECEVOIR_COUP_RESEAU, new ListenerFournisseur() {
            @Override
            public void executer(Object... args) {
                try{
                    int coup = ((Long) args[0]).intValue();
                    recevoirCoupReseau(coup);
                } catch(Exception e) {
                    throw new ErreurAction(e);

                }
            }
        });
    }

    public String getId() {
        return idJoueurHote;

    }

    private void recevoirCoupReseau(int colonne){
        jouerCoup(colonne);
    }

    @Override
    protected void fournirActionPlacerJeton() {

        ControleurAction.fournirAction(this,
                GCommande.JOUER_COUP_ICI,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {
                        try{
                            int colonne = (Integer) args[0];

                            jouerCoup(colonne);

                            ControleurPartieReseau.getInstance().transmettreCoup(colonne);

                        }catch(ClassCastException ex){

                            throw new ErreurAction(ex);

                        }
                    }
                });
    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurSerialisation {

        super.aPartirObjetJson(objetJson);

        idJoueurInvite = (String) objetJson.get(__idJoueurInvite);
        idJoueurHote = (String) objetJson.get(__idJoueurHote);

    }

    @Override
    public Map<String, Object> enObjetJson() throws ErreurSerialisation {

        Map<String, Object> objetJson = super.enObjetJson();

        objetJson.put(__idJoueurInvite, idJoueurInvite);
        objetJson.put(__idJoueurHote, idJoueurHote);

        return objetJson;
    }

}