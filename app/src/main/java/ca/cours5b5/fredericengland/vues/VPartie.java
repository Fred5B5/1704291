package ca.cours5b5.fredericengland.vues;

import android.content.Context;
import android.util.AttributeSet;

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

    }

    private observerPartie(){



    }

    private MPartie getPartie(Modele modele){



    }

    private void initialiserGrille(MPartie partie){



    }

}
