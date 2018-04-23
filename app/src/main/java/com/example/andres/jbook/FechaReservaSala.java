package com.example.andres.jbook;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Pair;
import android.view.View;
import android.widget.ExpandableListView;

import com.example.andres.jbook.Modelos.fechaAdaptador;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class FechaReservaSala extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private static final String TAG = "SelectFecha";
    private ExpandableListView expandableListView;
    private fechaAdaptador miAdaptador;
    private ArrayList<Pair<String, ArrayList<Pair<String, String>>>> miLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fecha_reserva_sala);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mDatabase = FirebaseDatabase.getInstance().getReference().child("reservas").child("salas");
        miLista = new ArrayList<Pair<String, ArrayList<Pair<String, String>>>>();
        expandableListView = (ExpandableListView) findViewById(R.id.listaDias);
        llenarLista();
        miAdaptador = new fechaAdaptador(this, miLista);
        expandableListView.setAdapter(miAdaptador);
    }

    private void llenarLista (){
        ArrayList<Pair<String, String>> horasPrueba1 = new ArrayList< Pair< String, String > >();
        Pair<String, String> h1 = new Pair<String, String>("13:00","16:00");
        Pair<String, String> h2 = new Pair<String, String>("16:00","17:00");
        horasPrueba1.add(h1);
        horasPrueba1.add(h2);
        Pair<String, ArrayList<Pair<String, String>>> primerConjunto = new Pair<String, ArrayList<Pair<String, String>>>("Lunes, Abril 23", horasPrueba1);

        miLista.add(primerConjunto);

        ArrayList<Pair<String, String>> horasPrueba2 = new ArrayList<Pair<String, String>>();
        Pair<String, String> h3 = new Pair<String, String>("10:00","13:00");
        Pair<String, String> h4 = new Pair<String, String>("16:00","17:00");
        horasPrueba2.add(h3);
        horasPrueba2.add(h4);
        Pair<String, ArrayList<Pair<String, String>>> segundoConjunto = new Pair<String, ArrayList<Pair<String, String>>>("Martes, Abril 24", horasPrueba2);
        miLista.add(segundoConjunto);
    }

    private void configureDataBase(){

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar todayDate = Calendar.getInstance();
        Date todayDateD = todayDate.getTime();
        String todayString = dateFormat.format(todayDateD);

        todayDate.add(Calendar.DAY_OF_MONTH, 1);
        todayDate.set(Calendar.HOUR, 23);
        todayDate.set(Calendar.MINUTE, 59);
        todayDate.set(Calendar.SECOND, 59);
        Date tomorrowDate =todayDate.getTime();
        String tomorrowString = dateFormat.format(tomorrowDate);

        Query horariosReservas = mDatabase.orderByChild("fecha_fin").startAt(todayString).endAt(tomorrowString);

        horariosReservas.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String nuevaFechaFin = dataSnapshot.child("fecha_fin").getKey();
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

}
