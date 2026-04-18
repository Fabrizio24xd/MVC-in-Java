package example.models;

import java.util.ArrayList;
import java.util.List;

public class Evento {

    private String nombre;
    private String fecha;
    private String lugar;
    private List<Invitado> invitados;

    public Evento(String nombre, String fecha, String lugar) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.invitados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public List<Invitado> getInvitados() {
        return invitados;
    }

    public void agregarInvitado(Invitado invitado) {
        invitados.add(invitado);
    }

    @Override
    public String toString() {
        return nombre + " - " + fecha + " - " + lugar;
    }
}
