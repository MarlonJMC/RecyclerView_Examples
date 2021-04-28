package com.example.recyclerview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    List<Product> listaProductos;
    RecyclerView reciclerView;
    ProductAdapter productAdapter;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_volver).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

        listaProductos= new ArrayList<>();
        reciclerView=view.findViewById(R.id.recyclerView);
        cargarDatos();
        productAdapter=new ProductAdapter(listaProductos);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        reciclerView.setLayoutManager(layoutManager);
        reciclerView.setAdapter(productAdapter);
    }

    private void cargarDatos() {
        Product product1= new Product();
        product1.setId("Iph21");
        product1.setName("Iphone 12");
        product1.setQuantity(23);
        product1.setPhotoUrl("https://i.blogs.es/adf267/image-2020-10-13-20-20-17/450_1000.jpg");

        Product product2= new Product();
        product2.setId("ply21");
        product2.setName("Playstatio 5");
        product2.setQuantity(36);
        product2.setPhotoUrl("https://images-na.ssl-images-amazon.com/images/I/619BkvKW35L._SX342_.jpg");

        Product product3= new Product();
        product3.setId("PCG21");
        product3.setName("PC Gamer Red");
        product3.setQuantity(5);
        product3.setPhotoUrl("https://i.pinimg.com/736x/c1/96/24/c19624a7a76ec36dc4385070dbeafb05.jpg");

        listaProductos.add(product1);
        listaProductos.add(product2);
        listaProductos.add(product3);
        listaProductos.add(product1);
    }
}
