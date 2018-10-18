package ca.cours5b5.fredericengland.modeles;

import java.util.Map;

import ca.cours5b5.fredericengland.controleurs.ControleurAction;
import ca.cours5b5.fredericengland.controleurs.interfaces.Fournisseur;
import ca.cours5b5.fredericengland.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.fredericengland.exceptions.ErreurDeSerialisation;
import ca.cours5b5.fredericengland.global.GCommande;
import ca.cours5b5.fredericengland.global.GCouleur;
import ca.cours5b5.fredericengland.serialisation.AttributSerialisable;

public class MPartie extends Modele implements Fournisseur {

    @AttributSerialisable
    public MParametresPartie parametres;
    private final String __parametres = "parametres";

    private MGrille grille;
    private GCouleur couleurCourante;

    public MGrille getGrille() {
        return this.grille;
    }

    private void initialiserCouleurCourante () {

        this.couleurCourante = GCouleur.ROUGE;

    }

    private void fournirActionPlacerJeton() {

        ControleurAction.fournirAction(this, GCommande.JOUER_COUP_ICI, new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        jouerCoup((int) args[0]);

                    }
                });

    }

    protected void jouerCoup(int colonne) {

        grille.placerJeton(colonne, couleurCourante);

        prochaineCouleurCourante();

    }

    private void prochaineCouleurCourante() {

        if (this.couleurCourante != GCouleur.ROUGE) {

            this.couleurCourante = GCouleur.ROUGE;

        } else {

            this.couleurCourante = GCouleur.JAUNE;

        }

    }

    public MPartie (MParametresPartie parametres){

        this.parametres = parametres;

        this.grille = new MGrille(parametres.getLargeur());

        fournirActionPlacerJeton();

        initialiserCouleurCourante();

    }

    public MParametresPartie getParametres(){

        return this.parametres;

    }

    @Override
    public void aPartirObjectJson (Map<String, Object> objetJson){

    }

    @Override
    public Map<String, Object> enObjectJson() throws ErreurDeSerialisation {

        return null;

    }

}
