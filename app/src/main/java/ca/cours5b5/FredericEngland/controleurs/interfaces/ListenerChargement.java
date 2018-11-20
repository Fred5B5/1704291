package ca.cours5b5.FredericEngland.controleurs.interfaces;


import java.util.Map;

public interface ListenerChargement {

    void reagirSucces(Map<String, Object> objetJson);
    void reagirErreur(Exception ex);

}