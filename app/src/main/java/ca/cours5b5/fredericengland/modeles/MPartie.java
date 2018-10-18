package ca.cours5b5.fredericengland.modeles;

import java.util.Map;

import ca.cours5b5.fredericengland.exceptions.ErreurDeSerialisation;
import ca.cours5b5.fredericengland.global.GCouleur;
import ca.cours5b5.fredericengland.serialisation.AttributSerialisable;

public class MPartie extends Modele {

    @AttributSerialisable
    public MParametresPartie parametres;
    private final String __parametres = "parametres";

    private MGrille grille;
    private GCouleur couleurCourante;

    public MGrille getGrille() {
        return this.grille;
    }

    private void initialiserCouleurCourante () {



    }

    private void fournirActionPlacerJeton() {



    }

    protected void jouerCoup(int colonne) {



    }

    private void prochaineCouleurCourante() {



    }

    public MPartie (MParametresPartie parametres){

        this.parametres = parametres;

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
