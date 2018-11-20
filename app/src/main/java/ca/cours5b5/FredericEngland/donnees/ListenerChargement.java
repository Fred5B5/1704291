package ca.cours5b5.FredericEngland.donnees;

import java.util.Map;

public interface ListenerChargement {

    void reagirErreur(Exception ex);

    void reagirSucces(Map<String, Object> objetJson);

}