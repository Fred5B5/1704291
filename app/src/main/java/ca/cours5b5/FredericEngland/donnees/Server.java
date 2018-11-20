package ca.cours5b5.FredericEngland.donnees;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.Map;
import ca.cours5b5.FredericEngland.serialisation.Jsonification;

public final class Server extends SourceDeDonnees {


    private Server(){}

    private static final Server instance = new Server();

    @Override
    public void detruireSauvegarde(String cheminSauvegarde) {
        DatabaseReference node = FirebaseDatabase.getInstance().getReference(cheminSauvegarde);
        node.removeValue();
    }

    public static Server getInstance() {
        return instance;
    }

    @Override
    public void sauvegarderModele(String cheminSauvegarde, Map<String, Object> objectJson) {
        Log.d("Atelier11", "sauvegarder modele");
        DatabaseReference node = FirebaseDatabase.getInstance().getReference(cheminSauvegarde);
        node.setValue(objectJson);
    }

    @Override
    public Map<String, Object> chargerModele(String cheminSauvegarde) {
        DatabaseReference node = FirebaseDatabase.getInstance().getReference(cheminSauvegarde);
        return Jsonification.aPartirChaineJson(node.toString());
    }

}