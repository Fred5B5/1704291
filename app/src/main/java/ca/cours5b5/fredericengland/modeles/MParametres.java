package ca.cours5b5.fredericengland.modeles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.cours5b5.fredericengland.serialisation.AttributSerialisable;
import ca.cours5b5.fredericengland.global.GConstantes;

public class MParametres extends Modele {

    public static MParametres instance = new MParametres();

    private Integer hauteur = GConstantes.hauteurDeBase;

    private Integer largeur = GConstantes.largeurDeBase;

    private Integer pourGagner = GConstantes.pourGagnerDeBase;

    public Integer getHauteur () {

        return this.hauteur;

    }
    public Integer getLargeur () {

        return this.largeur;

    }
    public Integer getPourGagner () {

        return this.pourGagner;

    }

    public List<Integer> getChoixHauteur(){

        List<Integer> choixHauteur = new ArrayList<>();

        for (int i = 4; i < 11; i++){

            choixHauteur.add(i);

        }

        return choixHauteur;
    }

    public List<Integer> getChoixLargeur(){

        List<Integer> choixLargeur = new ArrayList<>();

        for (int i = 4; i < 11; i++){

            choixLargeur.add(i);

        }

        return choixLargeur;

    }

    public List<Integer> getChoixPourGagner(){

        List<Integer> choixPourGagner = new ArrayList<>();

        for (int i = 3; i < 5; i++){

            choixPourGagner.add(i);

        }

        return choixPourGagner;

    }

    public void setHauteur(Integer hauteur) {
        this.hauteur = hauteur;
    }

    public void setLargeur(Integer largeur) {
        this.largeur = largeur;
    }

    public void setPourGagner(Integer pourGagner) {
        this.pourGagner = pourGagner;
    }

    @Override
    public void aPartirObjectJson(Map<String, Object>objectJson){

    }

    @Override
    public Map<String, Object> enObjectJson(){

        return null;

    }

}
