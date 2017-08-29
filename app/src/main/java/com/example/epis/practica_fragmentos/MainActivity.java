package com.example.epis.practica_fragmentos;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
    implements TituloFragmento.OnTituloSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asegurar que exista el contenedor
        if(findViewById(R.id.fragment_container) != null) {
            //Prevenir colision de Fragments
            if (savedInstanceState != null) {
                return;
            }
            //Creando el nuevo fragmento
            TituloFragmento tituloFragment=new TituloFragmento();

            //Agregar extras si existen
            tituloFragment.setArguments(getIntent().getExtras());

            //Lanzar la vista del fragmento
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,tituloFragment).commit();
        }
    }

    @Override
    public void onTitulosSelected(int position) {
        ParrafoFragmento parrafoFragmento=(ParrafoFragmento) getSupportFragmentManager().findFragmentById(R.id.fgm_descripcion);

        if(parrafoFragmento != null)
        {
            parrafoFragmento.updateParrafoView(position);
        }
        else
        {
            ParrafoFragmento fragmentoNuevo=new ParrafoFragmento();
            Bundle args=new Bundle();
            args.putInt(ParrafoFragmento.ARG_POSITION,position);
            fragmentoNuevo.setArguments(args);

            FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();

            fragmentTransaction.replace(R.id.fragment_container,fragmentoNuevo);

            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }
}
