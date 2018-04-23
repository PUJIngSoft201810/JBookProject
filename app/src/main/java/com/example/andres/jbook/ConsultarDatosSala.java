package com.example.andres.jbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.andres.jbook.Modelos.Sala;

import java.io.Serializable;

public class ConsultarDatosSala extends AppCompatActivity {

    Sala actual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_sala);

        TextView nomSala = (TextView) findViewById(R.id.nombreS);
        TextView ubiSala = (TextView) findViewById(R.id.ubicacionS);
        TextView capSala = (TextView) findViewById(R.id.textView8);
        TextView descripSala = (TextView) findViewById(R.id.descripcionS);

        actual = (Sala) getIntent().getExtras().getSerializable("objeto");

        nomSala.setText(actual.getNombre().toString());
        ubiSala.setText(actual.getUbicacion().toString());
        capSala.setText(actual.getCapacidad()+"");
        descripSala.setText(actual.getDescripcion());
    }

    public void toSelectDate(View view) {
        Intent intent = new Intent(ConsultarDatosSala.this, FechaReservaSala.class);
        intent.putExtra("objeto", (Serializable) actual);
        startActivity(intent);
    }
}
