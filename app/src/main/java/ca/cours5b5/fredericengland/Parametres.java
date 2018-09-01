package ca.cours5b5.fredericengland;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Parametres extends AppCompatActivity {

    //@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);
        Log.d("MonEtiquette",this.getResources().getString(R.string.AcceuilBonjour));

        if (this.getResources().getBoolean(R.bool.is_portrait)) {

            Log.d("MonEtiquette",this.getResources().getString(R.string.BonjourPortrait));

        } else {

            Log.d("MonEtiquette",this.getResources().getString(R.string.BonjourPaysage));

        }

    }
}
