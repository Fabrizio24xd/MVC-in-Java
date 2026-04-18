package example.views;

import example.controllers.EventoController;
import example.models.Evento;
import example.models.Invitado;

import javax.swing.*;

public class EventoView extends JFrame {

    private EventoController controller;

    private JTextField txtNombre, txtFecha, txtLugar;
    private DefaultListModel<String> modeloLista;
    private JList<String> listaEventos;

    public EventoView(EventoController controller) {
        this.controller = controller;

        setTitle("Gestión de Eventos");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new java.awt.FlowLayout());

        txtNombre = new JTextField(10);
        txtFecha = new JTextField(10);
        txtLugar = new JTextField(10);

        JButton btnAgregar = new JButton("Agregar Evento");
        JButton btnEliminar = new JButton("Eliminar Evento");
        JButton btnInvitado = new JButton("Agregar Invitado");

        modeloLista = new DefaultListModel<>();
        listaEventos = new JList<>(modeloLista);

        add(new JLabel("Nombre:"));
        add(txtNombre);
        add(new JLabel("Fecha:"));
        add(txtFecha);
        add(new JLabel("Lugar:"));
        add(txtLugar);

        add(btnAgregar);
        add(btnEliminar);
        add(btnInvitado);
        add(new JScrollPane(listaEventos));

        // AGREGAR EVENTO
        btnAgregar.addActionListener(e -> {
            Evento evento = new Evento(
                    txtNombre.getText(),
                    txtFecha.getText(),
                    txtLugar.getText()
            );
            controller.agregarEvento(evento);
            actualizarLista();
        });

        // ELIMINAR EVENTO
        btnEliminar.addActionListener(e -> {
            int index = listaEventos.getSelectedIndex();
            controller.eliminarEvento(index);
            actualizarLista();
        });

        // AGREGAR INVITADO
        btnInvitado.addActionListener(e -> {
            int index = listaEventos.getSelectedIndex();
            if (index == -1) {
                JOptionPane.showMessageDialog(null, "Selecciona un evento");
                return;
            }

            String nombre = JOptionPane.showInputDialog("Nombre del invitado");
            String email = JOptionPane.showInputDialog("Email del invitado");

            controller.agregarInvitado(index, new Invitado(nombre, email));
        });
    }

    private void actualizarLista() {
        modeloLista.clear();
        for (Evento e : controller.listarEventos()) {
            modeloLista.addElement(e.toString());
        }
    }
}
