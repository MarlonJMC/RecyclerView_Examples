package com.example.recyclerview.EjemploEquipos;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Equipo implements Serializable{

    private String idEquipo;
    private String Marca;
    private String Modelo;
    private String Serie;
    private String nombreEquipo;
    private String fechaAdquisicion;
    private String fotoURL;
    private String horometroActalizado;
    private int CantidadTickets;
    private String listaTickets;
    private boolean equipoActivo;
    private String existeTicketVigente;// string que podrá contener Preventivo o correctivo segun sea necesario.
    private String capacidad;


    public Equipo(String idEquipo, String marca, String modelo, String serie, String fechaAdquisicion) {
        this.idEquipo = idEquipo;
        Marca = marca;
        Modelo = modelo;
        Serie = serie;
        this.fechaAdquisicion = fechaAdquisicion;
        horometroActalizado="0";
        this.equipoActivo=false;
        this.fotoURL="";
        this.listaTickets="";
    }


    public String getExisteTicketVigente() {
        return existeTicketVigente;
    }

    public void setExisteTicketVigente(String existeTicketVigente) {
        this.existeTicketVigente = existeTicketVigente;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public int getCantidadTickets() {
        return CantidadTickets;
    }

    public void setCantidadTickets(int cantidadTickets) {
        CantidadTickets = cantidadTickets;
    }

    public String getHorometroActalizado() {
        return horometroActalizado;
    }

    public void setHorometroActalizado(String horometroActalizado) {
        this.horometroActalizado = horometroActalizado;
    }
    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }


    public boolean isEquipoActivo() {
        return equipoActivo;
    }

    public void setEquipoActivo(boolean equipoActivo) {
        this.equipoActivo = equipoActivo;
    }

    public Equipo(){
        this.idEquipo="";
        this.Marca="";
        this.Modelo="";
        this.Serie="";
        this.fechaAdquisicion=null;
        this.listaTickets="";
        this.CantidadTickets=0;
        this.nombreEquipo="";
        this.fotoURL="";
        this.equipoActivo=false;
    }

    public String getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(String idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public String getSerie() {
        return Serie;
    }

    public void setSerie(String serie) {
        Serie = serie;
    }

    public String getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(String fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public String getListaTickets() {
        return listaTickets;
    }

    public String getFotoURL(){
        return fotoURL;
    }

    public void setFotoURL(String fotoComprimida) {
        this.fotoURL = fotoComprimida;
    }

    @NonNull
    @Override
    public String toString() {
        return (this.Marca+this.Modelo);
    }

}
