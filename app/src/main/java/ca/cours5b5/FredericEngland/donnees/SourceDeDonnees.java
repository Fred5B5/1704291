package ca.cours5b5.FredericEngland.donnees;

import java.util.Map;

import ca.cours5b5.FredericEngland.controleurs.interfaces.ListenerChargement;


public abstract class SourceDeDonnees {

    public abstract void chargerModele(final String cheminSauvegarde, final ListenerChargement listenerChargement);
    public abstract void detruireSauvegarde(String cheminSauvegarde);

    public abstract void sauvegarderModele(final String cheminSauvegarde, final Map<String, Object> objetJson);

    protected String getNomModele(String cheminSauvegarde){
        return cheminSauvegarde.split("/")[0];
    }

}
