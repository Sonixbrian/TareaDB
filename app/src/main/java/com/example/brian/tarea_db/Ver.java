package com.example.brian.tarea_db;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Ver extends AppCompatActivity {

    DataBaseHelper myDb;
    TextView txtResultado;
    Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver);

        myDb = new DataBaseHelper(this);
        txtResultado = (TextView) findViewById(R.id.idResultado);
        btnClick = (Button) findViewById(R.id.idBtn);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myDb.getAllData();
                StringBuffer stringBuffer = new StringBuffer();
                if (res != null && res.getCount() > 0){
                    while (res.moveToNext()){
                        stringBuffer.append("Id: " + res.getString(0) + "\n");
                        stringBuffer.append("Nombre: " + res.getString(1) + "\n");
                        stringBuffer.append("Apellido:" + res.getString(2) + "\n");
                        stringBuffer.append("Telefono: " + res.getString(3) + "\n");
                    }
                    txtResultado.setText(stringBuffer.toString());
                    Toast.makeText(getApplicationContext(), "Datos Recuperados con Exito", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "No hay datos para recuperar", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
