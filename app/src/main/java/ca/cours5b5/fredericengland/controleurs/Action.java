package ca.cours5b5.fredericengland.controleurs;

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

        ControleurAction.executerDesQuePossible(this);

    }

    Action cloner() {

        return this.cloner();

    }

}
