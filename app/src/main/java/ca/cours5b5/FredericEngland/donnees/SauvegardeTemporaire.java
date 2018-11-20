package ca.cours5b5.FredericEngland.donnees;

import android.os.Bundle;

import java.util.Map;


import ca.cours5b5.FredericEngland.controleurs.interfaces.ListenerChargement;
import ca.cours5b5.FredericEngland.exceptions.ErreurModele;
import ca.cours5b5.FredericEngland.serialisation.Jsonification;

public class SauvegardeTemporaire extends SourceDeDonnees {

    private Bundle bundle;

    public SauvegardeTemporaire(Bundle bundle){
        this.bundle = bundle;
    }

    @Override
    public void detruireSauvegarde(String cheminSauvegarde) {
        bundle.remove(cheminSauvegarde);
    }

    @Override
    public void chargerModele(final String cheminSauvegarde, final ListenerChargement listenerChargement) {

        String cle = getCle(cheminSauvegarde);

        try {

            if(bundle != null && bundle.containsKey(cle)){

                String json = bundle.getString(cle);

                Map<String, Object> objetJson = Jsonification.aPartirChaineJson(json);

                listenerChargement.reagirSucces(objetJson);

            }else{

                listenerChargement.reagirErreur(new ErreurModele("Clé pas trouver"));

            }

        }catch (Exception ex){

            listenerChargement.reagirErreur(ex);

        }
    }

    @Override
    public void sauvegarderModele(String cheminSauvegarde, Map<String, Object> objetJson) {
        if(bundle != null){

            String json = Jsonification.enChaineJson(objetJson);
            bundle.putString(cheminSauvegarde, json);

        }
    }

    private String getCle(String cheminSauvegarde){

        String[] CheminSauvegarde = cheminSauvegarde.split("/");

        return CheminSauvegarde[0];
    }

}