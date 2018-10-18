package ca.cours5b5.fredericengland.controleurs;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import ca.cours5b5.fredericengland.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.fredericengland.modeles.MParametres;
import ca.cours5b5.fredericengland.modeles.MParametresPartie;
import ca.cours5b5.fredericengland.modeles.MPartie;
import ca.cours5b5.fredericengland.modeles.Modele;

public class ControleurObservation {

    private static Map<Modele, ListenerObservateur> observations;

    private static MPartie partie;

    static {

        observations = new HashMap<>();
        Class currentClass = new Object() { }.getClass().getEnclosingClass();
        Log.i("MyApp",currentClass.getSimpleName() + "::observerModele");

    }

    public static void observerModele ( String nomModele, final ListenerObservateur listenerObservateur) {

            partie = new MPartie( MParametresPartie.aPartirMParametres(MParametres.instance) );

            observations.put(ControleurObservation.partie, listenerObservateur);

            listenerObservateur.reagirNouveauModele(partie);

    }

}
