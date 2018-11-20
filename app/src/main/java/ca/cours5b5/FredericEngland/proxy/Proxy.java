package ca.cours5b5.FredericEngland.proxy;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public abstract class Proxy {

    private String chemin;

    protected DatabaseReference noeudServeur;

    public Proxy(String cheminServeur){ this.chemin = cheminServeur; }


    public void deconnecterDuServeur(){
        noeudServeur = null;
        detruireValeurs();

    }

    public abstract void detruireValeurs();

    public void connecterAuServeur(){
        noeudServeur = FirebaseDatabase.getInstance().getReference(chemin);
    }

}