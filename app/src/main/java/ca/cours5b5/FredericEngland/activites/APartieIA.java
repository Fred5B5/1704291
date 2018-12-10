package ca.cours5b5.FredericEngland.activites;

import android.os.Bundle;

import ca.cours5b5.FredericEngland.R;
import ca.cours5b5.FredericEngland.controleurs.ControleurAction;
import ca.cours5b5.FredericEngland.controleurs.ControleurModeles;
import ca.cours5b5.FredericEngland.controleurs.interfaces.Fournisseur;
import ca.cours5b5.FredericEngland.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.FredericEngland.global.GCommande;
import ca.cours5b5.FredericEngland.modeles.MPartie;

public class APartie extends Activite implements Fournisseur {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partie);

        fournirActionTerminerPartie();

    }


    private void fournirActionTerminerPartie() {

        ControleurAction.fournirAction(this,
                GCommande.TERMINER_PARTIE,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        quitterCetteActivite();

                    }
                });
    }


    @Override
    protected void onPause() {
        super.onPause();
        sauvegarderPartie();
    }


    protected void sauvegarderPartie(){
        ControleurModeles.sauvegarderModele(MPartie.class.getSimpleName());
    }


}