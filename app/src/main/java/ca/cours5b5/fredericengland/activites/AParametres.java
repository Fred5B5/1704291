package ca.cours5b5.fredericengland.activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import ca.cours5b5.fredericengland.R;

public class AParametres extends Activite {

    static {
        Class currentClass = new Object() { }.getClass().getEnclosingClass();
        Log.i("MyApp",currentClass.getSimpleName() + "::static");
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.vxml_parametres);


    }
}
