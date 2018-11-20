package ca.cours5b5.FredericEngland.activites;

import android.os.Bundle;

import ca.cours5b5.FredericEngland.R;
import ca.cours5b5.FredericEngland.controleurs.ControleurPartieReseau;
import ca.cours5b5.FredericEngland.controleurs.interfaces.Fournisseur;

public class APartieReseau extends Activite implements Fournisseur {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_partiereseau);

    }

    @Override
    protected void onResume() {

        super.onResume();

        ControleurPartieReseau.getInstance().connecterAuServeur();
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();

    }

    @Override
    protected void onPause() {

        super.onPause();
        ControleurPartieReseau.getInstance().detruireSauvegardeServeur();
        ControleurPartieReseau.getInstance().deconnecterDuServeur();

    }

}