package ca.cours5b5.fredericengland.modeles;

import java.util.List;
import java.util.Map;

import ca.cours5b5.fredericengland.exceptions.ErreurDeSerialisation;
import ca.cours5b5.fredericengland.global.GCouleur;

public class MColonne extends Modele {

    private List<GCouleur> jetons;

    public MColonne(){

    }

    @Override
    public void aPartirObjectJson(Map<String, Object> objectJson) throws ErreurDeSerialisation {

    }

    @Override
    public Map<String, Object> enObjectJson() throws ErreurDeSerialisation {

    }

}
