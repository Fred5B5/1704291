package ca.cours5b5.fredericengland.controleurs;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.cours5b5.fredericengland.controleurs.interfaces.Fournisseur;
import ca.cours5b5.fredericengland.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.fredericengland.global.GCommande;
import ca.cours5b5.fredericengland.modeles.Modele;

public class ControleurAction {

    private static Map<GCommande, Action> actions;

    private static List<Action> fileAttenteExecution;

    static {

        actions = new HashMap<>();
        fileAttenteExecution = new ArrayList<>();

        for(GCommande commande : GCommande.values()){

            actions.put(commande, new Action());

        }

    }

    public static Action demanderAction(GCommande commande) {

        return actions.get(commande);

    }

    public static void fournirAction(Fournisseur fournisseur, GCommande commmande, ListenerFournisseur listenerFournisseur){

        enregistrerFournisseur(fournisseur, commmande, listenerFournisseur);
        executerActionsExecutables();

    }

    private static void executerActionsExecutables() {

        Class currentClass = new Object() { }.getClass().getEnclosingClass();
        Log.i("MyApp",currentClass.getSimpleName() + "::executerActionsExecutables");

        for (Action action : fileAttenteExecution ) {

            if (siActionExecutable(action)) {

                executerMaintenant(action);

                lancerObservationSiApplicable(action);

                fileAttenteExecution.remove(0);

            }

        }

    }

    static boolean siActionExecutable (Action action) {

        return (action.fournisseur != null);

    }

    static void executerDesQuePossible(Action action){

        Class currentClass = new Object() { }.getClass().getEnclosingClass();
        Log.i("MyApp",currentClass.getSimpleName() + "::executerDesQuePossible");

        ajouterActionEnFileDAttente(action);

        executerActionsExecutables();

    }

    private static synchronized void executerMaintenant (Action action){

        Class currentClass = new Object() { }.getClass().getEnclosingClass();
        Log.i("MyApp",currentClass.getSimpleName() + "::executerMaintenant");

        action.listenerFournisseur.executer(action.args);

    }

    private static void lancerObservationSiApplicable (Action action) {

        if (action.fournisseur instanceof Modele){

            ControleurObservation.lancerObservation((Modele)action.fournisseur);

        }

    }

    private static void enregistrerFournisseur(Fournisseur fournisseur, GCommande commande, ListenerFournisseur listenerFournisseur){

        Action action = demanderAction(commande);

        action.fournisseur = fournisseur;

        action.listenerFournisseur = listenerFournisseur;

    }

    private static void ajouterActionEnFileDAttente(Action action){

        fileAttenteExecution.add(action);

    }

}
