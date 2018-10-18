package ca.cours5b5.fredericengland.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

import ca.cours5b5.fredericengland.R;
import ca.cours5b5.fredericengland.controleurs.ControleurObservation;
import ca.cours5b5.fredericengland.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.fredericengland.modeles.MParametres;
import ca.cours5b5.fredericengland.modeles.MPartie;
import ca.cours5b5.fredericengland.modeles.Modele;

public class VPartie extends Vue {

    private VGrille grille;

    public VPartie (Context context) {

        super(context);

    }

    public VPartie (Context context, AttributeSet attrs) {

        super(context, attrs);

    }

    public VPartie (Context context, AttributeSet attrs, int defStyleAttr) {

        super(context, attrs, defStyleAttr);

    }

    protected void onFinishInflate() {

        super.onFinishInflate();

        this.grille = this.findViewById(R.id.gridlayout_Partie);

        observerPartie();

    }

    private void observerPartie(){

        ControleurObservation.observerModele(MPartie.class.getSimpleName(), new ListenerObservateur() {
            @Override
            public void reagirNouveauModele(Modele modele) {

                Log.i("MyApp",getClass().getSimpleName() + "::reagirNouveauModele");

                initialiserGrille((MPartie) modele);

                super.reagirNouveauModele(modele);

            }
            @Override
            public void reagirChangementAuModele(Modele modele) {

                miseAJourGrille((MPartie) modele);

            }
        });

    }

    private void miseAJourGrille(MPartie partie){

        grille.afficherJetons(partie.getGrille());

    }

    private MPartie getPartie(Modele modele){

        return (MPartie) modele;

    }

    private void initialiserGrille(MPartie partie){

        this.grille.creerGrille(partie.parametres.hauteur, partie.parametres.largeur);

    }

}
