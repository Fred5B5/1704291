package ca.cours5b5.fredericengland.controleurs;

import java.util.List;
import java.util.Map;

import ca.cours5b5.fredericengland.controleurs.interfaces.Fournisseur;
import ca.cours5b5.fredericengland.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.fredericengland.global.GCommande;

public class ControleurAction {

    private static Map<GCommande, Action> actions;

    private static List<Action> fileAttenteExecution;

    static {

    }

    public static Action demanderAction(GCommande commande) {

    }

    public static void fournirAction(Fournisseur fournisseur, GCommande commmande, ListenerFournisseur){

    }

    private static void executerActionExecutables() {

    }

    static boolean siActionExecutable (Action action) {



    }

    private static synchronized void executerMaintenant (Action action){

    }

    private static void lancerObservationSiApplicable (Action action) {

    }

    private static void enregistrerFournisseur(Fournisseur fournisseur, GCommande commande, ListenerFournisseur listenerFournisseur){

    }

    private static void ajouterActionEnFileDAttente(Action action){

    }

}
