package com.example.epis.practica_fragmentos;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by jimmy on 26/03/2017.
 */
public class TituloFragmento extends ListFragment {

    OnTituloSelectedListener mCallBack;

    public interface OnTituloSelectedListener
    {
        public void onTitulosSelected(int position);
    }

    @Override
    public void onCreate(Bundle saveInstanceState)
    {
        super.onCreate(saveInstanceState);

        setListAdapter(new ArrayAdapter<String>(getActivity(),R.layout.support_simple_spinner_dropdown_item,Contenido.titulo));
    }

    @Override
    public void onStart()
    {
        super.onStart();

        if(getFragmentManager().findFragmentById(R.id.fgm_descripcion) != null)
        {
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        }
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);

        try
        {
            Activity activity=(Activity) context;
            mCallBack = (OnTituloSelectedListener) activity;
        }
        catch (ClassCastException e)
        {
            throw new ClassCastException(getActivity().toString() + " debe implementar el método OnTitulosSelectedListener");
        }
    }

    @Override
    public void onListItemClick(ListView listView, View view, int position, long id)
    {
        mCallBack.onTitulosSelected(position);
        getListView().setItemChecked(position,true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstance)
    {
        return inflater.inflate(R.layout.fragment_titulo,container,false);
    }
}
