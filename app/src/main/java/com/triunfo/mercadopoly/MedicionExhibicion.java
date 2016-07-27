package com.triunfo.mercadopoly;

import android.content.DialogInterface;
import android.media.MediaScannerConnection;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class MedicionExhibicion extends AppCompatActivity {
    final int NUMERO_PRODUCTOS = 30;
    TextView[] textViewNombreProducto;
    RadioButton[] radioButtonsExhibicionSi;
    RadioButton[] radioButtonsExhibicionNo;
    RadioButton[] radioButtonsExhibicionProtisa;
    CheckBox[] checkBoxesMotivo1;
    CheckBox[] checkBoxesMotivo2;
    CheckBox[] checkBoxesMotivo3;
    CheckBox[] checkBoxesMotivo4;
    CheckBox[] checkBoxesMotivo5;
    CheckBox[] checkBoxesMotivo6;
    Cliente cliente;
    String codigo;
    String rol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicion_exhibicion);
        codigo = getIntent().getStringExtra("codigo");
        rol = getIntent().getStringExtra("rol");
        cliente = new Cliente(codigo, getApplicationContext());

        textViewNombreProducto = new TextView[NUMERO_PRODUCTOS];
        radioButtonsExhibicionSi = new RadioButton[NUMERO_PRODUCTOS];
        radioButtonsExhibicionNo = new RadioButton[NUMERO_PRODUCTOS];
        radioButtonsExhibicionProtisa = new RadioButton[NUMERO_PRODUCTOS];
        checkBoxesMotivo1 = new CheckBox[NUMERO_PRODUCTOS];
        checkBoxesMotivo2 = new CheckBox[NUMERO_PRODUCTOS];
        checkBoxesMotivo3 = new CheckBox[NUMERO_PRODUCTOS];
        checkBoxesMotivo4 = new CheckBox[NUMERO_PRODUCTOS];
        checkBoxesMotivo5 = new CheckBox[NUMERO_PRODUCTOS];
        checkBoxesMotivo6 = new CheckBox[NUMERO_PRODUCTOS];
        setupViews();
    }

    public void setupViews(){
        textViewNombreProducto[0] = (TextView) findViewById(R.id.textview_p0);
        textViewNombreProducto[1] = (TextView) findViewById(R.id.textview_p1);
        textViewNombreProducto[2] = (TextView) findViewById(R.id.textview_p2);
        textViewNombreProducto[3] = (TextView) findViewById(R.id.textview_p3);
        textViewNombreProducto[4] = (TextView) findViewById(R.id.textview_p4);
        textViewNombreProducto[5] = (TextView) findViewById(R.id.textview_p5);
        textViewNombreProducto[6] = (TextView) findViewById(R.id.textview_p6);
        textViewNombreProducto[7] = (TextView) findViewById(R.id.textview_p7);
        textViewNombreProducto[8] = (TextView) findViewById(R.id.textview_p8);
        textViewNombreProducto[9] = (TextView) findViewById(R.id.textview_p9);
        textViewNombreProducto[10] = (TextView) findViewById(R.id.textview_p10);
        textViewNombreProducto[11] = (TextView) findViewById(R.id.textview_p11);
        textViewNombreProducto[12] = (TextView) findViewById(R.id.textview_p12);
        textViewNombreProducto[13] = (TextView) findViewById(R.id.textview_p13);
        textViewNombreProducto[14] = (TextView) findViewById(R.id.textview_p14);
        textViewNombreProducto[15] = (TextView) findViewById(R.id.textview_p15);
        textViewNombreProducto[16] = (TextView) findViewById(R.id.textview_p16);
        textViewNombreProducto[17] = (TextView) findViewById(R.id.textview_p17);
        textViewNombreProducto[18] = (TextView) findViewById(R.id.textview_p18);
        textViewNombreProducto[19] = (TextView) findViewById(R.id.textview_p19);
        textViewNombreProducto[20] = (TextView) findViewById(R.id.textview_p20);
        textViewNombreProducto[21] = (TextView) findViewById(R.id.textview_p21);
        textViewNombreProducto[22] = (TextView) findViewById(R.id.textview_p22);
        textViewNombreProducto[23] = (TextView) findViewById(R.id.textview_p23);
        textViewNombreProducto[24] = (TextView) findViewById(R.id.textview_p24);
        textViewNombreProducto[25] = (TextView) findViewById(R.id.textview_p25);
        textViewNombreProducto[26] = (TextView) findViewById(R.id.textview_p26);
        textViewNombreProducto[27] = (TextView) findViewById(R.id.textview_p27);
        textViewNombreProducto[28] = (TextView) findViewById(R.id.textview_p28);
        textViewNombreProducto[29] = (TextView) findViewById(R.id.textview_p29);


        radioButtonsExhibicionSi[0]=(RadioButton) findViewById(R.id.radiobutton_p0_si);
        radioButtonsExhibicionSi[1]=(RadioButton) findViewById(R.id.radiobutton_p1_si);
        radioButtonsExhibicionSi[2]=(RadioButton) findViewById(R.id.radiobutton_p2_si);
        radioButtonsExhibicionSi[3]=(RadioButton) findViewById(R.id.radiobutton_p3_si);
        radioButtonsExhibicionSi[4]=(RadioButton) findViewById(R.id.radiobutton_p4_si);
        radioButtonsExhibicionSi[5]=(RadioButton) findViewById(R.id.radiobutton_p5_si);
        radioButtonsExhibicionSi[6]=(RadioButton) findViewById(R.id.radiobutton_p6_si);
        radioButtonsExhibicionSi[7]=(RadioButton) findViewById(R.id.radiobutton_p7_si);
        radioButtonsExhibicionSi[8]=(RadioButton) findViewById(R.id.radiobutton_p8_si);
        radioButtonsExhibicionSi[9]=(RadioButton) findViewById(R.id.radiobutton_p9_si);
        radioButtonsExhibicionSi[10]=(RadioButton) findViewById(R.id.radiobutton_p10_si);
        radioButtonsExhibicionSi[11]=(RadioButton) findViewById(R.id.radiobutton_p11_si);
        radioButtonsExhibicionSi[12]=(RadioButton) findViewById(R.id.radiobutton_p12_si);
        radioButtonsExhibicionSi[13]=(RadioButton) findViewById(R.id.radiobutton_p13_si);
        radioButtonsExhibicionSi[14]=(RadioButton) findViewById(R.id.radiobutton_p14_si);
        radioButtonsExhibicionSi[15]=(RadioButton) findViewById(R.id.radiobutton_p15_si);
        radioButtonsExhibicionSi[16]=(RadioButton) findViewById(R.id.radiobutton_p16_si);
        radioButtonsExhibicionSi[17]=(RadioButton) findViewById(R.id.radiobutton_p17_si);
        radioButtonsExhibicionSi[18]=(RadioButton) findViewById(R.id.radiobutton_p18_si);
        radioButtonsExhibicionSi[19]=(RadioButton) findViewById(R.id.radiobutton_p19_si);
        radioButtonsExhibicionSi[20]=(RadioButton) findViewById(R.id.radiobutton_p20_si);
        radioButtonsExhibicionSi[21]=(RadioButton) findViewById(R.id.radiobutton_p21_si);
        radioButtonsExhibicionSi[22]=(RadioButton) findViewById(R.id.radiobutton_p22_si);
        radioButtonsExhibicionSi[23]=(RadioButton) findViewById(R.id.radiobutton_p23_si);
        radioButtonsExhibicionSi[24]=(RadioButton) findViewById(R.id.radiobutton_p24_si);
        radioButtonsExhibicionSi[25]=(RadioButton) findViewById(R.id.radiobutton_p25_si);
        radioButtonsExhibicionSi[26]=(RadioButton) findViewById(R.id.radiobutton_p26_si);
        radioButtonsExhibicionSi[27]=(RadioButton) findViewById(R.id.radiobutton_p27_si);
        radioButtonsExhibicionSi[28]=(RadioButton) findViewById(R.id.radiobutton_p28_si);
        radioButtonsExhibicionSi[29]=(RadioButton) findViewById(R.id.radiobutton_p29_si);

        radioButtonsExhibicionNo[0]=(RadioButton) findViewById(R.id.radiobutton_p0_no);
        radioButtonsExhibicionNo[1]=(RadioButton) findViewById(R.id.radiobutton_p1_no);
        radioButtonsExhibicionNo[2]=(RadioButton) findViewById(R.id.radiobutton_p2_no);
        radioButtonsExhibicionNo[3]=(RadioButton) findViewById(R.id.radiobutton_p3_no);
        radioButtonsExhibicionNo[4]=(RadioButton) findViewById(R.id.radiobutton_p4_no);
        radioButtonsExhibicionNo[5]=(RadioButton) findViewById(R.id.radiobutton_p5_no);
        radioButtonsExhibicionNo[6]=(RadioButton) findViewById(R.id.radiobutton_p6_no);
        radioButtonsExhibicionNo[7]=(RadioButton) findViewById(R.id.radiobutton_p7_no);
        radioButtonsExhibicionNo[8]=(RadioButton) findViewById(R.id.radiobutton_p8_no);
        radioButtonsExhibicionNo[9]=(RadioButton) findViewById(R.id.radiobutton_p9_no);
        radioButtonsExhibicionNo[10]=(RadioButton) findViewById(R.id.radiobutton_p10_no);
        radioButtonsExhibicionNo[11]=(RadioButton) findViewById(R.id.radiobutton_p11_no);
        radioButtonsExhibicionNo[12]=(RadioButton) findViewById(R.id.radiobutton_p12_no);
        radioButtonsExhibicionNo[13]=(RadioButton) findViewById(R.id.radiobutton_p13_no);
        radioButtonsExhibicionNo[14]=(RadioButton) findViewById(R.id.radiobutton_p14_no);
        radioButtonsExhibicionNo[15]=(RadioButton) findViewById(R.id.radiobutton_p15_no);
        radioButtonsExhibicionNo[16]=(RadioButton) findViewById(R.id.radiobutton_p16_no);
        radioButtonsExhibicionNo[17]=(RadioButton) findViewById(R.id.radiobutton_p17_no);
        radioButtonsExhibicionNo[18]=(RadioButton) findViewById(R.id.radiobutton_p18_no);
        radioButtonsExhibicionNo[19]=(RadioButton) findViewById(R.id.radiobutton_p19_no);
        radioButtonsExhibicionNo[20]=(RadioButton) findViewById(R.id.radiobutton_p20_no);
        radioButtonsExhibicionNo[21]=(RadioButton) findViewById(R.id.radiobutton_p21_no);
        radioButtonsExhibicionNo[22]=(RadioButton) findViewById(R.id.radiobutton_p22_no);
        radioButtonsExhibicionNo[23]=(RadioButton) findViewById(R.id.radiobutton_p23_no);
        radioButtonsExhibicionNo[24]=(RadioButton) findViewById(R.id.radiobutton_p24_no);
        radioButtonsExhibicionNo[25]=(RadioButton) findViewById(R.id.radiobutton_p25_no);
        radioButtonsExhibicionNo[26]=(RadioButton) findViewById(R.id.radiobutton_p26_no);
        radioButtonsExhibicionNo[27]=(RadioButton) findViewById(R.id.radiobutton_p27_no);
        radioButtonsExhibicionNo[28]=(RadioButton) findViewById(R.id.radiobutton_p28_no);
        radioButtonsExhibicionNo[29]=(RadioButton) findViewById(R.id.radiobutton_p29_no);

        radioButtonsExhibicionProtisa[0]=(RadioButton) findViewById(R.id.radiobutton_p0_protisa);
        radioButtonsExhibicionProtisa[1]=(RadioButton) findViewById(R.id.radiobutton_p1_protisa);
        radioButtonsExhibicionProtisa[2]=(RadioButton) findViewById(R.id.radiobutton_p2_protisa);
        radioButtonsExhibicionProtisa[3]=(RadioButton) findViewById(R.id.radiobutton_p3_protisa);
        radioButtonsExhibicionProtisa[4]=(RadioButton) findViewById(R.id.radiobutton_p4_protisa);
        radioButtonsExhibicionProtisa[5]=(RadioButton) findViewById(R.id.radiobutton_p5_protisa);
        radioButtonsExhibicionProtisa[6]=(RadioButton) findViewById(R.id.radiobutton_p6_protisa);
        radioButtonsExhibicionProtisa[7]=(RadioButton) findViewById(R.id.radiobutton_p7_protisa);
        radioButtonsExhibicionProtisa[8]=(RadioButton) findViewById(R.id.radiobutton_p8_protisa);
        radioButtonsExhibicionProtisa[9]=(RadioButton) findViewById(R.id.radiobutton_p9_protisa);
        radioButtonsExhibicionProtisa[10]=(RadioButton) findViewById(R.id.radiobutton_p10_protisa);
        radioButtonsExhibicionProtisa[11]=(RadioButton) findViewById(R.id.radiobutton_p11_protisa);
        radioButtonsExhibicionProtisa[12]=(RadioButton) findViewById(R.id.radiobutton_p12_protisa);
        radioButtonsExhibicionProtisa[13]=(RadioButton) findViewById(R.id.radiobutton_p13_protisa);
        radioButtonsExhibicionProtisa[14]=(RadioButton) findViewById(R.id.radiobutton_p14_protisa);
        radioButtonsExhibicionProtisa[15]=(RadioButton) findViewById(R.id.radiobutton_p15_protisa);
        radioButtonsExhibicionProtisa[16]=(RadioButton) findViewById(R.id.radiobutton_p16_protisa);
        radioButtonsExhibicionProtisa[17]=(RadioButton) findViewById(R.id.radiobutton_p17_protisa);
        radioButtonsExhibicionProtisa[18]=(RadioButton) findViewById(R.id.radiobutton_p18_protisa);
        radioButtonsExhibicionProtisa[19]=(RadioButton) findViewById(R.id.radiobutton_p19_protisa);
        radioButtonsExhibicionProtisa[20]=(RadioButton) findViewById(R.id.radiobutton_p20_protisa);
        radioButtonsExhibicionProtisa[21]=(RadioButton) findViewById(R.id.radiobutton_p21_protisa);
        radioButtonsExhibicionProtisa[22]=(RadioButton) findViewById(R.id.radiobutton_p22_protisa);
        radioButtonsExhibicionProtisa[23]=(RadioButton) findViewById(R.id.radiobutton_p23_protisa);
        radioButtonsExhibicionProtisa[24]=(RadioButton) findViewById(R.id.radiobutton_p24_protisa);
        radioButtonsExhibicionProtisa[25]=(RadioButton) findViewById(R.id.radiobutton_p25_protisa);
        radioButtonsExhibicionProtisa[26]=(RadioButton) findViewById(R.id.radiobutton_p26_protisa);
        radioButtonsExhibicionProtisa[27]=(RadioButton) findViewById(R.id.radiobutton_p27_protisa);
        radioButtonsExhibicionProtisa[28]=(RadioButton) findViewById(R.id.radiobutton_p28_protisa);
        radioButtonsExhibicionProtisa[29]=(RadioButton) findViewById(R.id.radiobutton_p29_protisa);

        checkBoxesMotivo1[0] = (CheckBox) findViewById(R.id.checkbox_p0_opt01);
        checkBoxesMotivo1[1] = (CheckBox) findViewById(R.id.checkbox_p1_opt01);
        checkBoxesMotivo1[2] = (CheckBox) findViewById(R.id.checkbox_p2_opt01);
        checkBoxesMotivo1[3] = (CheckBox) findViewById(R.id.checkbox_p3_opt01);
        checkBoxesMotivo1[4] = (CheckBox) findViewById(R.id.checkbox_p4_opt01);
        checkBoxesMotivo1[5] = (CheckBox) findViewById(R.id.checkbox_p5_opt01);
        checkBoxesMotivo1[6] = (CheckBox) findViewById(R.id.checkbox_p6_opt01);
        checkBoxesMotivo1[7] = (CheckBox) findViewById(R.id.checkbox_p7_opt01);
        checkBoxesMotivo1[8] = (CheckBox) findViewById(R.id.checkbox_p8_opt01);
        checkBoxesMotivo1[9] = (CheckBox) findViewById(R.id.checkbox_p9_opt01);
        checkBoxesMotivo1[10] = (CheckBox) findViewById(R.id.checkbox_p10_opt01);
        checkBoxesMotivo1[11] = (CheckBox) findViewById(R.id.checkbox_p11_opt01);
        checkBoxesMotivo1[12] = (CheckBox) findViewById(R.id.checkbox_p12_opt01);
        checkBoxesMotivo1[13] = (CheckBox) findViewById(R.id.checkbox_p13_opt01);
        checkBoxesMotivo1[14] = (CheckBox) findViewById(R.id.checkbox_p14_opt01);
        checkBoxesMotivo1[15] = (CheckBox) findViewById(R.id.checkbox_p15_opt01);
        checkBoxesMotivo1[16] = (CheckBox) findViewById(R.id.checkbox_p16_opt01);
        checkBoxesMotivo1[17] = (CheckBox) findViewById(R.id.checkbox_p17_opt01);
        checkBoxesMotivo1[18] = (CheckBox) findViewById(R.id.checkbox_p18_opt01);
        checkBoxesMotivo1[19] = (CheckBox) findViewById(R.id.checkbox_p19_opt01);
        checkBoxesMotivo1[20] = (CheckBox) findViewById(R.id.checkbox_p20_opt01);
        checkBoxesMotivo1[21] = (CheckBox) findViewById(R.id.checkbox_p21_opt01);
        checkBoxesMotivo1[22] = (CheckBox) findViewById(R.id.checkbox_p22_opt01);
        checkBoxesMotivo1[23] = (CheckBox) findViewById(R.id.checkbox_p23_opt01);
        checkBoxesMotivo1[24] = (CheckBox) findViewById(R.id.checkbox_p24_opt01);
        checkBoxesMotivo1[25] = (CheckBox) findViewById(R.id.checkbox_p25_opt01);
        checkBoxesMotivo1[26] = (CheckBox) findViewById(R.id.checkbox_p26_opt01);
        checkBoxesMotivo1[27] = (CheckBox) findViewById(R.id.checkbox_p27_opt01);
        checkBoxesMotivo1[28] = (CheckBox) findViewById(R.id.checkbox_p28_opt01);
        checkBoxesMotivo1[29] = (CheckBox) findViewById(R.id.checkbox_p29_opt01);

        checkBoxesMotivo2[0] = (CheckBox) findViewById(R.id.checkbox_p0_opt02);
        checkBoxesMotivo2[1] = (CheckBox) findViewById(R.id.checkbox_p1_opt02);
        checkBoxesMotivo2[2] = (CheckBox) findViewById(R.id.checkbox_p2_opt02);
        checkBoxesMotivo2[3] = (CheckBox) findViewById(R.id.checkbox_p3_opt02);
        checkBoxesMotivo2[4] = (CheckBox) findViewById(R.id.checkbox_p4_opt02);
        checkBoxesMotivo2[5] = (CheckBox) findViewById(R.id.checkbox_p5_opt02);
        checkBoxesMotivo2[6] = (CheckBox) findViewById(R.id.checkbox_p6_opt02);
        checkBoxesMotivo2[7] = (CheckBox) findViewById(R.id.checkbox_p7_opt02);
        checkBoxesMotivo2[8] = (CheckBox) findViewById(R.id.checkbox_p8_opt02);
        checkBoxesMotivo2[9] = (CheckBox) findViewById(R.id.checkbox_p9_opt02);
        checkBoxesMotivo2[10] = (CheckBox) findViewById(R.id.checkbox_p10_opt02);
        checkBoxesMotivo2[11] = (CheckBox) findViewById(R.id.checkbox_p11_opt02);
        checkBoxesMotivo2[12] = (CheckBox) findViewById(R.id.checkbox_p12_opt02);
        checkBoxesMotivo2[13] = (CheckBox) findViewById(R.id.checkbox_p13_opt02);
        checkBoxesMotivo2[14] = (CheckBox) findViewById(R.id.checkbox_p14_opt02);
        checkBoxesMotivo2[15] = (CheckBox) findViewById(R.id.checkbox_p15_opt02);
        checkBoxesMotivo2[16] = (CheckBox) findViewById(R.id.checkbox_p16_opt02);
        checkBoxesMotivo2[17] = (CheckBox) findViewById(R.id.checkbox_p17_opt02);
        checkBoxesMotivo2[18] = (CheckBox) findViewById(R.id.checkbox_p18_opt02);
        checkBoxesMotivo2[19] = (CheckBox) findViewById(R.id.checkbox_p19_opt02);
        checkBoxesMotivo2[20] = (CheckBox) findViewById(R.id.checkbox_p20_opt02);
        checkBoxesMotivo2[21] = (CheckBox) findViewById(R.id.checkbox_p21_opt02);
        checkBoxesMotivo2[22] = (CheckBox) findViewById(R.id.checkbox_p22_opt02);
        checkBoxesMotivo2[23] = (CheckBox) findViewById(R.id.checkbox_p23_opt02);
        checkBoxesMotivo2[24] = (CheckBox) findViewById(R.id.checkbox_p24_opt02);
        checkBoxesMotivo2[25] = (CheckBox) findViewById(R.id.checkbox_p25_opt02);
        checkBoxesMotivo2[26] = (CheckBox) findViewById(R.id.checkbox_p26_opt02);
        checkBoxesMotivo2[27] = (CheckBox) findViewById(R.id.checkbox_p27_opt02);
        checkBoxesMotivo2[28] = (CheckBox) findViewById(R.id.checkbox_p28_opt02);
        checkBoxesMotivo2[29] = (CheckBox) findViewById(R.id.checkbox_p29_opt02);

        checkBoxesMotivo3[0] = (CheckBox) findViewById(R.id.checkbox_p0_opt03);
        checkBoxesMotivo3[1] = (CheckBox) findViewById(R.id.checkbox_p1_opt03);
        checkBoxesMotivo3[2] = (CheckBox) findViewById(R.id.checkbox_p2_opt03);
        checkBoxesMotivo3[3] = (CheckBox) findViewById(R.id.checkbox_p3_opt03);
        checkBoxesMotivo3[4] = (CheckBox) findViewById(R.id.checkbox_p4_opt03);
        checkBoxesMotivo3[5] = (CheckBox) findViewById(R.id.checkbox_p5_opt03);
        checkBoxesMotivo3[6] = (CheckBox) findViewById(R.id.checkbox_p6_opt03);
        checkBoxesMotivo3[7] = (CheckBox) findViewById(R.id.checkbox_p7_opt03);
        checkBoxesMotivo3[8] = (CheckBox) findViewById(R.id.checkbox_p8_opt03);
        checkBoxesMotivo3[9] = (CheckBox) findViewById(R.id.checkbox_p9_opt03);
        checkBoxesMotivo3[10] = (CheckBox) findViewById(R.id.checkbox_p10_opt03);
        checkBoxesMotivo3[11] = (CheckBox) findViewById(R.id.checkbox_p11_opt03);
        checkBoxesMotivo3[12] = (CheckBox) findViewById(R.id.checkbox_p12_opt03);
        checkBoxesMotivo3[13] = (CheckBox) findViewById(R.id.checkbox_p13_opt03);
        checkBoxesMotivo3[14] = (CheckBox) findViewById(R.id.checkbox_p14_opt03);
        checkBoxesMotivo3[15] = (CheckBox) findViewById(R.id.checkbox_p15_opt03);
        checkBoxesMotivo3[16] = (CheckBox) findViewById(R.id.checkbox_p16_opt03);
        checkBoxesMotivo3[17] = (CheckBox) findViewById(R.id.checkbox_p17_opt03);
        checkBoxesMotivo3[18] = (CheckBox) findViewById(R.id.checkbox_p18_opt03);
        checkBoxesMotivo3[19] = (CheckBox) findViewById(R.id.checkbox_p19_opt03);
        checkBoxesMotivo3[20] = (CheckBox) findViewById(R.id.checkbox_p20_opt03);
        checkBoxesMotivo3[21] = (CheckBox) findViewById(R.id.checkbox_p21_opt03);
        checkBoxesMotivo3[22] = (CheckBox) findViewById(R.id.checkbox_p22_opt03);
        checkBoxesMotivo3[23] = (CheckBox) findViewById(R.id.checkbox_p23_opt03);
        checkBoxesMotivo3[24] = (CheckBox) findViewById(R.id.checkbox_p24_opt03);
        checkBoxesMotivo3[25] = (CheckBox) findViewById(R.id.checkbox_p25_opt03);
        checkBoxesMotivo3[26] = (CheckBox) findViewById(R.id.checkbox_p26_opt03);
        checkBoxesMotivo3[27] = (CheckBox) findViewById(R.id.checkbox_p27_opt03);
        checkBoxesMotivo3[28] = (CheckBox) findViewById(R.id.checkbox_p28_opt03);
        checkBoxesMotivo3[29] = (CheckBox) findViewById(R.id.checkbox_p29_opt03);

        checkBoxesMotivo4[0] = (CheckBox) findViewById(R.id.checkbox_p0_opt04);
        checkBoxesMotivo4[1] = (CheckBox) findViewById(R.id.checkbox_p1_opt04);
        checkBoxesMotivo4[2] = (CheckBox) findViewById(R.id.checkbox_p2_opt04);
        checkBoxesMotivo4[3] = (CheckBox) findViewById(R.id.checkbox_p3_opt04);
        checkBoxesMotivo4[4] = (CheckBox) findViewById(R.id.checkbox_p4_opt04);
        checkBoxesMotivo4[5] = (CheckBox) findViewById(R.id.checkbox_p5_opt04);
        checkBoxesMotivo4[6] = (CheckBox) findViewById(R.id.checkbox_p6_opt04);
        checkBoxesMotivo4[7] = (CheckBox) findViewById(R.id.checkbox_p7_opt04);
        checkBoxesMotivo4[8] = (CheckBox) findViewById(R.id.checkbox_p8_opt04);
        checkBoxesMotivo4[9] = (CheckBox) findViewById(R.id.checkbox_p9_opt04);
        checkBoxesMotivo4[10] = (CheckBox) findViewById(R.id.checkbox_p10_opt04);
        checkBoxesMotivo4[11] = (CheckBox) findViewById(R.id.checkbox_p11_opt04);
        checkBoxesMotivo4[12] = (CheckBox) findViewById(R.id.checkbox_p12_opt04);
        checkBoxesMotivo4[13] = (CheckBox) findViewById(R.id.checkbox_p13_opt04);
        checkBoxesMotivo4[14] = (CheckBox) findViewById(R.id.checkbox_p14_opt04);
        checkBoxesMotivo4[15] = (CheckBox) findViewById(R.id.checkbox_p15_opt04);
        checkBoxesMotivo4[16] = (CheckBox) findViewById(R.id.checkbox_p16_opt04);
        checkBoxesMotivo4[17] = (CheckBox) findViewById(R.id.checkbox_p17_opt04);
        checkBoxesMotivo4[18] = (CheckBox) findViewById(R.id.checkbox_p18_opt04);
        checkBoxesMotivo4[19] = (CheckBox) findViewById(R.id.checkbox_p19_opt04);
        checkBoxesMotivo4[20] = (CheckBox) findViewById(R.id.checkbox_p20_opt04);
        checkBoxesMotivo4[21] = (CheckBox) findViewById(R.id.checkbox_p21_opt04);
        checkBoxesMotivo4[22] = (CheckBox) findViewById(R.id.checkbox_p22_opt04);
        checkBoxesMotivo4[23] = (CheckBox) findViewById(R.id.checkbox_p23_opt04);
        checkBoxesMotivo4[24] = (CheckBox) findViewById(R.id.checkbox_p24_opt04);
        checkBoxesMotivo4[25] = (CheckBox) findViewById(R.id.checkbox_p25_opt04);
        checkBoxesMotivo4[26] = (CheckBox) findViewById(R.id.checkbox_p26_opt04);
        checkBoxesMotivo4[27] = (CheckBox) findViewById(R.id.checkbox_p27_opt04);
        checkBoxesMotivo4[28] = (CheckBox) findViewById(R.id.checkbox_p28_opt04);
        checkBoxesMotivo4[29] = (CheckBox) findViewById(R.id.checkbox_p29_opt04);

        checkBoxesMotivo5[0] = (CheckBox) findViewById(R.id.checkbox_p0_opt05);
        checkBoxesMotivo5[1] = (CheckBox) findViewById(R.id.checkbox_p1_opt05);
        checkBoxesMotivo5[2] = (CheckBox) findViewById(R.id.checkbox_p2_opt05);
        checkBoxesMotivo5[3] = (CheckBox) findViewById(R.id.checkbox_p3_opt05);
        checkBoxesMotivo5[4] = (CheckBox) findViewById(R.id.checkbox_p4_opt05);
        checkBoxesMotivo5[5] = (CheckBox) findViewById(R.id.checkbox_p5_opt05);
        checkBoxesMotivo5[6] = (CheckBox) findViewById(R.id.checkbox_p6_opt05);
        checkBoxesMotivo5[7] = (CheckBox) findViewById(R.id.checkbox_p7_opt05);
        checkBoxesMotivo5[8] = (CheckBox) findViewById(R.id.checkbox_p8_opt05);
        checkBoxesMotivo5[9] = (CheckBox) findViewById(R.id.checkbox_p9_opt05);
        checkBoxesMotivo5[10] = (CheckBox) findViewById(R.id.checkbox_p10_opt05);
        checkBoxesMotivo5[11] = (CheckBox) findViewById(R.id.checkbox_p11_opt05);
        checkBoxesMotivo5[12] = (CheckBox) findViewById(R.id.checkbox_p12_opt05);
        checkBoxesMotivo5[13] = (CheckBox) findViewById(R.id.checkbox_p13_opt05);
        checkBoxesMotivo5[14] = (CheckBox) findViewById(R.id.checkbox_p14_opt05);
        checkBoxesMotivo5[15] = (CheckBox) findViewById(R.id.checkbox_p15_opt05);
        checkBoxesMotivo5[16] = (CheckBox) findViewById(R.id.checkbox_p16_opt05);
        checkBoxesMotivo5[17] = (CheckBox) findViewById(R.id.checkbox_p17_opt05);
        checkBoxesMotivo5[18] = (CheckBox) findViewById(R.id.checkbox_p18_opt05);
        checkBoxesMotivo5[19] = (CheckBox) findViewById(R.id.checkbox_p19_opt05);
        checkBoxesMotivo5[20] = (CheckBox) findViewById(R.id.checkbox_p20_opt05);
        checkBoxesMotivo5[21] = (CheckBox) findViewById(R.id.checkbox_p21_opt05);
        checkBoxesMotivo5[22] = (CheckBox) findViewById(R.id.checkbox_p22_opt05);
        checkBoxesMotivo5[23] = (CheckBox) findViewById(R.id.checkbox_p23_opt05);
        checkBoxesMotivo5[24] = (CheckBox) findViewById(R.id.checkbox_p24_opt05);
        checkBoxesMotivo5[25] = (CheckBox) findViewById(R.id.checkbox_p25_opt05);
        checkBoxesMotivo5[26] = (CheckBox) findViewById(R.id.checkbox_p26_opt05);
        checkBoxesMotivo5[27] = (CheckBox) findViewById(R.id.checkbox_p27_opt05);
        checkBoxesMotivo5[28] = (CheckBox) findViewById(R.id.checkbox_p28_opt05);
        checkBoxesMotivo5[29] = (CheckBox) findViewById(R.id.checkbox_p29_opt05);

        checkBoxesMotivo6[0] = (CheckBox) findViewById(R.id.checkbox_p0_opt06);
        checkBoxesMotivo6[1] = (CheckBox) findViewById(R.id.checkbox_p1_opt06);
        checkBoxesMotivo6[2] = (CheckBox) findViewById(R.id.checkbox_p2_opt06);
        checkBoxesMotivo6[3] = (CheckBox) findViewById(R.id.checkbox_p3_opt06);
        checkBoxesMotivo6[4] = (CheckBox) findViewById(R.id.checkbox_p4_opt06);
        checkBoxesMotivo6[5] = (CheckBox) findViewById(R.id.checkbox_p5_opt06);
        checkBoxesMotivo6[6] = (CheckBox) findViewById(R.id.checkbox_p6_opt06);
        checkBoxesMotivo6[7] = (CheckBox) findViewById(R.id.checkbox_p7_opt06);
        checkBoxesMotivo6[8] = (CheckBox) findViewById(R.id.checkbox_p8_opt06);
        checkBoxesMotivo6[9] = (CheckBox) findViewById(R.id.checkbox_p9_opt06);
        checkBoxesMotivo6[10] = (CheckBox) findViewById(R.id.checkbox_p10_opt06);
        checkBoxesMotivo6[11] = (CheckBox) findViewById(R.id.checkbox_p11_opt06);
        checkBoxesMotivo6[12] = (CheckBox) findViewById(R.id.checkbox_p12_opt06);
        checkBoxesMotivo6[13] = (CheckBox) findViewById(R.id.checkbox_p13_opt06);
        checkBoxesMotivo6[14] = (CheckBox) findViewById(R.id.checkbox_p14_opt06);
        checkBoxesMotivo6[15] = (CheckBox) findViewById(R.id.checkbox_p15_opt06);
        checkBoxesMotivo6[16] = (CheckBox) findViewById(R.id.checkbox_p16_opt06);
        checkBoxesMotivo6[17] = (CheckBox) findViewById(R.id.checkbox_p17_opt06);
        checkBoxesMotivo6[18] = (CheckBox) findViewById(R.id.checkbox_p18_opt06);
        checkBoxesMotivo6[19] = (CheckBox) findViewById(R.id.checkbox_p19_opt06);
        checkBoxesMotivo6[20] = (CheckBox) findViewById(R.id.checkbox_p20_opt06);
        checkBoxesMotivo6[21] = (CheckBox) findViewById(R.id.checkbox_p21_opt06);
        checkBoxesMotivo6[22] = (CheckBox) findViewById(R.id.checkbox_p22_opt06);
        checkBoxesMotivo6[23] = (CheckBox) findViewById(R.id.checkbox_p23_opt06);
        checkBoxesMotivo6[24] = (CheckBox) findViewById(R.id.checkbox_p24_opt06);
        checkBoxesMotivo6[25] = (CheckBox) findViewById(R.id.checkbox_p25_opt06);
        checkBoxesMotivo6[26] = (CheckBox) findViewById(R.id.checkbox_p26_opt06);
        checkBoxesMotivo6[27] = (CheckBox) findViewById(R.id.checkbox_p27_opt06);
        checkBoxesMotivo6[28] = (CheckBox) findViewById(R.id.checkbox_p28_opt06);
        checkBoxesMotivo6[29] = (CheckBox) findViewById(R.id.checkbox_p29_opt06);
    }

    public void radioButtonChecked(View view){
        int indexRow = getIndexRow(view.getId());
        int typeAnswer = getTipoRespuesta(view.getId());
        boolean checked = ((RadioButton)view).isChecked();
        if(checked){
            if(typeAnswer==1){
                checkBoxesMotivo1[indexRow].setChecked(false);
                checkBoxesMotivo2[indexRow].setChecked(false);
                checkBoxesMotivo3[indexRow].setChecked(false);
                checkBoxesMotivo4[indexRow].setChecked(false);
                checkBoxesMotivo5[indexRow].setChecked(false);
                checkBoxesMotivo6[indexRow].setChecked(false);

                checkBoxesMotivo1[indexRow].setEnabled(false);
                checkBoxesMotivo2[indexRow].setEnabled(false);
                checkBoxesMotivo3[indexRow].setEnabled(false);
                checkBoxesMotivo4[indexRow].setEnabled(false);
                checkBoxesMotivo5[indexRow].setEnabled(false);
                checkBoxesMotivo6[indexRow].setEnabled(false);
            }
            else if(typeAnswer==2){
                checkBoxesMotivo1[indexRow].setEnabled(true);
                checkBoxesMotivo2[indexRow].setEnabled(true);
                checkBoxesMotivo3[indexRow].setEnabled(true);
                checkBoxesMotivo4[indexRow].setEnabled(true);
                checkBoxesMotivo5[indexRow].setEnabled(true);
                checkBoxesMotivo6[indexRow].setEnabled(true);
            }
            else if(typeAnswer==3){
                checkBoxesMotivo1[indexRow].setEnabled(true);
                checkBoxesMotivo2[indexRow].setEnabled(true);
                checkBoxesMotivo3[indexRow].setEnabled(true);
                checkBoxesMotivo4[indexRow].setEnabled(true);
                checkBoxesMotivo5[indexRow].setEnabled(true);
                checkBoxesMotivo6[indexRow].setEnabled(true);
            }
        }
        else{

        }
    }

    public int getIndexRow(int id){
        for(int i=0;i<NUMERO_PRODUCTOS;i++){
            if(id==radioButtonsExhibicionSi[i].getId() || id==radioButtonsExhibicionNo[i].getId() ||
                    id==radioButtonsExhibicionProtisa[i].getId()){
                return i;
            }
        }
        return -1;
    }

    public int getTipoRespuesta(int id){
        for(int i=0;i<NUMERO_PRODUCTOS;i++){
            if(id==radioButtonsExhibicionSi[i].getId()){
                return 1;
            }
        }

        for(int i=0;i<NUMERO_PRODUCTOS;i++){
            if(id==radioButtonsExhibicionNo[i].getId()){
                return 2;
            }
        }

        for(int i=0;i<NUMERO_PRODUCTOS;i++){
            if(id==radioButtonsExhibicionProtisa[i].getId()){
                return 3;
            }
        }
        return -1;
    }

    public void guardarVisita(View view){
        String info="";
        boolean grabar=false;
        for(int i=0;i<NUMERO_PRODUCTOS;i++){
            if(radioButtonsExhibicionSi[i].isChecked()){
                Log.d("checking",i+"_Si");
                info+="100";
            }
            else if(radioButtonsExhibicionNo[i].isChecked()){
                Log.d("checking",i+"_No");
                info+="010";
                //alerta para que cuando marque no o protisa, deba marcar al menos un motivo
                if(!checkBoxesMotivo1[i].isChecked() && !checkBoxesMotivo2[i].isChecked() && !checkBoxesMotivo3[i].isChecked() &&
                        !checkBoxesMotivo4[i].isChecked() && !checkBoxesMotivo5[i].isChecked() && !checkBoxesMotivo6[i].isChecked()){
                    AlertDialog.Builder message = new AlertDialog.Builder(this);
                    message.setTitle("Atencion")
                            .setMessage("Debes marcar al menos un motivo por el que no existe producto "+textViewNombreProducto[i].getText())
                            .setPositiveButton("Entendido", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            }).create().show();
                    break;
                }
            }
            else if(radioButtonsExhibicionProtisa[i].isChecked()){
                Log.d("checking",i+"_Protisa");
                info+="001";
                if(!checkBoxesMotivo1[i].isChecked() && !checkBoxesMotivo2[i].isChecked() && !checkBoxesMotivo3[i].isChecked() &&
                        !checkBoxesMotivo4[i].isChecked() && !checkBoxesMotivo5[i].isChecked() && !checkBoxesMotivo6[i].isChecked()){
                    AlertDialog.Builder message = new AlertDialog.Builder(this);
                    message.setTitle("Atencion")
                            .setMessage("Debes marcar al menos un motivo por el que no existe producto "+textViewNombreProducto[i].getText())
                            .setPositiveButton("Entendido", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            }).create().show();
                    break;
                }
            }
            else{
                AlertDialog.Builder message = new AlertDialog.Builder(this);
                message.setMessage("Te falta marcar el producto "+textViewNombreProducto[i].getText());
                message.setPositiveButton("Entendido", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                message.create().show();
                break;
            }

            if(checkBoxesMotivo1[i].isChecked()) info+="1";
            else info+="0";

            if(checkBoxesMotivo2[i].isChecked()) info+="1";
            else info+="0";

            if(checkBoxesMotivo3[i].isChecked()) info+="1";
            else info+="0";

            if(checkBoxesMotivo4[i].isChecked()) info+="1";
            else info+="0";

            if(checkBoxesMotivo5[i].isChecked()) info+="1";
            else info+="0";

            if(checkBoxesMotivo6[i].isChecked()) info+="1";
            else info+="0";

            info+=",";
            if(i==NUMERO_PRODUCTOS-1) grabar=true;
        }

        if(grabar){
            info+="\n";
            try{
                File storageDir = new File(cliente.getPath());
                storageDir.mkdirs();
                File file = new File(storageDir,"visita.txt");
                FileOutputStream fos = new FileOutputStream(file, true);
                fos.write(info.getBytes());
                fos.close();
                Toast.makeText(getApplicationContext(), "Informacion guardada", Toast.LENGTH_SHORT).show();
                MediaScannerConnection.scanFile(this,new String[]{file.toString()},null,null);
            } catch(Exception e){
                e.printStackTrace();
            }
        }

    }

}
