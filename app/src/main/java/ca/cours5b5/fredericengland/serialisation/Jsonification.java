package ca.cours5b5.fredericengland.serialisation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;

public class Jsonification {

    private static Gson gson = new Gson();


    public static Map<String, Object> enObjectJson(String json){

        return gson.fromJson(json, Map.class);

    }

    public static String enChaine(Map<String, Object> objectJson){

        return gson.toJson(objectJson);

    }

}
