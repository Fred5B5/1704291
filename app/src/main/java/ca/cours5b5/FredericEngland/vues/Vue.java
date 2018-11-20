package ca.cours5b5.FredericEngland.vues;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.util.AttributeSet;
import android.view.View;

import ca.cours5b5.FredericEngland.controleurs.ControleurAction;
import ca.cours5b5.FredericEngland.controleurs.interfaces.Fournisseur;
import ca.cours5b5.FredericEngland.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.FredericEngland.global.GCommande;


public abstract class Vue extends ConstraintLayout implements Fournisseur {

    public Vue(Context context) {
        super(context);
    }

    public Vue(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Vue(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate(){

        super.onFinishInflate();

        ControleurAction.fournirAction(this, GCommande.AFFICHAGE_SNACKBAR, new ListenerFournisseur() {

            @Override
            public void executer(Object... args) {
                Snackbar fenetreMessage = Snackbar.make(Vue.this, "Le joueur " + args[0].toString() + " a gagné la partie.", Snackbar.LENGTH_SHORT);

                fenetreMessage.show();
            }
        });
    }

}
