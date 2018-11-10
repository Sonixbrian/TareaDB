package com.example.brian.tarea_db;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.DatabaseMetaData;

public class Insertar extends AppCompatActivity {

    DataBaseHelper myDb;
    EditText txtNombre, txtApellido, txtTelefono;
    Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar);

        myDb = new DataBaseHelper(this);
        txtNombre = (EditText) findViewById(R.id.idNombre);
        txtApellido = (EditText) findViewById(R.id.idApellido);
        txtTelefono = (EditText) findViewById(R.id.idTelefono);
        btnClick = (Button) findViewById(R.id.btnId);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = txtNombre.getText().toString();
                String apellido = txtApellido.getText().toString();
                String telefono = txtTelefono.getText().toString();
                Boolean result = myDb.insertarDatos(nombre, apellido, telefono);
                if (result == true){
                    Toast.makeText(getApplicationContext(), "Error al insertar los datos ", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
