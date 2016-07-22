package com.triunfo.mercadopoly;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Perfil extends AppCompatActivity {

    String codigo;
    TextView textViewCiudad,textViewNombrePuesto, textViewCodigo, textViewRepresentante, textViewDNI,
            textViewDireccion, textViewMercado, textViewGiro, textViewProductosExhigidos;
    Cliente cliente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        codigo = getIntent().getStringExtra("codigo");
        cliente = new Cliente(codigo, getApplicationContext());

        textViewCiudad = (TextView) findViewById(R.id.textview_ciudad);
        textViewNombrePuesto = (TextView) findViewById(R.id.textview_nombre);
        textViewCodigo   = (TextView) findViewById(R.id.textview_codigo);
        textViewRepresentante = (TextView) findViewById(R.id.textview_representante);
        textViewDNI = (TextView) findViewById(R.id.textview_dni);
        textViewDireccion = (TextView) findViewById(R.id.textview_direccion);
        textViewMercado = (TextView) findViewById(R.id.textview_mercado);
        textViewGiro   = (TextView) findViewById(R.id.textview_giro);
        textViewProductosExhigidos = (TextView) findViewById(R.id.textview_productosexhigidos);

        textViewCiudad.setText(cliente.ciudad);
        textViewNombrePuesto.setText(cliente.nombre);
        textViewCodigo.setText(cliente.codigo);
        textViewRepresentante.setText(cliente.representante);
        textViewDNI.setText(cliente.dni);
        textViewDireccion.setText(cliente.direccion);
        textViewMercado.setText(cliente.mercado);
        textViewGiro.setText(cliente.giro);
        textViewProductosExhigidos.setText(cliente.productosExhigidos);
    }

    //TODO implementar vista de foto de perfil
    //TODO implementar comodines utilizados
    //TODO implementar semana actual
    //TODO implementar si gano o no en el mes
}
