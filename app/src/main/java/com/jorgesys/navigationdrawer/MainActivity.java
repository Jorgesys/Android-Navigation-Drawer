package com.jorgesys.navigationdrawer;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ExpandableListView expListView;
    private ActionBarDrawerToggle mDrawerToggle;
    ExpandableListAdapter listAdapterExpandable;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // obtiene el DrawerLayout.
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        // obtiene el listview.
        expListView = (ExpandableListView) findViewById(R.id.expandable_list);
        // prepara datos para Header y Listado en ExpandableListView.
        prepareListData();
        // configura Adapter.
        listAdapterExpandable = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        // configura Adapter en ExpandableListView.
        expListView.setAdapter(listAdapterExpandable);
        // Puedes expandir los grupos por default.
        int count = listAdapterExpandable.getGroupCount();
        for ( int i = 0; i < count; i++ )
            expListView.expandGroup(i);


    }



    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // add headers.
        listDataHeader.add("Programming Languages");
        listDataHeader.add("Types");
        listDataHeader.add("Countries");

        // add data.
        List<String> lenguajes = new ArrayList<String>();
        lenguajes.add("C++");
        lenguajes.add("Java");
        lenguajes.add("Ruby");
        lenguajes.add("Python");
        lenguajes.add("Swift");
        lenguajes.add("Objective C");
        lenguajes.add("C#");

        // add data.
        List<String> tipos = new ArrayList<String>();
        tipos.add("Desarrollo Mobil");
        tipos.add("Escritorio");
        tipos.add("Web");
        tipos.add("Juegos");
        tipos.add("Bases de Datos");
        tipos.add("Analisis de Datos");

        // add data.
        List<String> paises = new ArrayList<String>();
        paises.add("Rumania");
        paises.add("Ucrania");
        paises.add("México");
        paises.add("Grecia");
        paises.add("Holanda");
        paises.add("El Salvador");
        paises.add("Guatemala");
        paises.add("Canada");
        paises.add("Francia");

        listDataChild.put(listDataHeader.get(0), lenguajes);
        listDataChild.put(listDataHeader.get(1), tipos);
        listDataChild.put(listDataHeader.get(2), paises);
    }

}
