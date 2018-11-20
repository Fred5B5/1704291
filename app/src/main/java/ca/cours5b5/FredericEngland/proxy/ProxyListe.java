package ca.cours5b5.FredericEngland.proxy;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.FredericEngland.controleurs.Action;
import ca.cours5b5.FredericEngland.controleurs.ControleurAction;
import ca.cours5b5.FredericEngland.controleurs.interfaces.Fournisseur;
import ca.cours5b5.FredericEngland.global.GCommande;
import ca.cours5b5.FredericEngland.global.GConstantes;

public class ProxyListe extends Proxy implements Fournisseur {

    private ChildEventListener childEventListener;
    private Query requete;
    private Action actionNouvelItem;
    private List<DatabaseReference> noeudsAjoutes;

    public ProxyListe(String cheminServeur) {
        super(cheminServeur);
        noeudsAjoutes = new ArrayList<>();
    }

    public void setActionNouvelItem(GCommande commande){
        actionNouvelItem = ControleurAction.demanderAction(commande);
    }

    public void ajouterValeur(Object valeur) {
        DatabaseReference node = super.noeudServeur.push();
        node.setValue(valeur);
        noeudsAjoutes.add(node);

    }

    @Override
    public void connecterAuServeur(){

        super.connecterAuServeur();

        creerListener();
        requete = getRequete();
        requete.addChildEventListener(childEventListener);

    }

    @Override
    public void deconnecterDuServeur() {
        super.deconnecterDuServeur();
        requete.removeEventListener(childEventListener);
    }

    private void creerListener(){

        childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(actionNouvelItem != null){
                    actionNouvelItem.setArguments(dataSnapshot.getValue());
                    actionNouvelItem.executerDesQuePossible();

                }
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }
        };

    }

    @Override
    public void detruireValeurs() {

        for (DatabaseReference node: noeudsAjoutes) {
            node.removeValue();
        }
    }

    protected Query getRequete(){
        return super.noeudServeur.orderByKey().limitToFirst(GConstantes.NOMBRE_DE_VALEURS_A_CHARGER_DU_SERVEUR_PAR_DEFAUT);
    }



}