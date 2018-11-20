package ca.cours5b5.FredericEngland.donnees;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

import ca.cours5b5.FredericEngland.controleurs.interfaces.ListenerChargement;
import ca.cours5b5.FredericEngland.exceptions.ErreurModele;
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
    public void chargerModele(final String cheminSauvegarde, final ListenerChargement listenerChargement) {

        DatabaseReference node = FirebaseDatabase.getInstance().getReference(cheminSauvegarde);

        node.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists()){

                    Map<String, Object> objetJson = (Map<String, Object>) dataSnapshot.getValue();

                    listenerChargement.reagirSucces(objetJson);

                }else{

                    listenerChargement.reagirErreur(new ErreurModele("Clé pas trouver"));

                }
            }


            @Override

            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

}