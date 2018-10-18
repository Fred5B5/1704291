package ca.cours5b5.fredericengland.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.fredericengland.controleurs.Action;
import ca.cours5b5.fredericengland.controleurs.ControleurAction;
import ca.cours5b5.fredericengland.global.GCommande;
import ca.cours5b5.fredericengland.global.GCouleur;
import ca.cours5b5.fredericengland.modeles.MGrille;

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

    private Action jouerJeton;

    private VCase[][] lesCases;

    protected void onFinishInflate(){

        super.onFinishInflate();

    }

    private void demanderActionEntete(){

        jouerJeton = ControleurAction.demanderAction(GCommande.JOUER_COUP_ICI);

    }

    private void installerListenerEntete(VEntete entete, final int colonne){

        entete.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                demanderActionEntete();

                jouerJeton.setArguments(colonne);
                jouerJeton.executerDesQuePossible();

            }
        });

    }

    void afficherJetons(MGrille grille){

        for(int i = 0; i < grille.getColonnes().size(); i++){
            for(int i2 = 0; i2 < grille.getColonnes().get(i).getJetons().size(); i2++){

                afficherJeton( lesCases.length - 1 - i2, i, grille.getColonnes().get(i).getJetons().get(i2));

            }
        }

    }

    private void afficherJeton(int colonne, int rangee, GCouleur jeton){

        this.lesCases[colonne][rangee].afficherJeton(jeton);

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

            addView(entetes.get(entetes.size() - 1), getMiseEnPageEntete(i));

            installerListenerEntete(entetes.get(entetes.size() - 1), i);

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

                lesCases[i][i2] = new VCase(getContext(), hauteur - i - 1, i2);

                addView(lesCases[i][i2], getMiseEnPageCase(i + 1, i2));

            }

        }

    }

    private LayoutParams getMiseEnPageCase(int rangee, int colonne){

        float poidsRangee = 1;

        float poidsColonne = 1;


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
