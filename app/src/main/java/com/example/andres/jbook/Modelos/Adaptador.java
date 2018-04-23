package com.example.andres.jbook.Modelos;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.andres.jbook.Modelos.Sala;
import com.example.andres.jbook.R;

import java.util.List;

/**
 * Created by andres on 20/04/18.
 */

public class Adaptador extends BaseAdapter {

    Context contexto;
    List<Sala> misSalas;

    public Adaptador(Context contexto, List<Sala> misSalas) {
        this.contexto = contexto;
        this.misSalas = misSalas;
    }

    @Override
    public int getCount() {
        return misSalas.size();
    }

    @Override
    public Object getItem(int i) {
        return misSalas.get(i);
    }

    @Override
    public long getItemId(int i) {
        //return misSalas.get(i).getId();
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // View nuevaVista = view;
        LayoutInflater inflate = LayoutInflater.from(this.contexto);
        View nuevaVista = inflate.inflate(R.layout.itemsalaview,null);
        TextView miEstado = (TextView) nuevaVista.findViewById(R.id.estado);
        TextView miNombre = (TextView) nuevaVista.findViewById(R.id.nombre);
        TextView miUbicacion = (TextView) nuevaVista.findViewById(R.id.ubicacion);

        Sala salaActual = misSalas.get(i);
        String estado = salaActual.getEstado();
        miNombre.setText(salaActual.getNombre().toString());
        miUbicacion.setText(salaActual.getUbicacion().toString());
        if (estado.equals("libre")){
            miEstado.setBackgroundColor(Color.parseColor("#00ff00"));
        }else{
            miEstado.setBackgroundColor(Color.parseColor("#ff3300"));
        }

        return nuevaVista;
    }
}
