package com.example.recyclerview.Estudiante;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

public class SecondFragment extends Fragment {

    AdaptadorEstudiantes AdaptadorPersonalizado;
    RecyclerView reciclerView;
    List<Estudiante> listaEstudiantes;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listaEstudiantes= new ArrayList<>();
        reciclerView=view.findViewById(R.id.recyclerView);
        AdaptadorPersonalizado=new AdaptadorEstudiantes(getContext(),listaEstudiantes);
        cargarDatos();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        reciclerView.setLayoutManager(layoutManager);
        reciclerView.setAdapter(AdaptadorPersonalizado);

        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    private void cargarDatos(){
        Estudiante est1= new Estudiante();
        est1.setCodigo("JC2020");
        est1.setNombre("Juan Manuel Carrillo Cruz");
        est1.setMateria("Programación");

        Estudiante est2= new Estudiante();
        est2.setCodigo("GD2018");
        est2.setNombre("Gabriela Clarissa Diz Muñoz");
        est2.setMateria("Diseño");

        Estudiante est3= new Estudiante();
        est3.setCodigo("SR2019");
        est3.setNombre("Sergio Daniel Romero");
        est3.setMateria("Proyectos");

        listaEstudiantes.add(est1);
        listaEstudiantes.add(est2);
        listaEstudiantes.add(est3);

    }
}
