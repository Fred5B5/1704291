package ca.cours5b5.fredericengland.controleurs.interfaces;

import ca.cours5b5.fredericengland.modeles.Modele;

public abstract class ListenerObservateur {

    public void reagirNouveauModele ( Modele modele) {



    }

    public abstract void reagirChangementAuModele ( Modele modele );

}
