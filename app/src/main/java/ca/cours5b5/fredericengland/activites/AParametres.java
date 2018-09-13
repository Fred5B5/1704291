package ca.cours5b5.fredericengland.activites;

import android.os.Bundle;
import android.util.Log;

import java.util.Map;

import ca.cours5b5.fredericengland.R;
import ca.cours5b5.fredericengland.modeles.MParametres;
import ca.cours5b5.fredericengland.serialisation.Jsonification;

public class AParametres extends Activite {

    static {
        Class currentClass = new Object() { }.getClass().getEnclosingClass();
        Log.i("MyApp",currentClass.getSimpleName() + "::static");
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.vxml_parametres);

        if(savedInstanceState != null) {

            String json = savedInstanceState.getString("MaCle");

            Map<String, Object> objetJson = Jsonification.enObjectJson(json);

            MParametres modele = new MParametres();

            modele.aPartirObjectJson(objetJson);

        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        Map<String, Object> objectJson = MParametres.instance.enObjectJson();

        String json = Jsonification.enChaine(objectJson);

        outState.putString("MaCle", json);

    }
}
