package ca.cours5b5.fredericengland.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
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

    @Override
    protected void onFinishInflate(){

        super.onFinishInflate();

    }

    void creerGrille(int hauteur, int largeur){

        this.nombreRangees = hauteur;

        initialiserTableauDeCases(hauteur, largeur);

        ajouterEnTetes(largeur);

        ajouterCases(hauteur, largeur);

    }

    private void initialiserTableauDeCases(int hauteur, int largeur){

        this.lesCases = new VCase[hauteur][largeur];

    }

    private void ajouterEnTetes(int largeur) {

        this.entetes = new ArrayList<>();

        for ( int i = 0; i < largeur; i++ ) {

            this.entetes.add(new VEntete(getContext(), i));

        }

    }

    private LayoutParams getMiseEnPageEntete(int colonne){

        float poidsRangee = 2;

        float poidsColonne = 2;


        Spec specColonne = GridLayout.spec(colonne, poidsRangee);

        Spec specRangee = GridLayout.spec(0, poidsColonne);


        LayoutParams layout = new LayoutParams(specRangee, specColonne);


        layout.width = 0;

        layout.height = 0;

        layout.setGravity(Gravity.FILL);

        layout.rightMargin = 5;

        layout.leftMargin = 5;

        return layout;

    }

    private void ajouterCases(int hauteur, int largeur){

        for ( int i = 0; i < hauteur; i++ ) {

            for ( int i2 = 0; i2 < largeur; i2++ ) {

                lesCases[i][i2] = new VCase(getContext(), i, i2);

            }

        }

    }

    private LayoutParams getMiseEnPageCase(int rangee, int colonne){

        float poidsRangee = 0;

        float poidsColonne = 0;


        Spec specColonne = GridLayout.spec(colonne, poidsRangee);

        Spec specRangee = GridLayout.spec(rangee, poidsColonne);


        LayoutParams layout = new LayoutParams(specRangee, specColonne);


        layout.width = 0;

        layout.height = 0;

        layout.setGravity(Gravity.FILL);

        layout.rightMargin = 5;

        layout.leftMargin = 5;

        return layout;

    }

}
