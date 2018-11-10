package com.example.brian.tarea_db;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button Insertar, Editar, Ver, Eliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Insertar = (Button) findViewById(R.id.btnInsertar);
        Insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Insertar.class);
                startActivity(i);

            }
        });

        Editar = (Button) findViewById(R.id.btnEditar);
        Editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Editar.class);
                startActivity(i);
            }
        });

        Ver = (Button) findViewById(R.id.btnVer);
        Ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Ver.class);
                startActivity(i);
            }
        });

        Eliminar = (Button) findViewById(R.id.btnEliminar);
        Eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Eliminar.class);
                startActivity(i);
            }
        });
    }
}
