package com.triunfo.mercadopoly;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**
 * Created by root on 21/07/16.
 */
public class Cliente {
    /*String codigo;//0
    String nombre;//
    String direccion;
    String giro;
    String mercado;
    String ciudad;
    String representante;
    String dni;
    String productosExhigidos;*/

    public static final int INDEX_DISTRIBUIDOR01=0;
    public static final int INDEX_DISTRIBUIDOR02=1;
    public static final int INDEX_DISTRIBUIDOR03=2;
    public static final int INDEX_DISTRIBUIDOR04=3;
    public static final int INDEX_DISTRIBUIDOR05=4;
    public static final int INDEX_DISTRIBUIDOR06=5;

    public static final int INDEX_SETIEMBRE=1;
    public static final int INDEX_OCTUBRE=2;
    public static final int INDEX_NOVIEMBRE=3;
    public static final int INDEX_DICIEMBRE=4;
    public static final int INDEX_ENERO=5;

    public static final int INDEX_NOMBRE01=0;
    public static final int INDEX_NOMBRE02=1;
    public static final int INDEX_NOMBRE03=2;
    public static final int INDEX_NOMBRE04=3;
    public static final int INDEX_NOMBRE05=4;
    public static final int INDEX_NOMBRE06=5;
    public static final int INDEX_NOMBRETOTAL=6;

    String codigo;
    String supervisor;
    String gestor;
    String ciudad;
    String distrito;
    String nombre;
    String representante;
    String dni;
    String direccion;
    String mercado;
    String giro;
    String productosExhigidos;
    String comodinesTotales;
    String comodinesUsados;
    String comodinesRestantes;

    String distribuidora01;
    String distribuidora02;
    String distribuidora03;
    String distribuidora04;
    String distribuidora05;
    String distribuidora06;

    String nombreCompra01;
    String nombreCompra02;
    String nombreCompra03;
    String nombreCompra04;
    String nombreCompra05;
    String nombreCompra06;


    String[][][] infoCompras;

    String premioSetiembre;
    String premioOctubre;
    String premioNoviembre;
    String premioDiciembre;
    String premioEnero;

    public Cliente(String codigo, Context context){
        String db[] = context.getResources().getStringArray(R.array.dbclientes);
        for(int i =0; i<db.length; i+=27){
            if(codigo.equalsIgnoreCase(db[i])){
                this.codigo = codigo;
                this.supervisor=db[i+1];
                this.gestor=db[i+2];
                this.ciudad=db[i+3];
                this.distrito=db[i+4];
                this.nombre = db[i+5];
                this.representante = db[i+6];
                this.dni = db[i+7];
                this.direccion = db[i+8];
                this.mercado = db[i+9];
                this.giro = db[i+10];
                this.productosExhigidos = db[i+11];
                this.comodinesTotales = db[i+12];
                this.comodinesUsados = db[i+13];
                this.comodinesRestantes = db[i+14];
                this.distribuidora01 = db[i+15];
                this.distribuidora02 = db[i+16];
                this.distribuidora03 = db[i+17];
                this.distribuidora04 = db[i+18];
                this.distribuidora05 = db[i+19];
                this.distribuidora06 = db[i+20];

                this.nombreCompra01 = db[i+21];
                this.nombreCompra02 = db[i+22];
                this.nombreCompra03 = db[i+23];
                this.nombreCompra04 = db[i+24];
                this.nombreCompra05 = db[i+25];
                this.nombreCompra06 = db[i+26];

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
        s += Environment.getExternalStorageDirectory() + "/MercaTon/"+meses[mes]+"/"+"Semana"+semanacampania+"/"+diaSemana+"/"+codigo+"/";
        //s += "/sdcard1" + "/MercadoTon/"+meses[mes]+"/"+"Semana"+semanacampania+"/"+diaSemana+"/"+codigo+"/";

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

    ArrayList<String> getPathPhotos(int numsemana){
        ArrayList<String> res = new ArrayList<>();
        File mercaton = new File(Environment.getExternalStorageDirectory()+"/MercaTon/");
        if(mercaton.exists()){
            File[] meses = mercaton.listFiles();
            for(int i=0; i<meses.length; i++){
                File mes = meses[i];
                if(mes.isDirectory()){
                    File[] semanas = mes.listFiles();
                    for(int j=0; j<semanas.length; j++){
                        File semana = semanas[j];
                        Log.d("semanapath",semana.getAbsolutePath());
                        Log.d("semanapath",semana.getName().substring(6));
                        int semnum = Integer.parseInt(semana.getName().substring(6));
                        if(semnum==numsemana){

                            if(semana.isDirectory()){
                                File[] dias = semana.listFiles();
                                for(int k=0; k<dias.length; k++){
                                    File dia = dias[k];
                                    if(dia.isDirectory()){
                                        File[] visitados = dia.listFiles();
                                        for(int m=0; m<visitados.length; m++){
                                            if(visitados[m].getName().equalsIgnoreCase(codigo)){
                                                //res.add(visitados[m].getAbsolutePath()+"/Fotos/");
                                                File fotoDir = new File(visitados[m].getPath()+"/Fotos/");
                                                if(fotoDir.exists()){
                                                    File[] fotosyComentarios = fotoDir.listFiles();
                                                    for(int ii=0; ii<fotosyComentarios.length;ii++){
                                                        if(fotosyComentarios[ii].isFile()){
                                                            if(fotosyComentarios[ii].getName().contains(".jpg")){
                                                                res.add(fotosyComentarios[ii].getAbsolutePath());
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    String getPremio(int mes, Context context){
        String[] dbpremios = context.getResources().getStringArray(R.array.dbpremio);
        for(int i=0; i<dbpremios.length; i+=6){
            if(dbpremios[i].equalsIgnoreCase(codigo)) return dbpremios[i+mes];
        }
        return "Not found";
    }
    @Override
    public String toString() {
        return "Cliente{" +
                "codigo='" + codigo + '\'' +
                ", supervisor='" + supervisor + '\'' +
                ", gestor='" + gestor + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", distrito='" + distrito + '\'' +
                ", nombre='" + nombre + '\'' +
                ", representante='" + representante + '\'' +
                ", dni='" + dni + '\'' +
                ", direccion='" + direccion + '\'' +
                ", mercado='" + mercado + '\'' +
                ", giro='" + giro + '\'' +
                ", productosExhigidos='" + productosExhigidos + '\'' +
                ", comodinesTotales='" + comodinesTotales + '\'' +
                ", comodinesUsados='" + comodinesUsados + '\'' +
                ", comodinesRestantes='" + comodinesRestantes + '\'' +
                ", distribuidora01='" + distribuidora01 + '\'' +
                ", distribuidora02='" + distribuidora02 + '\'' +
                ", distribuidora03='" + distribuidora03 + '\'' +
                ", distribuidora04='" + distribuidora04 + '\'' +
                ", distribuidora05='" + distribuidora05 + '\'' +
                ", distribuidora06='" + distribuidora06 + '\'' +
                ", nombreCompra01='" + nombreCompra01 + '\'' +
                ", nombreCompra02='" + nombreCompra02 + '\'' +
                ", nombreCompra03='" + nombreCompra03 + '\'' +
                ", nombreCompra04='" + nombreCompra04 + '\'' +
                ", nombreCompra05='" + nombreCompra05 + '\'' +
                ", nombreCompra06='" + nombreCompra06 + '\'' +
                '}';
    }
}
