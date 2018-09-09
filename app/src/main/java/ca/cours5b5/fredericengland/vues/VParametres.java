package ca.cours5b5.fredericengland.vues;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import ca.cours5b5.fredericengland.R;

public class VParametres extends ConstraintLayout {

    public VParametres (Context context) {

        super(context);

    }

    public VParametres (Context context, AttributeSet attrs) {

        super(context, attrs);

    }

    public VParametres (Context context, AttributeSet attrs, int defStyleAttr) {

        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        Spinner spn_hauteur = this.findViewById(R.id.spn_hauteur);
        ArrayAdapter<Integer> adapter_hauteur = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);

        spn_hauteur.setAdapter(adapter_hauteur);
        for (int i = 4; i < 11; i++){

            adapter_hauteur.add(i);

        }

        spn_hauteur.setSelection(2);

        Spinner spn_largeur = this.findViewById(R.id.spn_largeur);
        ArrayAdapter<Integer> adapter_largeur = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);

        spn_largeur.setAdapter(adapter_largeur);
        for (int i = 4; i < 11; i++){

            adapter_largeur.add(i);

        }

        spn_largeur.setSelection(3);

        Spinner spn_pourgagner = this.findViewById(R.id.spn_pourgagner);
        ArrayAdapter<Integer> adapter_pourgagner = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);

        spn_pourgagner.setAdapter(adapter_pourgagner);
        for (int i = 3; i < 5; i++){

            adapter_pourgagner.add(i);

        }

        spn_pourgagner.setSelection(1);
    }

}