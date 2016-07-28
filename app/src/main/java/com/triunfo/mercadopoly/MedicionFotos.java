package com.triunfo.mercadopoly;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;

public class MedicionFotos extends AppCompatActivity {
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100 ;
    ImageView[] tomaFotosButtons;
    String codigo;
    String rol;
    Cliente cliente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicion_fotos);
        codigo = getIntent().getStringExtra("codigo");
        rol = getIntent().getStringExtra("rol");
        cliente = new Cliente(codigo, getApplicationContext());
        tomaFotosButtons = new ImageView[10];
        setupViews();
    }

    public void setupViews(){
        tomaFotosButtons[0] = (ImageView) findViewById(R.id.button_tomafoto1);
        tomaFotosButtons[1] = (ImageView) findViewById(R.id.button_tomafoto2);
        tomaFotosButtons[2] = (ImageView) findViewById(R.id.button_tomafoto3);
        tomaFotosButtons[3] = (ImageView) findViewById(R.id.button_tomafoto4);
        tomaFotosButtons[4] = (ImageView) findViewById(R.id.button_tomafoto5);
        tomaFotosButtons[5] = (ImageView) findViewById(R.id.button_tomafoto6);
        tomaFotosButtons[6] = (ImageView) findViewById(R.id.button_tomafoto7);
        tomaFotosButtons[7] = (ImageView) findViewById(R.id.button_tomafoto8);
        tomaFotosButtons[8] = (ImageView) findViewById(R.id.button_tomafoto9);
        tomaFotosButtons[9] = (ImageView) findViewById(R.id.button_tomafoto10);
    }

    public int getIndexFoto(int id){
        for(int i=0;i<10; i++){
            if(tomaFotosButtons[i].getId()==id) return i;
        }
        return -1;
    }

    public void tomaFoto(View view){
        int indexFoto = getIndexFoto(view.getId());
        indexFoto++;
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePictureIntent.resolveActivity(getPackageManager()) != null){
            File photoFile = null;
            try{
                photoFile = createImageFile(createImageName(indexFoto),indexFoto);
            } catch (Exception e){
                e.printStackTrace();
            }

            if(photoFile != null){
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));
                startActivityForResult(takePictureIntent,CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE+indexFoto);
                MediaScannerConnection.scanFile(this,new String[]{photoFile.toString()},null,null);
            }
        }
    }

    public File getLastPhotoTaken(int index){
        File file = new File(cliente.getPathFoto());
        File[] carpetasInternas = file.listFiles();
        File last = null;
        for(int i=0;i<carpetasInternas.length;i++){
            if(carpetasInternas[i].isDirectory() && carpetasInternas[i].getName().equalsIgnoreCase(""+index)){
                File[] fotos = carpetasInternas[i].listFiles();
                int minim = 0;
                for(int j=0; j<fotos.length; j++){
                    Log.d("hora", fotos[j].getAbsolutePath());
                    int sec = Integer.parseInt(fotos[j].getName().substring(0,2));
                    int min = Integer.parseInt(fotos[j].getName().substring(3,5));
                    int hour = Integer.parseInt(fotos[j].getName().substring(6,8));
                    if(hour*60*60+min*60+sec > minim){
                        last = fotos[j];
                        minim = hour*60*60+min*60+sec;
                    }
                    Log.d("hora", sec+"_"+min+"_"+hour);
                }
            }
        }
        return last;
    }

    public File createImageFile(String nombreFoto, int index) throws IOException {
        File storageDir = new File(cliente.getPathFoto()+index+"/");
        storageDir.mkdirs();
        File image = new File(storageDir, nombreFoto);
        return image;
    }

    public File createImageFile(String nombreFoto) throws IOException {
        File storageDir = new File(cliente.getPathFoto());
        storageDir.mkdirs();
        File image = new File(storageDir, nombreFoto);
        return image;
    }

    public String createImageName(int indexfoto){
        String res="";
        //Toast.makeText(getApplicationContext(), res, Toast.LENGTH_LONG).show();
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        if(hour<10) res = res+"0"+hour;
        else res += hour;
        res+=":";
        int minute = c.get(Calendar.MINUTE);
        if(minute<10) res = res+"0"+minute;
        else res += minute;
        res+=":";
        int second = c.get(Calendar.SECOND);
        if(second<10) res = res+"0"+second;
        else res += second;
        res+="_";


        res += rol+indexfoto+codigo;
        /*try{
            File carpetaFoto = new File(clienteVisitado.getPath()+"Semana"+semana+"/"+dia+"/"+clienteVisitado.codigo+"/Fotos/");
            res += clienteVisitado.codigo + (carpetaFoto.listFiles().length+1);
        } catch (Exception e){
            res += clienteVisitado.codigo+"1";
            e.printStackTrace();
            Log.i("Foto",clienteVisitado.getPath());
        }*/
        res += ".jpg";
        return res;
    }

    public Bitmap getSampleBitmapFromFile(String path, int reqWidth, int reqHeight){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try{
            BitmapFactory.decodeStream(new FileInputStream(new File(path)), null, options);

            int scale = calculateInSampleSize(options, reqWidth, reqHeight);

            BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize = scale;

            return BitmapFactory.decodeStream(new FileInputStream(new File(path)), null, o2);
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            // Calculate ratios of height and width to requested height and
            // width
            final int heightRatio = Math.round((float)height / (float)reqHeight);
            final int widthRatio = Math.round((float)width / (float)reqWidth);

            // Choose the smallest ratio as inSampleSize value, this will
            // guarantee
            // a final image with both dimensions larger than or equal to the
            // requested height and width.
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }

        return inSampleSize;
    }

    public void copiar(File src, File dst){
        try{
            InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dst);

            // Transfer bytes from in to out
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode >= CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE && requestCode<=CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE+10) {
            if (resultCode == RESULT_OK) {
                // Image captured and saved to fileUri specified in the Intent

                //Bitmap photo = (Bitmap) data.getExtras().get("data");
                int indx = requestCode-CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE;
                try{

                    File ultima = getLastPhotoTaken(indx);
                    File copia = new File(cliente.getPathFoto()+"foto"+indx+".jpg");
                    copiar(ultima,copia);
                    //Bitmap photo = BitmapFactory.decodeFile(ultima.getPath());
                    Bitmap photo = getSampleBitmapFromFile(ultima.getPath(),100,80);
                    tomaFotosButtons[indx-1].setImageBitmap(photo);

                    File fotosDir = new File(cliente.getPathFoto());
                    if(fotosDir.isDirectory()){
                        File[] fotos = fotosDir.listFiles();
                        for(int i=0; i<fotos.length; i++){
                            Log.d("foo",fotos[i].getAbsolutePath());
                            Log.d("foo",fotos[i].getName());
                            if(fotos[i].getName().indexOf(indx+cliente.codigo)!=-1){

                            }
                        }
                    }
                    //tomaFotosButtons[requestCode-CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE-1].setImageBitmap(photo);
                } catch (Exception e){
                    e.printStackTrace();
                }

                //imageView.setImageBitmap(photo);
                Log.d("foto","foto"+(requestCode-CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE));


            } else if (resultCode == RESULT_CANCELED) {
                // User cancelled the image capture
            } else {
                // Image capture failed, advise user
            }
        }
    }
}
