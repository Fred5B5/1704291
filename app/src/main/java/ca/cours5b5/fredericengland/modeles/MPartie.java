package ca.cours5b5.fredericengland.modeles;

import java.util.Map;

import ca.cours5b5.fredericengland.exceptions.ErreurDeSerialisation;
import ca.cours5b5.fredericengland.serialisation.AttributSerialisable;

public class MPartie extends Modele {

    @AttributSerialisable
    public MParametresPartie parametres;
    private final String __parametres = "parametres";

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
