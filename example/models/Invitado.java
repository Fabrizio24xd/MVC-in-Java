package example.models;

public class Invitado {

    private String nombre;
    private String email;

    public Invitado(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return nombre + " - " + email;
    }
}
