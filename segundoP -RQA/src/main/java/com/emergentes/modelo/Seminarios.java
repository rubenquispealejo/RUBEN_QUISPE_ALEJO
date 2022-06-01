
package com.emergentes.modelo;

public class Seminarios {
    private int id;
    private String titulo;
    private String fecha;
    private int cupo;

    public Seminarios() {
        this.id=0;
        this.titulo="";
        this.fecha="";
        this.cupo=0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    @Override
    public String toString() {
        return "Seminarios{" + "id=" + id + ", titulo=" + titulo + ", fecha=" + fecha + ", cupo=" + cupo + '}';
    }
    
    
    
}
