package com.example.brian.tarea_db;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Editar extends AppCompatActivity {

    DataBaseHelper myDb;
    EditText textId, textNombre, textApellido, textTelefono;
    Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        myDb = new DataBaseHelper(this);
        textId = (EditText) findViewById(R.id.idID);
        textNombre = (EditText) findViewById(R.id.idNombre);
        textApellido = (EditText) findViewById(R.id.idApellido);
        textTelefono = (EditText) findViewById(R.id.idTelefono);
        btnClick = (Button) findViewById(R.id.btnActualizar);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = textId.getText().toString();
                String nombre = textNombre.getText().toString();
                String apellido = textApellido.getText().toString();
                String telefono = textTelefono.getText().toString();
                Boolean result = myDb.updateData(id, nombre, apellido, telefono);
                if (result == true){
                    Toast.makeText(getApplicationContext(), "Datos Actualizados con Exito", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "No hay filas afectadad", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
