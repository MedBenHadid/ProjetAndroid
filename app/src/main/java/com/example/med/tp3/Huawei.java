package com.example.med.tp3;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class Huawei extends AppCompatActivity {
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final ListView maListViewPerso;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listeview_phone);



        maListViewPerso = findViewById(R.id.listviewperso);


        ArrayList<HashMap<String, String>> listItem = new ArrayList<>();


        HashMap<String, String> map;


        map = new HashMap<>();

        map.put("name", "huawei p9 lite");
        map.put("prix", "190 €");
        map.put("img", String.valueOf(R.drawable.huaweip9lite));
        listItem.add(map);



        map = new HashMap<>();
        map.put("name", "huawei nova 3i");
        map.put("prix", "254  €");
        map.put("img", String.valueOf(R.drawable.huaweinova3i));
        listItem.add(map);

        map = new HashMap<>();
        map.put("name", "huawei mate 20 pro");
        map.put("prix", "799 €");
        map.put("img", String.valueOf(R.drawable.huawei_mate_20_pro));
        listItem.add(map);


        SimpleAdapter adapter = new SimpleAdapter(this.getBaseContext(),
                listItem,
                R.layout.activity_item_phone,
                new String[]{"img", "name", "prix"},
                new int[]{R.id.img, R.id.name, R.id.prix});

        maListViewPerso.setAdapter(adapter);


        maListViewPerso.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            @SuppressWarnings("unchecked")
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // On récupère la "HashMap" contenant les infos de notre item (titre, description, img)
                HashMap<String, String> map = (HashMap<String, String>) maListViewPerso.getItemAtPosition(position);
                Toast.makeText(Huawei.this, map.get("name"), Toast.LENGTH_LONG).show();
            }
        });
        final Context context = Huawei.this;




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





