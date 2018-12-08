package com.example.med.tp3;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class Samsung extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final ListView maListViewPerso;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listeview_phone);
        // Récupération de la "ListView" créée dans le fichier activity_listeview_phone.xmlw_phone.xml
        maListViewPerso = findViewById(R.id.listviewperso);

        // Création de la "ArrayList" qui nous permettra de remplir la "ListView"
        ArrayList<HashMap<String, String>> listItem = new ArrayList<>();

        // On déclare la "HashMap" qui contiendra les informations pour un item
        HashMap<String, String> map;

        // Création d'une "HashMap" pour insérer les informations du premier item de notre "ListView"
        map = new HashMap<>();
        // On insère un élément "titre" que l'on récupérera dans le "TextView titre" créé dans le fichier affichage_item.xml
        map.put("name", "Samsung j7");
        // On insère un élément "prix" que l'on récupérera dans le "TextView titre" créé dans le fichier affichage_item.xml
        map.put("prix", "299 €");
        // On insère la "référence" à l'image (convertit en String car normalement c'est un int) que l'on récupérera dans le "ImageView" créé dans le fichier affichage_item.xml
        map.put("img", String.valueOf(R.drawable.samsungj7));
        // Enfin on ajoute cette "HashMap" dans la "ArrayList"
        listItem.add(map);

        // On refait la manip plusieurs fois avec des données différentes pour former les items de notre "ListView"

        map = new HashMap<>();
        map.put("name", "samsung galaxy S9");
        map.put("prix", "959 €");
        map.put("img", String.valueOf(R.drawable.samsunggalaxys9));
        listItem.add(map);

        map = new HashMap<>();
        map.put("name", "samsung galaxy a7");
        map.put("prix", "307 €");
        map.put("img", String.valueOf(R.drawable.samsunggalaxya7));
        listItem.add(map);



        // Création d'un SimpleAdapter qui se chargera de mettre les items présents dans notre liste (listItem) dans la vue affichage_item
        SimpleAdapter adapter = new SimpleAdapter (this.getBaseContext(),
                listItem,
                R.layout.activity_item_phone,
                new String[] { "img","name", "prix"},
                new int[] { R.id.img,R.id.name, R.id.prix});

        // On attribue à notre "ListView" l'adapter que l'on vient de créer
        maListViewPerso.setAdapter(adapter);

        maListViewPerso.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            @SuppressWarnings("unchecked")
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // On récupère la "HashMap" contenant les infos de notre item (titre, description, img)
                HashMap<String, String> map = (HashMap<String, String>) maListViewPerso.getItemAtPosition(position);

                // On crée une boite de dialogue
                AlertDialog.Builder adb = new AlertDialog.Builder(Samsung.this);
                // On attribue un titre à notre boite de dialogue
                adb.setTitle("Sélection Item");
                // On insère un message à notre boite de dialogue, et ici on affiche le titre de l'item cliqué
                adb.setMessage("Votre choix : " + map.get("name"));
                // On indique que l'on veut le bouton "ok" à notre boite de dialogue
                adb.setPositiveButton("Ok", null);
                // On affiche la boite de dialogue
                adb.show();
                return true;
            }
        });

        maListViewPerso.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            @SuppressWarnings("unchecked")
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // On récupère la "HashMap" contenant les infos de notre item (titre, description, img)
                HashMap<String, String> map = (HashMap<String, String>) maListViewPerso.getItemAtPosition(position);
                Toast.makeText(Samsung.this, map.get("name"), Toast.LENGTH_LONG).show();
            }
        });
        final Context context = Samsung.this;



        maListViewPerso.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            @SuppressWarnings("unchecked")
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                HashMap<String, String> map = (HashMap<String, String>) maListViewPerso.getItemAtPosition(position);

                AlertDialog.Builder adb;
                adb = new AlertDialog.Builder(context);
                adb.setTitle(map.get("name"));
                adb.setMessage("caracteristique: " );

                adb.setPositiveButton("Acheter", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(context, AchatActivity.class);

                        startActivity(intent);
                    }
                });
                adb.show();
            }
        });
    }
}
