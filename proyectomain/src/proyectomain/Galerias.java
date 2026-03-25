/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectomain;

public class Galerias {
    private int id;
    private String titulo;
    private int idEvento;

    public Galerias(int id, String titulo, int idEvento) {
        this.id = id;
        this.titulo = titulo;
        this.idEvento = idEvento;
    }
     
    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public int getIdEvento() { return idEvento; }
    public void setIdEvento(int idEvento) { this.idEvento = idEvento; }

    @Override
    public String toString() {
        return "[ID: " + id + "] Título: " + titulo + " (Evento ID: " + idEvento + ")";
    }
}
 