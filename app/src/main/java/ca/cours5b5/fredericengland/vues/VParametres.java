package ca.cours5b5.fredericengland.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

import ca.cours5b5.fredericengland.R;
import ca.cours5b5.fredericengland.modeles.MParametres;
import ca.cours5b5.fredericengland.global.GConstantes;

public class VParametres extends Vue {

    static {
        Class currentClass = new Object() { }.getClass().getEnclosingClass();
        Log.i("MyApp",currentClass.getSimpleName() + "::static");
    }

    public VParametres (Context context) {

        super(context);

    }

    public VParametres (Context context, AttributeSet attrs) {

        super(context, attrs);

    }

    public VParametres (Context context, AttributeSet attrs, int defStyleAttr) {

        super(context, attrs, defStyleAttr);

    }

    protected void onFinishInflate() {
        super.onFinishInflate();

        Spinner spn_hauteur = this.findViewById(R.id.spn_hauteur);
        ArrayList<Integer> choixHauteur = (ArrayList<Integer>) MParametres.instance.getChoixHauteur();

        ArrayAdapter<Integer> adapter_hauteur = new ArrayAdapter<>(getContext(),  R.layout.support_simple_spinner_dropdown_item, choixHauteur);
        adapter_hauteur.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);

        spn_hauteur.setAdapter(adapter_hauteur);

        spn_hauteur.setSelection(MParametres.instance.hauteur - GConstantes.hauteurMin);

        Spinner spn_largeur = this.findViewById(R.id.spn_largeur);
        ArrayList<Integer> choixLargeur = (ArrayList<Integer>) MParametres.instance.getChoixLargeur();

        ArrayAdapter<Integer> adapter_largeur = new ArrayAdapter<>(getContext(),  R.layout.support_simple_spinner_dropdown_item, choixLargeur);
        adapter_largeur.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);

        spn_largeur.setAdapter(adapter_largeur);

        spn_largeur.setSelection(MParametres.instance.largeur - GConstantes.largeurMin);

        Spinner spn_pourgagner = this.findViewById(R.id.spn_pourgagner);
        ArrayList<Integer> choixPourGagner = (ArrayList<Integer>) MParametres.instance.getChoixPourGagner();

        ArrayAdapter<Integer> adapter_PourGagner = new ArrayAdapter<>(getContext(),  R.layout.support_simple_spinner_dropdown_item, choixPourGagner);
        adapter_PourGagner.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);

        spn_pourgagner.setAdapter(adapter_PourGagner);

        spn_pourgagner.setSelection(MParametres.instance.pourGagner - GConstantes.pourGagnerMin);


        spn_hauteur.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Integer choix = (Integer) parent.getAdapter().getItem(position);

                MParametres.instance.setHauteur(choix);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spn_largeur.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Integer choix = (Integer) parent.getAdapter().getItem(position);

                MParametres.instance.setLargeur(choix);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spn_pourgagner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Integer choix = (Integer) parent.getAdapter().getItem(position);

                MParametres.instance.setPourGagner(choix);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

}