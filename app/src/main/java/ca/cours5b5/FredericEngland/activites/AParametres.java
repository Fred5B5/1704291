package ca.cours5b5.FredericEngland.activites;

import android.os.Bundle;

import ca.cours5b5.FredericEngland.R;
import ca.cours5b5.FredericEngland.controleurs.ControleurModeles;
import ca.cours5b5.FredericEngland.controleurs.interfaces.Fournisseur;
import ca.cours5b5.FredericEngland.modeles.MParametres;

public class AParametres extends Activite implements Fournisseur{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);

    }

    @Override
    protected void onPause() {
        super.onPause();

        ControleurModeles.sauvegarderModele(MParametres.class.getSimpleName());

    }

}
