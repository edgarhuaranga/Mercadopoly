package com.triunfo.mercadopoly;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private String rol;
    static public String USUARIO_LABEL="usuario";
    static public String CLAVE_LABEL="password";
    static public String ROL_LABEL="rol";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        rol = "agente";
    }


    public void onRadioButtonClicked(View view){
        Boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.radio_agente:
                if(checked){
                    rol = "agente";
                }
                else{

                }
                break;
            case R.id.radio_supervisor:
                if(checked){
                    rol = "supervisor";
                }
                else{

                }
                break;
            default:
                break;
        }
    }

    public void accederApp(View view){
        String usuario = ((EditText) findViewById(R.id.edittext_usuario)).getText().toString();
        String pass = ((EditText) findViewById(R.id.edittext_pass)).getText().toString();
        if(camposValidos(usuario,pass)){
            Intent intent = new Intent(this,ListaClientes.class);
            intent.putExtra(USUARIO_LABEL,usuario);
            intent.putExtra(CLAVE_LABEL,pass);
            intent.putExtra(ROL_LABEL,rol);
            startActivity(intent);
        }
    }

    public boolean camposValidos(String usuario, String password){


        if(usuario==null || usuario.length()==0){
            Toast.makeText(Login.this, "Campo usuario vacio", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(password==null || password.length()==0){
            Toast.makeText(Login.this, "Campo password vacio", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(!usuario.contains("age") && rol.equalsIgnoreCase("agente")){
            Toast.makeText(Login.this, "El rol no es el correcto", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(!usuario.contains("sup") && rol.equalsIgnoreCase("supervisor")){
            Toast.makeText(Login.this, "El rol no es el correcto", Toast.LENGTH_SHORT).show();
            return false;
        }

        String loginDB[] = getResources().getStringArray(R.array.loginArray);
        for(int i=0;i<loginDB.length; i+=2){
            if(loginDB[i].equalsIgnoreCase(usuario)){

                Toast.makeText(Login.this, "Usuario correcto", Toast.LENGTH_SHORT).show();
                if(loginDB[i+1].equalsIgnoreCase(password)){
                    Toast.makeText(Login.this, "Acceso autorizado", Toast.LENGTH_SHORT).show();
                    return true;
                }
                else{
                    Toast.makeText(Login.this, "Contraseña erronea", Toast.LENGTH_SHORT).show();
                    return false;
                }
            }
        }
        Toast.makeText(Login.this,"Usuario y contraseña equivocada",Toast.LENGTH_SHORT).show();
        return false;
    }
}
