package com.example.recyclerview.Estudiante;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;

import java.util.List;

public class AdaptadorEstudiantes  extends RecyclerView.Adapter<AdaptadorEstudiantes.ViewHolder>{

    private int idPlantilla;
    private List<Estudiante> DataSources;
    private Context cntx;
    private ViewHolder viewHolder;


    public AdaptadorEstudiantes(Context context, List<Estudiante> sources){
        this.DataSources=sources;
        this.cntx=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_estudiante, parent, false);
        viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.codigo.setText(DataSources.get(position).getCodigo());
        holder.nombre.setText(DataSources.get(position).getNombre());
        holder.curso.setText(DataSources.get(position).getMateria());
        holder.numero.setText( String.valueOf(position+1));
    }

    @Override
    public int getItemCount() {
        return DataSources.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView nombre, curso, codigo, numero;
        ImageView imgEstudiante;
        CardView cardView;

        public ViewHolder(View view){
            super(view);
            numero=view.findViewById(R.id.numEquipo);
            nombre=view.findViewById(R.id.nombre);
            curso=view.findViewById(R.id.curso);
            codigo=view.findViewById(R.id.codigo);
            cardView=view.findViewById(R.id.cvEstudentPlantilla);
            imgEstudiante=view.findViewById(R.id.imgPhoto);
            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v){
            switch (v.getId()){
                case R.id.cvEstudentPlantilla:{
                    Toast.makeText(cntx,"Hello Javatpoint",Toast.LENGTH_SHORT).show();
                }break;
            }
        }
    }

}
