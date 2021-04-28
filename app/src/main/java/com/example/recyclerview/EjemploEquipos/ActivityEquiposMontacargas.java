package com.example.recyclerview.EjemploEquipos;

import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.recyclerview.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ActivityEquiposMontacargas extends AppCompatActivity implements RVEquiposAdapter.ItemClickCallback{

    private SearchView searchView;
    private MenuItem searchItem;
    RVEquiposAdapter AdaptadorPersonalizado;
    RecyclerView reciclerView;
    ArrayList<Equipo> listaMontacargas;
    TextView txtCantidad;
    Button btnVolver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipos_montacargas);
        listaMontacargas=new ArrayList();
        reciclerView = findViewById(R.id.ReciclerEquipos);
        btnVolver= findViewById(R.id.button_volver);
        txtCantidad= findViewById(R.id.txtCantidad);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        reciclerView.setLayoutManager(layoutManager);
        cargarDatos();
        AdaptadorPersonalizado =new RVEquiposAdapter(listaMontacargas,txtCantidad);
        AdaptadorPersonalizado.setContext(getApplicationContext());
        reciclerView.setAdapter(AdaptadorPersonalizado);
        AdaptadorPersonalizado.setItemClickCallback(ActivityEquiposMontacargas.this);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_equipos_main, menu);
        searchItem = menu.findItem(R.id.ItemEquiposBuscar);
        searchView= (SearchView) searchItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            searchView.setAutofillHints("Buscar equipo");
        }
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText){
                AdaptadorPersonalizado.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){

            case R.id.ItemEquiposBuscar:{

            }break;
            case android.R.id.home:{
                //this.finish();
                onBackPressed();
            }break;

            case R.id.ItemEquiposMayoraMenor:{
                Ordenamiento(new Comparator<Equipo>() {
                    @Override
                    public int compare(Equipo o1, Equipo o2) {
                        return new String(o1.getIdEquipo()).compareTo(new String(o2.getIdEquipo()));
                    }
                });
                AdaptadorPersonalizado.Actualizar();
            }break;

            case R.id.ItemEquiposMenoraMayor:{
                Ordenamiento(
                        new Comparator<Equipo>(){
                            @Override
                            public int compare(Equipo o1, Equipo o2){
                                return new String(o2.getIdEquipo()).compareTo(new String(o1.getIdEquipo()));
                            }
                        });
                AdaptadorPersonalizado.Actualizar();
            }break;

            case R.id.ItemEquiposMasInfo:{
                Boolean activarEdicionRepuesto=true;//Esta variable sera de acorde al estado del ticket. y habilitará los botones + -
                Bundle bundle=new Bundle();
                bundle.putString("titulo","TICKET DE PRUEBA");
                bundle.putString("nombreE","Equipo 9192929");
                bundle.putBoolean("activo",true);

//                Intent intentConf=new Intent(this,Configuraciones.class);
//                startActivity(intentConf);
            }break;
        }
        return super.onOptionsItemSelected(item);
    }


    public void Ordenamiento(Comparator comparator){
        Collections.sort(listaMontacargas,comparator);
    }

    @Override
    public void onItemClick(View v, int p) {
        switch (v.getId()){
            case R.id.cvEquiposPlantilla:{
                Toast.makeText(this,"Touch",Toast.LENGTH_SHORT).show();
            }break;
        }
    }

    private void cargarDatos(){

        //Agregamos solo datos que se muestran en el CardView.
        Equipo eq1=new Equipo();
        eq1.setNombreEquipo("Eq012021");
        eq1.setMarca("Caterpilar");
        eq1.setModelo("Hardaware300");
        eq1.setFotoURL("https://montacargasventayrenta.com/wp-content/uploads/2019/07/montacargas-electricos.jpg");

        Equipo eq2=new Equipo();
        eq2.setNombreEquipo("Eq022021");
        eq2.setMarca("Hino");
        eq2.setModelo("ForceWeigth1");
        eq2.setFotoURL("data:image/jpeg;base64,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");

        Equipo eq3=new Equipo();
        eq3.setNombreEquipo("Eq032021");
        eq3.setMarca("Caterpilar");
        eq3.setModelo("Rustic4");
        eq3.setFotoURL("data:image/jpeg;base64,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");

        Equipo eq4=new Equipo();
        eq4.setNombreEquipo("Eq042021");
        eq4.setMarca("Caterpilar");
        eq4.setModelo("Hardaware300");
        eq4.setFotoURL("https://montacargasventayrenta.com/wp-content/uploads/2019/07/montacargas-electricos.jpg");

        listaMontacargas.add(eq1);
        listaMontacargas.add(eq2);
        listaMontacargas.add(eq3);
        listaMontacargas.add(eq4);
    }
}
