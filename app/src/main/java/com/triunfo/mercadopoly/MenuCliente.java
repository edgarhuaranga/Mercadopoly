package com.triunfo.mercadopoly;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MenuCliente extends AppCompatActivity {

    String codigo;
    String rol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_cliente);
        getSupportActionBar().hide();
        codigo = getIntent().getStringExtra("codigo");
        rol = getIntent().getStringExtra("rol");

        TextView cliente = (TextView)findViewById(R.id.textview_cliente);
        cliente.setText((new Cliente(codigo,getApplicationContext())).nombre);
    }

    public void clickOpcion(View view){
        Intent intent = null;
        switch (view.getId()){
            case R.id.button_perfil:
                intent = new Intent(this, Perfil.class);
                break;
            case R.id.button_historico_exhibicion:
                intent = new Intent(this, HistoricoExhibicion.class);
                break;
            case R.id.button_historico_compras:
                intent = new Intent(this, HistoricoCompras.class);
                break;
            case R.id.button_medicion_exhibicion_fotografia:
                intent = new Intent(this, Visita.class);
                break;
            case R.id.button_comentarios:
                intent = new Intent(this, Comentarios.class);
                break;
            case R.id.button_galeria:
                //intent = new Intent(this, GridViewActivity.class);
                break;
            case R.id.button_finalizar:
                finish();
                break;
        }
        if(intent !=null){
            intent.putExtra("codigo",codigo);
            intent.putExtra("rol",rol);
            startActivity(intent);
        }
    }
}
