package ca.cours5b5.fredericengland.activites;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import ca.cours5b5.fredericengland.R;

public class AAcceuil extends Activite {

    static {
        Class currentClass = new Object() { }.getClass().getEnclosingClass();
        Log.i("MyApp",currentClass.getSimpleName() + "::static");
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.vxml_acceuil);

        Button boutonsParametres = this.findViewById(R.id.btn_parametres);
        boutonsParametres.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View v) {

                Intent monIntent = new Intent(AAcceuil.this, AParametres.class);
                startActivity(monIntent);

            }

        });
    }

}
