package com.triunfo.mercadopoly;

import android.content.DialogInterface;
import android.media.MediaScannerConnection;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class Competencia extends AppCompatActivity {

    int NUM_PRODUCTOS_COMPETENCIA=28;
    RadioButton[] radioButtonsCompetenciaSi;
    RadioButton[] radioButtonsCompetenciaNo;
    TextView[] textViewsNombresCompetencia;
    String codigo;
    String rol;
    Cliente cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competencia);
        codigo = getIntent().getStringExtra("codigo");
        rol = getIntent().getStringExtra("rol");
        cliente = new Cliente(codigo, getApplicationContext());

        radioButtonsCompetenciaSi = new RadioButton[NUM_PRODUCTOS_COMPETENCIA];
        radioButtonsCompetenciaNo = new RadioButton[NUM_PRODUCTOS_COMPETENCIA];
        textViewsNombresCompetencia = new TextView[NUM_PRODUCTOS_COMPETENCIA];
        setupview();
    }

    private void setupview() {
        radioButtonsCompetenciaSi[0]= (RadioButton) findViewById(R.id.radiobutton_pc0_si);
        radioButtonsCompetenciaSi[1]= (RadioButton) findViewById(R.id.radiobutton_pc1_si);
        radioButtonsCompetenciaSi[2]= (RadioButton) findViewById(R.id.radiobutton_pc2_si);
        radioButtonsCompetenciaSi[3]= (RadioButton) findViewById(R.id.radiobutton_pc3_si);
        radioButtonsCompetenciaSi[4]= (RadioButton) findViewById(R.id.radiobutton_pc4_si);
        radioButtonsCompetenciaSi[5]= (RadioButton) findViewById(R.id.radiobutton_pc5_si);
        radioButtonsCompetenciaSi[6]= (RadioButton) findViewById(R.id.radiobutton_pc6_si);
        radioButtonsCompetenciaSi[7]= (RadioButton) findViewById(R.id.radiobutton_pc7_si);
        radioButtonsCompetenciaSi[8]= (RadioButton) findViewById(R.id.radiobutton_pc8_si);
        radioButtonsCompetenciaSi[9]= (RadioButton) findViewById(R.id.radiobutton_pc9_si);
        radioButtonsCompetenciaSi[10]= (RadioButton) findViewById(R.id.radiobutton_pc10_si);
        radioButtonsCompetenciaSi[11]= (RadioButton) findViewById(R.id.radiobutton_pc11_si);
        radioButtonsCompetenciaSi[12]= (RadioButton) findViewById(R.id.radiobutton_pc12_si);
        radioButtonsCompetenciaSi[13]= (RadioButton) findViewById(R.id.radiobutton_pc13_si);
        radioButtonsCompetenciaSi[14]= (RadioButton) findViewById(R.id.radiobutton_pc14_si);
        radioButtonsCompetenciaSi[15]= (RadioButton) findViewById(R.id.radiobutton_pc15_si);
        radioButtonsCompetenciaSi[16]= (RadioButton) findViewById(R.id.radiobutton_pc16_si);
        radioButtonsCompetenciaSi[17]= (RadioButton) findViewById(R.id.radiobutton_pc17_si);
        radioButtonsCompetenciaSi[18]= (RadioButton) findViewById(R.id.radiobutton_pc18_si);
        radioButtonsCompetenciaSi[19]= (RadioButton) findViewById(R.id.radiobutton_pc19_si);
        radioButtonsCompetenciaSi[20]= (RadioButton) findViewById(R.id.radiobutton_pc20_si);
        radioButtonsCompetenciaSi[21]= (RadioButton) findViewById(R.id.radiobutton_pc21_si);
        radioButtonsCompetenciaSi[22]= (RadioButton) findViewById(R.id.radiobutton_pc22_si);
        radioButtonsCompetenciaSi[23]= (RadioButton) findViewById(R.id.radiobutton_pc23_si);
        radioButtonsCompetenciaSi[24]= (RadioButton) findViewById(R.id.radiobutton_pc24_si);
        radioButtonsCompetenciaSi[25]= (RadioButton) findViewById(R.id.radiobutton_pc25_si);
        radioButtonsCompetenciaSi[26]= (RadioButton) findViewById(R.id.radiobutton_pc26_si);
        radioButtonsCompetenciaSi[27]= (RadioButton) findViewById(R.id.radiobutton_pc27_si);

        radioButtonsCompetenciaNo[0]= (RadioButton) findViewById(R.id.radiobutton_pc0_no);
        radioButtonsCompetenciaNo[1]= (RadioButton) findViewById(R.id.radiobutton_pc1_no);
        radioButtonsCompetenciaNo[2]= (RadioButton) findViewById(R.id.radiobutton_pc2_no);
        radioButtonsCompetenciaNo[3]= (RadioButton) findViewById(R.id.radiobutton_pc3_no);
        radioButtonsCompetenciaNo[4]= (RadioButton) findViewById(R.id.radiobutton_pc4_no);
        radioButtonsCompetenciaNo[5]= (RadioButton) findViewById(R.id.radiobutton_pc5_no);
        radioButtonsCompetenciaNo[6]= (RadioButton) findViewById(R.id.radiobutton_pc6_no);
        radioButtonsCompetenciaNo[7]= (RadioButton) findViewById(R.id.radiobutton_pc7_no);
        radioButtonsCompetenciaNo[8]= (RadioButton) findViewById(R.id.radiobutton_pc8_no);
        radioButtonsCompetenciaNo[9]= (RadioButton) findViewById(R.id.radiobutton_pc9_no);
        radioButtonsCompetenciaNo[10]= (RadioButton) findViewById(R.id.radiobutton_pc10_no);
        radioButtonsCompetenciaNo[11]= (RadioButton) findViewById(R.id.radiobutton_pc11_no);
        radioButtonsCompetenciaNo[12]= (RadioButton) findViewById(R.id.radiobutton_pc12_no);
        radioButtonsCompetenciaNo[13]= (RadioButton) findViewById(R.id.radiobutton_pc13_no);
        radioButtonsCompetenciaNo[14]= (RadioButton) findViewById(R.id.radiobutton_pc14_no);
        radioButtonsCompetenciaNo[15]= (RadioButton) findViewById(R.id.radiobutton_pc15_no);
        radioButtonsCompetenciaNo[16]= (RadioButton) findViewById(R.id.radiobutton_pc16_no);
        radioButtonsCompetenciaNo[17]= (RadioButton) findViewById(R.id.radiobutton_pc17_no);
        radioButtonsCompetenciaNo[18]= (RadioButton) findViewById(R.id.radiobutton_pc18_no);
        radioButtonsCompetenciaNo[19]= (RadioButton) findViewById(R.id.radiobutton_pc19_no);
        radioButtonsCompetenciaNo[20]= (RadioButton) findViewById(R.id.radiobutton_pc20_no);
        radioButtonsCompetenciaNo[21]= (RadioButton) findViewById(R.id.radiobutton_pc21_no);
        radioButtonsCompetenciaNo[22]= (RadioButton) findViewById(R.id.radiobutton_pc22_no);
        radioButtonsCompetenciaNo[23]= (RadioButton) findViewById(R.id.radiobutton_pc23_no);
        radioButtonsCompetenciaNo[24]= (RadioButton) findViewById(R.id.radiobutton_pc24_no);
        radioButtonsCompetenciaNo[25]= (RadioButton) findViewById(R.id.radiobutton_pc25_no);
        radioButtonsCompetenciaNo[26]= (RadioButton) findViewById(R.id.radiobutton_pc26_no);
        radioButtonsCompetenciaNo[27]= (RadioButton) findViewById(R.id.radiobutton_pc27_no);

        textViewsNombresCompetencia[0] = (TextView) findViewById(R.id.textview_pc0);
        textViewsNombresCompetencia[1] = (TextView) findViewById(R.id.textview_pc1);
        textViewsNombresCompetencia[2] = (TextView) findViewById(R.id.textview_pc2);
        textViewsNombresCompetencia[3] = (TextView) findViewById(R.id.textview_pc3);
        textViewsNombresCompetencia[4] = (TextView) findViewById(R.id.textview_pc4);
        textViewsNombresCompetencia[5] = (TextView) findViewById(R.id.textview_pc5);
        textViewsNombresCompetencia[6] = (TextView) findViewById(R.id.textview_pc6);
        textViewsNombresCompetencia[7] = (TextView) findViewById(R.id.textview_pc7);
        textViewsNombresCompetencia[8] = (TextView) findViewById(R.id.textview_pc8);
        textViewsNombresCompetencia[9] = (TextView) findViewById(R.id.textview_pc9);
        textViewsNombresCompetencia[10] = (TextView) findViewById(R.id.textview_pc10);
        textViewsNombresCompetencia[11] = (TextView) findViewById(R.id.textview_pc11);
        textViewsNombresCompetencia[12] = (TextView) findViewById(R.id.textview_pc12);
        textViewsNombresCompetencia[13] = (TextView) findViewById(R.id.textview_pc13);
        textViewsNombresCompetencia[14] = (TextView) findViewById(R.id.textview_pc14);
        textViewsNombresCompetencia[15] = (TextView) findViewById(R.id.textview_pc15);
        textViewsNombresCompetencia[16] = (TextView) findViewById(R.id.textview_pc16);
        textViewsNombresCompetencia[17] = (TextView) findViewById(R.id.textview_pc17);
        textViewsNombresCompetencia[18] = (TextView) findViewById(R.id.textview_pc18);
        textViewsNombresCompetencia[19] = (TextView) findViewById(R.id.textview_pc19);
        textViewsNombresCompetencia[20] = (TextView) findViewById(R.id.textview_pc20);
        textViewsNombresCompetencia[21] = (TextView) findViewById(R.id.textview_pc21);
        textViewsNombresCompetencia[22] = (TextView) findViewById(R.id.textview_pc22);
        textViewsNombresCompetencia[23] = (TextView) findViewById(R.id.textview_pc23);
        textViewsNombresCompetencia[24] = (TextView) findViewById(R.id.textview_pc24);
        textViewsNombresCompetencia[25] = (TextView) findViewById(R.id.textview_pc25);
        textViewsNombresCompetencia[26] = (TextView) findViewById(R.id.textview_pc26);
        textViewsNombresCompetencia[27] = (TextView) findViewById(R.id.textview_pc27);
    }

    public void radioButtonCompetenciaChecked(View view){

    }

    public void guardarVisitaCompetencia(View view){
        String res = "";
        boolean grabar = false;
        for(int i=0; i<NUM_PRODUCTOS_COMPETENCIA; i++){
            if(radioButtonsCompetenciaSi[i].isChecked()){
                res += "1";
            }
            else if(radioButtonsCompetenciaNo[i].isChecked()){
                res += "0";
            }
            else{
                AlertDialog.Builder message = new AlertDialog.Builder(this);
                message.setMessage("Te falta marcar el producto "+textViewsNombresCompetencia[i].getText());
                message.setPositiveButton("Entendido", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                message.create().show();
                break;
            }
            if(i==NUM_PRODUCTOS_COMPETENCIA-1) grabar = true;

            if(grabar){
                res+="\n";
                try{
                    File storageDir = new File(cliente.getPath());
                    storageDir.mkdirs();
                    File file = new File(storageDir,"visitaCompetencia.txt");
                    FileOutputStream fos = new FileOutputStream(file, true);
                    fos.write(res.getBytes());
                    fos.close();
                    Toast.makeText(getApplicationContext(), "Informacion guardada", Toast.LENGTH_SHORT).show();
                    MediaScannerConnection.scanFile(this,new String[]{file.toString()},null,null);
                } catch(Exception e){
                    e.printStackTrace();
                }
                finish();
            }
        }


    }
}
