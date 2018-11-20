package ca.cours5b5.FredericEngland.modeles;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ca.cours5b5.FredericEngland.exceptions.ErreurSerialisation;
import ca.cours5b5.FredericEngland.global.GCouleur;
import ca.cours5b5.FredericEngland.global.GDirection;


public class MGrille extends Modele  {

    private List<MColonne> colonnes;

    public MGrille(int largeur){

        colonnes = new ArrayList<>();

        initialiserColonnes(largeur);

    }

    private void initialiserColonnes(int largeur) {

        for(int i=0; i<largeur; i++){

            colonnes.add(new MColonne());

        }
    }


    public List<MColonne> getColonnes() {
        return colonnes;
    }


    public void placerJeton(int colonne, GCouleur couleur) {

        colonnes.get(colonne).placerJeton(couleur);

    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurSerialisation {

        throw new UnsupportedOperationException();

    }

    @Override
    public Map<String, Object> enObjetJson() throws ErreurSerialisation {

        throw new UnsupportedOperationException();

    }

    public boolean siCouleurGagne(GCouleur couleur, int pourGagner){

        boolean couleurGagne = false;

        for (int i = 0; i < colonnes.size(); i++){

            if(siCouleurGagneCetteColonne(couleur, i, pourGagner)){

                couleurGagne = true;

                break;

            }

        }

        return couleurGagne;

    }

    public boolean siCouleurGagneCetteCase(GCouleur couleur, int idColonne, int idRangee, int pourGagner){

        boolean couleurGagne = false;

        for (GDirection direction : GDirection.directions) {

            if(siCouleurGagneDansCetteDirection(couleur,idColonne, idRangee, direction, pourGagner)){

                couleurGagne = true;

                break;

            }

        }

        return couleurGagne;
    }

    public boolean siCouleurGagneDansCetteDirection(GCouleur couleur, int idColonne, int idRangee, GDirection direction, int pourGagner){
        boolean couleurGagner = true;

        for(int i = 0; i < pourGagner; i++){

            int collone = i * direction.incrementHorizontal + idColonne;

            int range = i * direction.incrementVertical + idRangee;

            if(!siMemeCouleurCetteCase(couleur, collone, range)){

                couleurGagner = false;

                break;
            }
        }
        return couleurGagner;
    }


    public boolean siCouleurGagneCetteColonne(GCouleur couleur, int idColonne, int pourGagner){

        boolean couleurGagne = false;

        MColonne colonne = colonnes.get(idColonne);

        for (int i = 0; i < colonne.getJetons().size(); i++){

            if(siCouleurGagneCetteCase(couleur, idColonne, i, pourGagner)){

                couleurGagne = true;

                break;
            }
        }

        return couleurGagne;
    }

    public boolean siMemeCouleurCetteCase(GCouleur couleur, int idColonne, int idRangee){

        boolean memeCouleur = false;

        if(idColonne < colonnes.size() && idColonne >= 0 && colonnes.get(idColonne).getJetons().size() > idRangee && idRangee >= 0){

            memeCouleur = colonnes.get(idColonne).getJetons().get(idRangee) == couleur;

        }

        return memeCouleur;
    }

}
