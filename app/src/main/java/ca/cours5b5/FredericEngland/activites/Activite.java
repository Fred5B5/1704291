package ca.cours5b5.FredericEngland.activites;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ca.cours5b5.FredericEngland.donnees.SauvegardeTemporaire;
import ca.cours5b5.FredericEngland.donnees.Transition;
import ca.cours5b5.FredericEngland.controleurs.ControleurModeles;
import ca.cours5b5.FredericEngland.donnees.Disque;
import ca.cours5b5.FredericEngland.donnees.Serveur;
import ca.cours5b5.FredericEngland.modeles.MParametres;


public abstract class Activite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initialiserControleurModeles(savedInstanceState);

        initialiserApplication();

        prechargerLesModeles();

    }


    private void prechargerLesModeles() {

        ControleurModeles.prechargerModele(MParametres.class.getSimpleName());

    }


    protected void initialiserControleurModeles(Bundle savedInstanceState) {

        ControleurModeles.setSequenceDeChargement(
                new SauvegardeTemporaire(savedInstanceState),
                new Transition(getIntent().getExtras()),
                Serveur.getInstance(),
                Disque.getInstance());

    }


    protected void initialiserApplication(){

        Disque.getInstance().setRepertoireRacine(getFilesDir());

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        ControleurModeles.sauvegarderModeleDansCetteSource(MParametres.class.getSimpleName(),
                new SauvegardeTemporaire(outState));

    }


    protected void quitterCetteActivite(){
        finish();
    }

}