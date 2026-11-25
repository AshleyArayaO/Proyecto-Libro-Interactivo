/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Libro;
import modelo.Pagina;
import modelo.PaginaInformativa;
import vista.VistaPaginaRutaUno;

/**
 *
 * @author Thinkpad P52
 */
public class ControladorPaginaRutaUno implements ActionListener {

    private final VistaPaginaRutaUno vistaPagina;
    private final JFrame vistaAnterior;
    private final Libro libro;

    private int posicion;

    public ControladorPaginaRutaUno(
            VistaPaginaRutaUno vistaPagina,
            JFrame vistaAnterior,
            Libro libro, int posicionInicial) {

        this.vistaPagina = vistaPagina;
        this.vistaAnterior = vistaAnterior;
        this.libro = libro;

        this.posicion = posicionInicial;

        vistaPagina.addPaginaListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String op = e.getActionCommand();

        switch (op) {

            case "MENU":
                volverMenu();
                break;

            case "SIGUIENTE":
                siguientePagina();
                break;

            case "ANTERIOR":
                anteriorPagina();
                break;
        }
    }

    public void inicioPagina() {

        mostrarPaginaActual();

        vistaPagina.setLocationRelativeTo(null);
        vistaPagina.setVisible(true);
    }

    private void mostrarPaginaActual() {

        try {
            Pagina pagina = libro.consultarPaginaRutaUno(posicion);

            if (!(pagina instanceof PaginaInformativa)) {
                throw new IllegalArgumentException(
                        "Esta página no es informativa."
                );
            }

            vistaPagina.mostrarPagina(
                    pagina.getTitulo(),
                    pagina.getContenido()
            );

            vistaPagina.habilitarAnterior(posicion > 0);

            vistaPagina.habilitarSiguiente(true);

        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(vistaPagina, "La página solicitada no existe."
            );
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(
                    vistaPagina,
                    e.getMessage()
            );
        }
    }

    private void siguientePagina() {

        int siguiente = posicion + 1;

        if (siguiente < libro.obtenerCantidadPaginasRutaUno()) {

            Pagina pagina = libro.consultarPaginaRutaUno(siguiente);

            if (pagina instanceof PaginaInformativa) {

                posicion = siguiente;
                mostrarPaginaActual();

            }

        } else {

            JOptionPane.showMessageDialog(
                    vistaPagina,
                    "No hay más páginas informativas disponibles, regresa al menu principal para ir a la actividad"
            );
        }
    }

    public void anteriorPagina() {

        if (posicion > 0) {
            posicion--;
            mostrarPaginaActual();
        }
    }

private void volverMenu() {

    vistaPagina.dispose();

    vistaAnterior.setLocationRelativeTo(null);
    vistaAnterior.setVisible(true);
}

}
