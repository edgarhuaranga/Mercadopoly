package com.triunfo.mercadopoly;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListaClientes extends AppCompatActivity {

    String rol;
    String usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_clientes);
        getSupportActionBar().hide();
        usuario = getIntent().getStringExtra(Login.USUARIO_LABEL);
        rol = getIntent().getStringExtra(Login.ROL_LABEL);
        RecyclerView recyclerViewVisitados = (RecyclerView) findViewById(R.id.recycler_lista_visitados);
        recyclerViewVisitados.setLayoutManager(new LinearLayoutManager(this));
        RecyclerClientesAdapter adapter = new RecyclerClientesAdapter(createItemList(usuario, rol),rol, getApplicationContext());
        recyclerViewVisitados.setAdapter(adapter);
    }

    private List<Cliente> createItemList(String user, String rol) {
        List<Cliente> a = new ArrayList<>();
        String[] db = getResources().getStringArray(R.array.dbclientes);
        for(int i=0; i<db.length; i+=11){
            if(rol.equalsIgnoreCase("agente") && user.equalsIgnoreCase(db[i+2])){
                a.add(new Cliente(db[i],getApplicationContext()));
            }
            if(rol.equalsIgnoreCase("supervisor") && user.equalsIgnoreCase(db[i+1])){
                a.add(new Cliente(db[i],getApplicationContext()));
            }
        }
        return a;
    }
}

