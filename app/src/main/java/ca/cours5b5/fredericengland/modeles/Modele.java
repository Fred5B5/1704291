package ca.cours5b5.fredericengland.modeles;

import java.util.Map;

public abstract class Modele {
    public abstract void aPartirObjectJson(Map<String, Object> objectJson);
    public abstract Map<String, Object> enObjectJson();
}
