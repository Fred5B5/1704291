package ca.cours5b5.fredericengland.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

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

    @Override
    protected void onFinishInflate() {

        super.onFinishInflate();

        observerPartie();

    }

    private void observerPartie(){

        ControleurObservation.observerModele(MParametres.class.getSimpleName(), new ListenerObservateur() {
            @Override
            public void reagirChangementAuModele(Modele modele) {



            }
        });

    }

    private MPartie getPartie(Modele modele){

        return (MPartie) modele;

    }

    private void initialiserGrille(MPartie partie){



    }

}
