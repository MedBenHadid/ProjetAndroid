package com.example.med.tp3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import static android.os.Build.VERSION_CODES.M;

public class LoginDisplayActivity extends login{
    final String EXTRA_LOGIN = "user_login";
    final String EXTRA_PASSWORD = "user_password";
    protected ListView l;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


      /*  Intent intent = getIntent();
        TextView EmailDisplay = (TextView) findViewById(R.id.email_display);
        TextView passwordDisplay = (TextView) findViewById(R.id.password_display);

        if (intent != null) {
            EmailDisplay.setText(intent.getStringExtra(EXTRA_LOGIN));
            passwordDisplay.setText(intent.getStringExtra(EXTRA_PASSWORD));
        }*/
        l=(ListView)findViewById(R.id.LV);

        ArrayList<HashMap<String,String>> LI=new ArrayList<>();
        HashMap<String,String> map;

        map=new HashMap<>();
        map.put("Titre","Iphone");
        map.put("Img",String.valueOf(R.drawable.iphone));
        LI.add(map);

        map=new HashMap<>();
        map.put("Titre","Sumsung");
        map.put("Img",String.valueOf(R.drawable.sumsung));
        LI.add(map);

      map=new HashMap<>();
        map.put("Titre","huawei");
        map.put("Img",String.valueOf(R.drawable.huawei));
        LI.add(map);

        map=new HashMap<>();
        map.put("Titre","Sony");
        map.put("Img",String.valueOf(R.drawable.sony));
        LI.add(map);

        SimpleAdapter ad=new SimpleAdapter(this.getBaseContext(),LI,R.layout.structure,
                new String[]{"Img","Titre","Des"},
                new int[]{R.id.img,R.id.titre});
        l.setAdapter(ad);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            @SuppressWarnings("unchecked")
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch( position )
                {
                    case 0:  Intent newActivity = new Intent( LoginDisplayActivity.this , Iphone.class);
                        startActivity(newActivity);
                        break;
                    case 1:  Intent newActivity2 = new Intent(LoginDisplayActivity.this, Samsung.class);
                        startActivity(newActivity2);
                        break;
                    case 2:  Intent newActivity3 = new Intent(LoginDisplayActivity.this, Huawei.class);
                        startActivity(newActivity3);
                        break;
                    case 3:  Intent newActivity4 = new Intent(LoginDisplayActivity.this, Sony.class);
                        startActivity(newActivity4);
                        break;

                }


            }
        });
        }
}
