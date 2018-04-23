package com.example.andres.jbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.andres.jbook.Modelos.Sala;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MenuReservar extends AppCompatActivity {

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("recursos").child("salas");
    }

    public void goSalas(View view) {
        Intent intent = new Intent(MenuReservar.this, ConsultarListaSalas.class);
        startActivity(intent);
    }

    public void addResource(View view) {
        Sala sala1 = new Sala("1","sala a", "sala con tablero", "libre", "piso 2", 6);
        Sala sala2 = new Sala("2","sala z", "sala con tablero digital", "libre", "sotano 1", 8);
        DatabaseReference p1 = mDatabase.push();
        sala1.setId(p1.getKey().toString());
        p1.setValue(sala1);
        DatabaseReference p2 = mDatabase.push();
        sala2.setId(p2.getKey().toString());
        p2.setValue(sala2);
    }

    public void signOut(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(MenuReservar.this, MainActivity.class));
    }
}
