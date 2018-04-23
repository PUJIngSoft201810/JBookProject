package com.example.andres.jbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.andres.jbook.Modelos.Adaptador;
import com.example.andres.jbook.Modelos.Sala;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;
import java.util.ArrayList;


public class ConsultarListaSalas extends AppCompatActivity {

    private static final String TAG = "listSal";
    private DatabaseReference mDatabase;


    ArrayList<Sala> misSalas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salas_lista);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("recursos").child("salas");
        misSalas = new ArrayList<Sala>();
        ListView listaVista = (ListView) findViewById(R.id.listaSalas);
        //misSalas.add(new Sala("1","sala a", "sala con tablero y mas cosas", "libre", "piso 2", 6));
        //misSalas.add(new Sala("2","sala DB", "sala con tablero y mas cosas2", "reservado", "sotano1", 8));
        final Adaptador miAdaptador = new Adaptador(this, misSalas);
        listaVista.setAdapter(miAdaptador);

        ChildEventListener childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {
                Log.d(TAG, "onChildAdded:" + dataSnapshot.getKey());

                // A new comment has been added, add it to the displayed list
                Sala sala = dataSnapshot.getValue(Sala.class);

                // ...
                misSalas.add(sala);
                miAdaptador.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String previousChildName) {
                Log.d(TAG, "onChildChanged:" + dataSnapshot.getKey());

                // A comment has changed, use the key to determine if we are displaying this
                // comment and if so displayed the changed comment.
                Sala newSala = dataSnapshot.getValue(Sala.class);
                String salaKey = dataSnapshot.getKey();

                // ...
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Log.d(TAG, "onChildRemoved:" + dataSnapshot.getKey());

                // A comment has changed, use the key to determine if we are displaying this
                // comment and if so remove it.
                String salaKey = dataSnapshot.getKey();

                // ...
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String previousChildName) {
                Log.d(TAG, "onChildMoved:" + dataSnapshot.getKey());

                // A comment has changed position, use the key to determine if we are
                // displaying this comment and if so move it.
                Sala movedSala = dataSnapshot.getValue(Sala.class);
                String salaKey = dataSnapshot.getKey();

                // ...
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "postComments:onCancelled", databaseError.toException());
                Toast.makeText(ConsultarListaSalas.this, "Failed to load comments.",
                        Toast.LENGTH_SHORT).show();
            }
        };
        mDatabase.addChildEventListener(childEventListener);

        listaVista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Sala miSalita = (Sala) adapterView.getItemAtPosition(i);
                Intent intent = new Intent(ConsultarListaSalas.this, ConsultarDatosSala.class);
                intent.putExtra("objeto", (Serializable) miSalita);
                startActivity(intent);
            }
        });
    }
}
