package com.example.brian.tarea_db;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Eliminar extends AppCompatActivity {

    DataBaseHelper myDB;
    EditText txtID;
    Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);

        myDB = new DataBaseHelper(this);
        txtID = (EditText) findViewById(R.id.idID);
        btnClick = (Button) findViewById(R.id.idBTN);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = txtID.getText().toString();
                int result = myDB.deleteData(id);
                Toast.makeText(getApplicationContext(), result + "Filas afectadas", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
