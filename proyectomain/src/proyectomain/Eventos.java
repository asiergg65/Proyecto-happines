/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectomain;


import java.util.ArrayList;

public class Eventos {
    private int id;
    private String fecha;
    private String titulo;
    private String ubicacion;
    private String descripcion;
    private ArrayList<Galerias> coleccionGalerias; // ArrayList solicitado

    public Eventos(int id, String fecha, String titulo, String ubicacion, String descripcion) {
        this.id = id;
        this.fecha = fecha;
        this.titulo = titulo;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.coleccionGalerias = new ArrayList<>(); // Inicialmente vacía
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public ArrayList<Galerias> getColeccionGalerias() { return coleccionGalerias; }
    public void setColeccionGalerias(ArrayList<Galerias> galerias) { this.coleccionGalerias = galerias; }

    @Override
    public String toString() {
        return "[ID: " + id + "] " + titulo + " - " + fecha + " (" + ubicacion + ")";
    }

    Object getGalerias() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Object getGaleria() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}