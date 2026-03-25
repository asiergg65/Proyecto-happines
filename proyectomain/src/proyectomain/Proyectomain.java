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
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
public class Proyectomain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
  
   
   



    static HashMap<String, Usuario> usuarios = new HashMap<>();
    static HashMap<Integer, Evento> eventos = new HashMap<>();
    static ArrayList<Favorito> favoritos = new ArrayList<>();

    static int contadorEvento = 0;
    static int contadorGaleria = 0;

  

        Scanner teclado = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Añadir usuario");
            System.out.println("2. Eliminar usuario");
            System.out.println("3. Añadir evento");
            System.out.println("4. Eliminar evento");
            System.out.println("5. Añadir galería");
            System.out.println("6. Eliminar galería");
            System.out.println("7. Añadir favorito");
            System.out.println("8. Eliminar favorito");
            System.out.println("9. Salir");

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("Nombre: ");
                    String nombre = teclado.nextLine();
                    System.out.print("Email: ");
                    String email = teclado.nextLine();
                    System.out.print("Password: ");
                    String pass = teclado.nextLine();

                    if (usuarios.containsKey(email)) {
                        System.out.println("El usuario ya existe");
                    } else {
                        usuarios.put(email, new Usuario(nombre, email, pass));
                        System.out.println("Usuario creado correctamente");
                    }
                    break;

                case 2:
                    System.out.print("Email: ");
                    email = teclado.nextLine();

                    if (usuarios.remove(email) == null) {
                        System.out.println("El usuario no existe");
                    } else {
                        System.out.println("Usuario eliminado correctamente");
                    }
                    break;

                case 3:
                    System.out.print("Fecha: ");
                    String fecha = teclado.nextLine();
                    System.out.print("Titulo: ");
                    String titulo = teclado.nextLine();
                    System.out.print("Ubicacion: ");
                    String ubicacion = teclado.nextLine();
                    System.out.print("Descripcion: ");
                    String desc = teclado.nextLine();

                    evento ev = new evento(contadorEvento++, fecha, titulo, ubicacion, desc);
                    eventos.put(ev.getId(), ev);
                    System.out.println("Evento creado correctamente");
                    break;

                case 4:
                    eventos.values().forEach(System.out::println);
                    System.out.print("ID a eliminar: ");
                    int id = teclado.nextInt();

                    if (eventos.remove(id) == null) {
                        System.out.println("El evento no existe");
                    } else {
                        System.out.println("Evento eliminado correctamente");
                    }
                    break;

                case 5:
                    eventos.values().forEach(System.out::println);
                    System.out.print("ID evento: ");
                    id = teclado.nextInt(); teclado.nextLine();

                    Evento evento = eventos.get(id);

                    if (evento == null) {
                        System.out.println("Error");
                        break;
                    }

                    System.out.print("Titulo galeria: ");
                    String tit = teclado.nextLine();

                    Galeria g = new Galeria(contadorGaleria++, tit, id);
                    evento.getGalerias().add(g);

                    System.out.println("Galería creada correctamente");
                    break;

                case 6:
                    eventos.values().forEach(System.out::println);
                    System.out.print("ID evento: ");
                    id = teclado.nextInt();

                    evento = eventos.get(id);

                    if (evento == null) {
                        System.out.println("Error");
                        break;
                    }

                    evento.getGalerias().forEach(System.out::println);
                    System.out.print("ID galeria: ");
                    int gid = teclado.nextInt();

                    boolean eliminado = evento.getGalerias().removeIf(x -> x.getId() == gid);

                    if (!eliminado) {
                        System.out.println("La galería no existe");
                    } else {
                        System.out.println("Galería eliminada correctamente");
                    }
                    break;

                case 7:
                    eventos.values().forEach(System.out::println);
                    usuarios.values().forEach(System.out::println);

                    System.out.print("ID evento: ");
                    id = teclado.nextInt(); teclado.nextLine();
                    System.out.print("Email usuario: ");
                    email = teclado.nextLine();

                    if (!eventos.containsKey(id) || !usuarios.containsKey(email)) {
                        System.out.println("Error");
                        break;
                    }

                    favoritos.add(new Favorito(email, id));
                    System.out.println("Favorito creado correctamente");
                    break;

                case 8:
                    favoritos.forEach(System.out::println);

                    System.out.print("ID evento: ");
                    id = teclado.nextInt(); teclado.nextLine();
                    System.out.print("Email usuario: ");
                    email = teclado.nextLine();

                    boolean borrado = favoritos.removeIf(f -> f.toString().equals(email + " -> Evento " + id));

                    if (!borrado) {
                        System.out.println("El favorito no existe");
                    } else {
                        System.out.println("Favorito eliminado correctamente");
                    }
                    break;

            
        } while (opcion != 9);

    }

}

