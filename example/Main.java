package example;

import example.controllers.EventoController;
import example.views.EventoView;

public class Main {
    public static void main(String[] args) {
        EventoController controller = new EventoController();
        EventoView view = new EventoView(controller);
        view.setVisible(true);
    }
}
