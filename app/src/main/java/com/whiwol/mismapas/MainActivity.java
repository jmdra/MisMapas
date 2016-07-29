package com.whiwol.mismapas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irMapaEstadio(View v){
        Intent i = new Intent(this, MapsActivity.class);
        i.putExtra("locacion", 1);
        startActivity(i);
    }

    public void irMapaAuditorio(View v){
        Intent i = new Intent(this, MapsActivity.class);
        i.putExtra("locacion", 2);
        startActivity(i);
    }

    public void irMapaAlameda(View v){
        Intent i = new Intent(this, MapsActivity.class);
        i.putExtra("locacion", 3);
        startActivity(i);
    }

    public void irMapaCentro(View v){
        Intent i = new Intent(this, MapsActivity.class);
        i.putExtra("locacion", 4);
        startActivity(i);
    }

}
