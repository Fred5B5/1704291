package ca.cours5b5.fredericengland.modeles;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ca.cours5b5.fredericengland.exceptions.ErreurDeSerialisation;
import ca.cours5b5.fredericengland.global.GCouleur;

public class MGrille extends Modele {

    private List<MColonne> colonnes;

    public MGrille(int largeur){
        initialiserColonnes(largeur);
    }

    private void initialiserColonnes(int largeur){

        colonnes = new ArrayList<>();

        for (int i = 0; i < largeur; i++) {

            colonnes.add(new MColonne());

        }

    }

    public List<MColonne> getColonnes(){

        return this.colonnes;

    }

    public void placerJeton(int colonne, GCouleur couleur){

        colonnes.get(colonne).placerJeton(couleur);

    }

    @Override
    public void aPartirObjectJson(Map<String, Object> objectJson) throws ErreurDeSerialisation {
    }

    @Override
    public Map<String, Object> enObjectJson() throws ErreurDeSerialisation {
        return null;
    }

}
