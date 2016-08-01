package com.triunfo.mercadopoly;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.util.Calendar;
import java.util.Scanner;

/**
 * Created by root on 21/07/16.
 */
public class Cliente {
    String codigo;
    String nombre;
    String direccion;
    String giro;
    String mercado;
    String ciudad;
    String representante;
    String dni;
    String productosExhigidos;

    public Cliente(String codigo, Context context){
        String db[] = context.getResources().getStringArray(R.array.dbclientes);
        for(int i =0; i<db.length; i+=11){
            if(codigo.equalsIgnoreCase(db[i])){
                this.codigo = codigo;
                this.nombre = db[i+4];
                this.direccion = db[i+7];
                this.giro = db[i+9];
                this.mercado = db[i+8];
                this.ciudad = db[i+3];
                this.representante = db[i+5];
                this.dni = db[i+6];
                this.productosExhigidos = db[i+10];
            }
        }
    }

    String getPath(){
        String s="";

        int dia, diames, semana, mes;
        int semanacampania = 0;
        mes = (Calendar.getInstance()).get(Calendar.MONTH);
        semana = (Calendar.getInstance()).get(Calendar.WEEK_OF_YEAR);
        dia = (Calendar.getInstance()).get(Calendar.DAY_OF_WEEK);
        diames = (Calendar.getInstance()).get(Calendar.DAY_OF_MONTH);
        Log.d("fecha",diames+"/"+mes+"/");
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

        String[] meses = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Setiembre","Octubre","Noviembre","Diciembre"};
        String diaSemana="";
        switch (dia){
            case Calendar.MONDAY:
                diaSemana="Lunes";
                break;
            case Calendar.TUESDAY:
                diaSemana="Martes";
                break;
            case Calendar.WEDNESDAY:
                diaSemana="Miercoles";
                break;
            case Calendar.THURSDAY:
                diaSemana="Jueves";
                break;
            case Calendar.FRIDAY:
                diaSemana="Viernes";
                break;
            case Calendar.SATURDAY:
                diaSemana="Sabado";
                break;
            case Calendar.SUNDAY:
                diaSemana="Domingo";
                break;
            default:
                diaSemana="ErrorSemana";
                break;
        }
        s += Environment.getExternalStorageDirectory() + "/MercadoTon/"+meses[mes]+"/"+"Semana"+semanacampania+"/"+diaSemana+"/"+codigo+"/";
        return s;
    }

    String getPathFoto(){
        String pathCliente = this.getPath();
        pathCliente += "Fotos/";
        return pathCliente;
    }

    String getPathCompetencia(){
        String pathCompetencia = this.getPath();
        pathCompetencia += "Competencia/";
        return pathCompetencia;
    }

    String getComentarioFoto(int index){
        try{
            File file = new File(getPathFoto()+"comentarioFoto"+index+".txt");
            Scanner scanner = new Scanner(file);
            String comentario="";
            while(scanner.hasNextLine()){
                comentario = scanner.nextLine();
            }
            return comentario;
        }catch (Exception e){
            return "No hay comentario";
        }
    }
}
