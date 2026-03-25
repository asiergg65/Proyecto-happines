package proyectomain;

public class Usuario {
    
    private String nombre;
    private String email;
    private final String password;

    
    public Usuario(String nombre, String email, String password) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }

 
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }

    
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Usuario: " + nombre + " | Email: " + email;
    }
}  