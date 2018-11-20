package ca.cours5b5.FredericEngland.controleurs;

import ca.cours5b5.FredericEngland.global.GCommande;
import ca.cours5b5.FredericEngland.global.GCouleur;

public class ControleurPartie {

    private static final ControleurPartie instance = new ControleurPartie();

    private ControleurPartie(){}

    public void gagnerPartie(GCouleur couleurGagnant){

        Action actionAfficherGagnant = ControleurAction.demanderAction(GCommande.AFFICHAGE_SNACKBAR);

        actionAfficherGagnant.setArguments(couleurGagnant);

        actionAfficherGagnant.executerDesQuePossible();

    }

    public static ControleurPartie getInstance(){ return instance; }
}