package com.example.andres.jbook.Modelos;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.andres.jbook.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by andres on 22/04/18.
 */

public class fechaAdaptador extends BaseExpandableListAdapter {

    private ArrayList<Pair<String, ArrayList<Pair<String, String>>>> grupos;
    //private ArrayList<Pair<String, String>> hijos;
    private Context context;

    public fechaAdaptador(Context context, ArrayList<Pair<String, ArrayList<Pair<String, String>>>> grupos) {
        this.grupos = grupos;
        //this.hijos = hijos;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return grupos.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return grupos.get(i).second.size();
    }

    @Override
    public Object getGroup(int i) {
        return grupos.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return grupos.get(i).second.get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View nuevaVista = inflater.inflate(R.layout.diaviewreservalayout, null);
        TextView titulo = (TextView) nuevaVista.findViewById(R.id.diaReserva);
        titulo.setText(grupos.get(i).first);
        return nuevaVista;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View nuevaVista = inflater.inflate(R.layout.horaviewreservalayout, null);
        TextView primeraHora = (TextView) nuevaVista.findViewById(R.id.hora1);
        TextView segundaHora = (TextView) nuevaVista.findViewById(R.id.hora2);
        primeraHora.setText(grupos.get(i).second.get(i1).first);
        segundaHora.setText(grupos.get(i).second.get(i1).second);
        return nuevaVista;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
