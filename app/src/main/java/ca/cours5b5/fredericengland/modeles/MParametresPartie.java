package ca.cours5b5.fredericengland.modeles;

import java.util.Map;

import ca.cours5b5.fredericengland.exceptions.ErreurDeSerialisation;
import ca.cours5b5.fredericengland.serialisation.AttributSerialisable;

public class MParametresPartie extends Modele {

    @AttributSerialisable
    public Integer hauteur;
    protected final String __hauteur = "hauteur";

    @AttributSerialisable
    public Integer largeur;
    protected final String __largeur = "largeur";

    @AttributSerialisable
    public Integer pourGagner;
    protected final String __pourGagner = "pourGagner";

    public static MParametresPartie aPartirMParametres ( MParametres mParametres ) {



    }

    public MParametresPartie cloner() {



    }

    public MParametresPartie() {

    }

    public Integer getHauteur(){

    }
    public Integer getLargeur(){

    }
    public Integer getPourGagner(){

    }

    public void setHauteur(int hauteur){

    }
    public void setLargeur(int largeur){

    }
    public void setPourGagner(int pourGagner){

    }

    @Override
    public void aPartirObjectJson (Map<String, Object> objetJson){

    }

    @Override
    public Map<String, Object> enObjectJson() throws ErreurDeSerialisation{

    }

}
