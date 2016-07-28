package com.triunfo.mercadopoly;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Visita extends AppCompatActivity {
    String codigo;
    String rol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visita);
        codigo = getIntent().getStringExtra("codigo");
        rol = getIntent().getStringExtra("rol");
    }

    public void goMedicion(View view){
        Intent intent = new Intent(this,MedicionExhibicion.class);
        intent.putExtra("codigo",codigo);
        intent.putExtra("rol",rol);
        startActivity(intent);
    }

    public void goTomaFotos(View view){
        Intent intent = new Intent(this, MedicionFotos.class);
        intent.putExtra("codigo",codigo);
        intent.putExtra("rol",rol);
        startActivity(intent);
    }


}
