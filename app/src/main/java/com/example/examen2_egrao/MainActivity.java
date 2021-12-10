package com.example.examen2_egrao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listview;
    private ArrayList<String> entrenaments;
    public static final String EXTRA_MESSAGE = "com.example.Examen2_egrao.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById(R.id.listview);
        ImageView img1 = (ImageView)findViewById(R.id.img1);
        ImageView img2 = (ImageView)findViewById(R.id.img2);
        ImageView img3 = (ImageView)findViewById(R.id.img3);
        ImageView img4 = (ImageView)findViewById(R.id.img4);

        entrenaments = new ArrayList<String>();
        entrenaments.add("Extremitats a Tope");
        entrenaments.add("Agonia Màxima");
        entrenaments.add("Entrenament especial");
        entrenaments.add("Força i longitud");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, entrenaments);
        listview.setAdapter(adapter);

        listview.setClickable(true);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                if(position == 0){
//                    img1.setVisibility(arg1.VISIBLE);
                    showEntrenament1(arg1);

                }
                if(position == 1){
//                    img2.setVisibility(arg1.VISIBLE);
                    showEntrenament2(arg1);
                }
                if(position == 2){
//                    img3.setVisibility(arg1.VISIBLE);
                    showEntrenament3(arg1);
                }
                if(position == 3){
//                    img4.setVisibility(arg1.VISIBLE);
                    showEntrenament4(arg1);
                }

            }
        });

    }
    public void showEntrenament1(View view) {
        showEntrenament(getString(R.string.primero));
    }
    public void showEntrenament2(View view) {
        showEntrenament(getString(R.string.segundo));
    }
    public void showEntrenament3(View view) {
        showEntrenament(getString(R.string.tercero));
    }
    public void showEntrenament4(View view) {
        showEntrenament(getString(R.string.cuarto));
    }


    public void showEntrenament(String message) {
        Intent intent = new Intent(this, Entrenaments.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}