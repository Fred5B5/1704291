package ca.cours5b5.FredericEngland.usagers;
import com.google.firebase.auth.FirebaseAuth;
import java.util.Objects;



public class UsagerCourant {


    public static String getId(){
        String id = "0";
        if (siUsagerConnecte()) {
            id = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid();
        }
        return id;
    }

    public static boolean siUsagerConnecte(){
        return (FirebaseAuth.getInstance().getCurrentUser() != null);
    }
}