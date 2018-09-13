package ca.cours5b5.fredericengland.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

public class VAcceuil extends Vue {

    static {
        Class currentClass = new Object() { }.getClass().getEnclosingClass();
        Log.i("MyApp",currentClass.getSimpleName() + "::static");
    }

    public VAcceuil (Context context) {

        super(context);

    }

    public VAcceuil (Context context, AttributeSet attrs) {

        super(context, attrs);

    }

    public VAcceuil (Context context, AttributeSet attrs, int defStyleAttr) {

        super(context, attrs, defStyleAttr);

    }

}
