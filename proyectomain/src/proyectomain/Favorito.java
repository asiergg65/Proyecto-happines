/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectomain;

/**
 *
 * @author ALUMNOS-FP
 */
public class Favorito {
    private final String emailUsuario;
    private final int idEvento;

    public Favorito(String emailUsuario, int idEvento) {
        this.emailUsuario = emailUsuario;
        this.idEvento = idEvento;
    }

    @Override
    public String toString() {
        return emailUsuario + " -> Evento " + idEvento;
    }
}
