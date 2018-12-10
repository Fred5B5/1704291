package ca.cours5b5.FredericEngland.vues;

import android.content.Context;
import android.util.AttributeSet;

import ca.cours5b5.FredericEngland.R;
import ca.cours5b5.FredericEngland.controleurs.ControleurObservation;
import ca.cours5b5.FredericEngland.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.FredericEngland.exceptions.ErreurObservation;
import ca.cours5b5.FredericEngland.modeles.MParametresPartie;
import ca.cours5b5.FredericEngland.modeles.MPartie;
import ca.cours5b5.FredericEngland.modeles.MPartieReseau;
import ca.cours5b5.FredericEngland.modeles.Modele;


public class VPartieReseau extends VPartie {


    private VGrille grille;


    public VPartieReseau(Context context) {
        super(context);
    }

    public VPartieReseau(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VPartieReseau(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected String getNomModele(){
        return MPartieReseau.class.getSimpleName();
    }

}
