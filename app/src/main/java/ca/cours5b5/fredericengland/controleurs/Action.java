package ca.cours5b5.fredericengland.controleurs;

import android.util.Log;

import ca.cours5b5.fredericengland.controleurs.interfaces.Fournisseur;
import ca.cours5b5.fredericengland.controleurs.interfaces.ListenerFournisseur;

public class Action {

    Fournisseur fournisseur;

    ListenerFournisseur listenerFournisseur;

    Object[] args;

    public void setArguments(Object... args){

        this.args = args;

    }

    public void executerDesQuePossible(){

        Log.i("MyApp",getClass().getSimpleName() + ".executerDesQuePossible");

        ControleurAction.executerDesQuePossible(this);

    }

    Action cloner() {

        return this.cloner();

    }

}
