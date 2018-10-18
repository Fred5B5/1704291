package ca.cours5b5.fredericengland.modeles;

import java.util.HashMap;
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

        MParametresPartie parametresPartieCloner = new MParametresPartie();

        //TODO CHANGE STATIC FIELD USED AS PARAMETERS

        parametresPartieCloner.hauteur = mParametres.getHauteur();
        parametresPartieCloner.largeur = mParametres.getLargeur();
        parametresPartieCloner.pourGagner = mParametres.getPourGagner();

        return parametresPartieCloner;

    }

    public MParametresPartie cloner() {

        MParametresPartie parametresPartieCloner = new MParametresPartie();

        parametresPartieCloner.hauteur = this.getHauteur();
        parametresPartieCloner.largeur = this.getLargeur();
        parametresPartieCloner.pourGagner = this.getPourGagner();

        return parametresPartieCloner;

    }

    public MParametresPartie() {

    }

    public Integer getHauteur(){
        return this.hauteur;
    }
    public Integer getLargeur(){
        return this.largeur;
    }
    public Integer getPourGagner(){
        return this.pourGagner;
    }

    public void setHauteur(int hauteur){
        this.hauteur = hauteur;
    }
    public void setLargeur(int largeur){
        this.largeur = largeur;
    }
    public void setPourGagner(int pourGagner){
        this.pourGagner = pourGagner;
    }

    @Override
    public void aPartirObjectJson (Map<String, Object> objectJson){

        for(Map.Entry<String, Object> entry:objectJson.entrySet()) {

            if (entry.getKey().equals("__hauteur")){

                hauteur = Integer.parseInt(entry.getValue().toString());

            } else if (entry.getKey().equals("__largeur")){

                largeur = Integer.parseInt(entry.getValue().toString());

            } else if (entry.getKey().equals("__pourGagner")){

                pourGagner = Integer.parseInt(entry.getValue().toString());

            }

        }

    }

    @Override
    public Map<String, Object> enObjectJson() throws ErreurDeSerialisation{

        Map<String, Object> objectJson = new HashMap<>();

        objectJson.put( __hauteur, hauteur.toString());

        objectJson.put( __largeur, largeur.toString());

        objectJson.put( __pourGagner, pourGagner.toString());

        return objectJson;

    }

}
