package com.example.recyclerview.Estudiante;

public class Estudiante {

    private String nombre;
    private String codigo;
    private String materia;
    private String parcial1;
    private String parcial2;
    private String parcial3;
    private String promedio;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getParcial1() {
        return parcial1;
    }

    public void setParcial1(String parcial1) {
        this.parcial1 = parcial1;
    }

    public String getParcial2() {
        return parcial2;
    }

    public void setParcial2(String parcial2) {
        this.parcial2 = parcial2;
    }

    public String getParcial3() {
        return parcial3;
    }

    public void setParcial3(String parcial3) {
        this.parcial3 = parcial3;
    }

    public String getPromedio() {
        return promedio;
    }

    public void setPromedio(String promedio) {
        this.promedio = promedio;
    }

    public Double getPromedioD(){
        Double d=0.0;
        try {
            d=Double.parseDouble(promedio);
        }catch (NumberFormatException e){
            d=0.0;
        }
        return d;
    }

    public Double getCalculoPromedio(){
        Double re=0d;
        re=(getParcial1d()*0.3)+(getParcial2d()*0.3)+(getParcial3d()*0.4);
        this.promedio=re.toString();
        return re;
    }

    public Double getParcial1d(){
        Double d=0.0;
        try {
            d=Double.parseDouble(parcial1);
        }catch (NumberFormatException e){
            d=0.0;
        }
        return d;
    }

    public Double getParcial2d(){
        Double d=0.0;
        try {
            d=Double.parseDouble(parcial2);
        }catch (NumberFormatException e){
            d=0.0;
        }
        return d;
    }

    public Double getParcial3d(){
        Double d=0.0;
        try {
            d=Double.parseDouble(parcial3);
        }catch (NumberFormatException e){
            d=0.0;
        }
        return d;
    }
}
