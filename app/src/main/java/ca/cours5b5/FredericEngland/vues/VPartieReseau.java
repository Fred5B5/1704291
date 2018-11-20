package ca.cours5b5.FredericEngland.vues;

import android.content.Context;
import android.util.AttributeSet;

import ca.cours5b5.FredericEngland.modeles.MPartieReseau;

public class VPartieReseau extends VPartie{

    public VPartieReseau(Context context, AttributeSet attrs) {

        super(context, attrs);

    }


    public VPartieReseau(Context context, AttributeSet attrs, int defStyleAttr) {

        super(context, attrs, defStyleAttr);

    }

    public VPartieReseau(Context context) {


        super(context);

    }

    @Override
    protected String getNomModele(){

        return MPartieReseau.class.getSimpleName();

    }

}