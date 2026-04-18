package example.controllers;

import example.models.Evento;
import example.models.Invitado;

import java.util.ArrayList;
import java.util.List;

public class EventoController {

    private List<Evento> eventos = new ArrayList<>();

    // Agregar evento
    public void agregarEvento(Evento evento) {
        eventos.add(evento);
    }

    // Listar eventos
    public List<Evento> listarEventos() {
        return eventos;
    }

    // Eliminar evento
    public void eliminarEvento(int index) {
        if (index >= 0 && index < eventos.size()) {
            eventos.remove(index);
        }
    }

    // Agregar invitado a un evento
    public void agregarInvitado(int index, Invitado invitado) {
        if (index >= 0 && index < eventos.size()) {
            eventos.get(index).agregarInvitado(invitado);
        }
    }
}
