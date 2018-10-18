package ca.cours5b5.fredericengland.vues;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import ca.cours5b5.fredericengland.global.GCouleur;

public class VCase extends AppCompatButton {

    public VCase (Context context) {

        super(context);

    }

    public VCase (Context context, AttributeSet attrs) {

        super(context, attrs);

    }

    public VCase (Context context, AttributeSet attrs, int defStyleAttr) {

        super(context, attrs, defStyleAttr);

    }

    public VCase(Context context, int rangee, int colonne){

        super(context);

        String texte = rangee + "," + colonne;

        setText(texte);

    }

    public void afficherJeton(GCouleur jeton){

    }

}
