package com.triunfo.mercadopoly;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class Perfil extends AppCompatActivity {

    String codigo;
    TextView textViewCiudad,textViewNombrePuesto, textViewCodigo, textViewRepresentante, textViewDNI,
            textViewDireccion, textViewMercado, textViewGiro, textViewProductosExhigidos;

    TextView textviewstatusPremioSetiembre, textviewpremioSetiembre;
    TextView textviewstatusPremioOctubre, textviewpremioOctubre;
    TextView textviewstatusPremioNoviembre, textviewpremioNoviembre;
    TextView textviewstatusPremioDiciembre, textviewpremioDiciembre;
    TextView textviewstatusPremioEnero, textviewpremioEnero;
    TextView textViewSemanaCampania;

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
        textViewSemanaCampania = (TextView) findViewById(R.id.textview_semana_campania);

        textViewCiudad.setText(cliente.ciudad);
        textViewNombrePuesto.setText(cliente.nombre);
        textViewCodigo.setText(cliente.codigo);
        textViewRepresentante.setText(cliente.representante);
        textViewDNI.setText(cliente.dni);
        textViewDireccion.setText(cliente.direccion);
        textViewMercado.setText(cliente.mercado);
        textViewGiro.setText(cliente.giro);
        textViewProductosExhigidos.setText(cliente.productosExhigidos);

        textviewstatusPremioSetiembre = (TextView) findViewById(R.id.textview_status_premio_setiembre);
        textviewpremioSetiembre = (TextView) findViewById(R.id.textview_premio_setiembre);

        textviewstatusPremioOctubre = (TextView) findViewById(R.id.textview_status_premio_octubre);
        textviewpremioOctubre = (TextView) findViewById(R.id.textview_premio_octubre);

        textviewstatusPremioNoviembre = (TextView) findViewById(R.id.textview_status_premio_noviembre);
        textviewpremioNoviembre = (TextView) findViewById(R.id.textview_premio_noviembre);

        textviewstatusPremioDiciembre = (TextView) findViewById(R.id.textview_status_premio_diciembre);
        textviewpremioDiciembre = (TextView) findViewById(R.id.textview_premio_diciembre);

        textviewstatusPremioEnero = (TextView) findViewById(R.id.textview_status_premio_enero);
        textviewpremioEnero = (TextView) findViewById(R.id.textview_premio_enero);

        if(!cliente.getPremio(Cliente.INDEX_SETIEMBRE, getApplicationContext()).equalsIgnoreCase("-")){
            textviewstatusPremioSetiembre.setText("Sí");
        }
        else{
            textviewstatusPremioSetiembre.setText("No");
        }

        textviewpremioSetiembre.setText(cliente.getPremio(Cliente.INDEX_SETIEMBRE, getApplicationContext()));

        if(!cliente.getPremio(Cliente.INDEX_OCTUBRE, getApplicationContext()).equalsIgnoreCase("-")){
            textviewstatusPremioOctubre.setText("Sí");
        }
        else{
            textviewstatusPremioOctubre.setText("No");
        }

        textviewpremioOctubre.setText(cliente.getPremio(Cliente.INDEX_OCTUBRE, getApplicationContext()));


        if(!cliente.getPremio(Cliente.INDEX_NOVIEMBRE, getApplicationContext()).equalsIgnoreCase("-")){
            textviewstatusPremioNoviembre.setText("Sí");
        }
        else{
            textviewstatusPremioNoviembre.setText("No");
        }

        textviewpremioNoviembre.setText(cliente.getPremio(Cliente.INDEX_NOVIEMBRE, getApplicationContext()));

        if(!cliente.getPremio(Cliente.INDEX_DICIEMBRE, getApplicationContext()).equalsIgnoreCase("-")){
            textviewstatusPremioDiciembre.setText("Sí");
        }
        else{
            textviewstatusPremioDiciembre.setText("No");
        }

        textviewpremioDiciembre.setText(cliente.getPremio(Cliente.INDEX_DICIEMBRE, getApplicationContext()));

        if(!cliente.getPremio(Cliente.INDEX_ENERO, getApplicationContext()).equalsIgnoreCase("-")){
            textviewstatusPremioEnero.setText("Sí");
        }
        else{
            textviewstatusPremioEnero.setText("No");
        }

        textviewpremioEnero.setText(cliente.getPremio(Cliente.INDEX_ENERO, getApplicationContext()));


        int mes, diames;
        int semanacampania=0;
        mes = (Calendar.getInstance()).get(Calendar.MONTH);
        diames = (Calendar.getInstance()).get(Calendar.DAY_OF_MONTH);


        switch (mes){
            case Calendar.JANUARY:
                if(diames>=2 && diames<9) semanacampania = 23;
                else if(diames>=9 && diames<16) semanacampania = 24;
                else if(diames>=16 && diames<23) semanacampania = 25;
                else if(diames>=23 && diames<30) semanacampania = 26;
                break;
            case Calendar.FEBRUARY:
                //campain is over
                break;
            case Calendar.MARCH:
                //no campain
                break;
            case Calendar.APRIL:
                //no campain
                break;
            case Calendar.MAY:
                //no campain
                break;
            case Calendar.JUNE:
                //no campain
                break;
            case Calendar.JULY:
                //no campain
                break;
            case Calendar.AUGUST:
                if(diames>=01 && diames<8) semanacampania = 1;
                else if(diames>=8 && diames<15) semanacampania=2;
                else if(diames>=15 && diames<22) semanacampania=3;
                else if(diames>=22 && diames<29) semanacampania=4;
                else if(diames>=29) semanacampania = 5;
                break;
            case Calendar.SEPTEMBER:
                if(diames<=3) semanacampania = 5;
                else if(diames>=5 && diames<12) semanacampania = 6;
                else if(diames>=12 && diames<19) semanacampania = 7;
                else if(diames>=19 && diames<26) semanacampania = 8;
                else if(diames>=26) semanacampania=9;
                break;
            case Calendar.OCTOBER:
                if(diames<3) semanacampania = 9;
                else if(diames>=3 && diames<10) semanacampania = 10;
                else if(diames>=10 && diames<17) semanacampania = 11;
                else if(diames>=17 && diames<24) semanacampania = 12;
                else if(diames>=24 && diames<31) semanacampania = 13;
                else if(diames==31) semanacampania =14;
                break;
            case Calendar.NOVEMBER:
                if(diames<7) semanacampania = 14;
                else if(diames>=7 && diames<14) semanacampania = 15;
                else if(diames>=14 && diames<21) semanacampania = 16;
                else if(diames>=21 && diames<28) semanacampania = 17;
                else if(diames>=28) semanacampania = 18;
                break;
            case Calendar.DECEMBER:
                if(diames<5) semanacampania=18;
                else if(diames>=5 && diames<12) semanacampania=19;
                else if(diames>=12 && diames<19) semanacampania = 20;
                else if(diames>=19 && diames<26) semanacampania = 21;
                else if(diames>=26 ) semanacampania = 22;
                break;
        }

        textViewSemanaCampania.setText("Semana "+semanacampania);
    }

    //TODO implementar vista de foto de perfil
    //TODO implementar comodines utilizados
    //TODO implementar semana actual
    //TODO implementar si gano o no en el mes
}
