package ca.cours5b5.fredericengland.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

public class VGrille extends GridLayout {

    public VGrille (Context context) {

        super(context);

    }

    public VGrille (Context context, AttributeSet attrs) {

        super(context, attrs);

    }

    public VGrille (Context context, AttributeSet attrs, int defStyleAttr) {

        super(context, attrs, defStyleAttr);

    }

    private int nombreRangees;

    private List<VEntete> entetes;

    private VCase[][] lesCases;

    private class Colonne extends ArrayList<VCase> {

    }

    private List<Colonne> colonnesDeCases;

    @Override
    protected void onFinishInflate(){

        super.onFinishInflate();

    }

    void creerGrille(int hauteur, int largeur){

    }

    private void initialiserTableauDeCases(int hauteur, int largeur){

    }

    private void initialiserColonnes(int largeur){

    }

    private void LayoutParams getMiseEnPageEntete(int colonne){

    }

    private void ajouterCases(int hauteur, int largeur){
        
    }

    private void LayoutParams getMiseEnPageCase(int rangee, int colonne){

    }

}
