package com.example.epis.practica_fragmentos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by jimmy on 26/03/2017.
 */
public class ParrafoFragmento extends Fragment {
    final static String ARG_POSITION = "position";
    int mCurrentPosition = -1;

    public void updateParrafoView(int position) {
        TextView parrafo = (TextView) getActivity().findViewById(R.id.txt_descripcion);
        parrafo.setText(Contenido.descripcion[position]);
        mCurrentPosition = position;
    }

    @Override
    public void onStart() {
        super.onStart();

        Bundle args = getArguments();

        if (args != null) {
            updateParrafoView(args.getInt(ARG_POSITION));
        } else if (mCurrentPosition != -1) {
            updateParrafoView((mCurrentPosition));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(ARG_POSITION, mCurrentPosition);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        if(savedInstanceState != null)
        {
            mCurrentPosition=savedInstanceState.getInt(ARG_POSITION);
        }
        return inflater.inflate(R.layout.fragment_descripcion,container,false);
    }
}
