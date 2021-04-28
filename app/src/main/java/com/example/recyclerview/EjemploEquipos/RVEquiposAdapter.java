package com.example.recyclerview.EjemploEquipos;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

public class RVEquiposAdapter extends RecyclerView.Adapter<RVEquiposAdapter.ViewHolder> implements Filterable{

    private static ItemClickCallback itemClickCallback;

    ArrayList<Equipo> ListaEquipos;
    ArrayList<Equipo> SubListaEquipos;
    TextView txtCantidad;
    Context context;
    ViewHolder viewHolder;
    RequestOptions requestOptions;

    public RVEquiposAdapter(ArrayList<Equipo> equiposList, TextView cantidad){
        this.ListaEquipos=equiposList;
        SubListaEquipos=new ArrayList<>(equiposList);
        txtCantidad=cantidad;
        requestOptions= new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL).circleCrop();
    }

    @NonNull
    @Override
    public RVEquiposAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plantillas_equipos_recicles, parent, false);
        viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    public interface ItemClickCallback{
        void onItemClick(View v, int p);
    }

    public void setItemClickCallback(final ItemClickCallback itemClickCallback){
        RVEquiposAdapter.itemClickCallback = itemClickCallback;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
//        String nombreEquipo=Operaciones.TruncarCaracteresTresPuntosSuspensivos(ListaEquipos.get(position).getNombreEquipo(),25,true);

        String nombreEquipo=ListaEquipos.get(position).getNombreEquipo();
        holder.Marca.setText(this.ListaEquipos.get(position).getMarca());
        holder.Modelo.setText(this.ListaEquipos.get(position).getModelo());
        holder.IdEquipo.setText(nombreEquipo);
        if(!ListaEquipos.get(position).getFotoURL().equals("")){
            try{
                Glide.with(context).load(ListaEquipos.get(position).getFotoURL())
                .apply(requestOptions).into(holder.imgEquipo);
//                MyCRUDFirebase.DescargarPorURLCircular(context,holder.imgEquipo,ListaEquipos.get(position).getFotoURL());
            }catch (Exception e){
                holder.imgEquipo.setImageResource(R.drawable.montacargas_img_por_defecto);
            }
        }else {
            holder.imgEquipo.setImageResource(R.drawable.montacargas_img_por_defecto);
        }
        int num=position+1;
        String strnum=String.valueOf(num)+". ";
        holder.numEquipo.setText(strnum);
    }

    public void setContext(Context context){
        this.context=context;
    }

    @Override
    public int getItemCount() {
        return ListaEquipos.size();
    }

    @Override
    public Filter getFilter(){
        return filtroEquipos;
    }

    private Filter filtroEquipos=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<Equipo> lstFiltrada = new ArrayList<>();
            lstFiltrada.clear();
            if(charSequence == null || charSequence.length() == 0){
                lstFiltrada.addAll(SubListaEquipos);
            } else{
                String filterPattern = charSequence.toString().toLowerCase().trim();

                for(Equipo item : SubListaEquipos){
                    if(item.getMarca().toLowerCase().contains(filterPattern) || item.getModelo().toLowerCase().contains(filterPattern) || item.getNombreEquipo().toLowerCase().contains(filterPattern)){
                        lstFiltrada.add(item);
                    }
                }
            }
            FilterResults resultados = new FilterResults();
            resultados.values = lstFiltrada;
            return resultados;
        }

        @SuppressLint("SetTextI18n")
        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults){
            ListaEquipos.clear();
            ListaEquipos.addAll((ArrayList<Equipo>) filterResults.values);
            notifyDataSetChanged();
            txtCantidad.setText("Equipos encontrados: "+ String.valueOf(ListaEquipos.size()) );
        }

    };


    public void Actualizar(){
        this.notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView Marca,Modelo,Serie,IdEquipo,Fecha,numEquipo;
        ImageView imgEquipo;
        CardView cardView;

        public ViewHolder(View view){
            super(view);
            Marca=view.findViewById(R.id.Marca_detalles);
            Modelo=view.findViewById(R.id.Marca_Modelo);
            IdEquipo=view.findViewById(R.id.IdEquipo);
            imgEquipo=view.findViewById(R.id.EquipoRVImagen);
            numEquipo=view.findViewById(R.id.numEquipo);
            cardView=view.findViewById(R.id.cvEquiposPlantilla);
            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v){
            switch (v.getId()){
                case R.id.cvEquiposPlantilla:{
                    itemClickCallback.onItemClick(v, getAdapterPosition());
                }break;
            }
        }
    }

    @Override
    public void onViewAttachedToWindow(@NonNull ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        animatedCircularReveal(holder.itemView);
    }

    public void animatedCircularReveal(View v) {
        int centerX = 100;
        int centerY = 100;
        float startRadius = 300;
        float endRedius = Math.max(v.getWidth(), v.getHeight());
        Animator ani = ViewAnimationUtils.createCircularReveal(v, centerX, centerY, startRadius, endRedius);
        v.setVisibility(v.VISIBLE);
        ani.start();
    }

}
