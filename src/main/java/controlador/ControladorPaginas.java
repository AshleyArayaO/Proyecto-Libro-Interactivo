/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Libro;
import modelo.Pagina;
import modelo.PaginaInformativa;
import vista.VistaMenu;
import vista.VistaPaginaRutaDos;
import vista.VistaPaginaRutaUno;
import vista.VistaPaginas;

/**
 *
 * @author Thinkpad P52
 */
public class ControladorPaginas implements ActionListener {

    private VistaPaginas vista;
    private VistaMenu vistaMenu;
    private Libro libro;

    private final ArrayList<Pagina> listaRutaUno = new ArrayList<>();
    private final ArrayList<Pagina> listaRutaDos = new ArrayList<>();

    public ControladorPaginas(VistaPaginas vista, VistaMenu vistaMenu, Libro libro, int[][] historial, int[] notas, int[] numeroIntentos) {

        this.vista = vista;
        this.vistaMenu = vistaMenu;
        this.libro = libro;

        vista.addPaginasRutaUnoListener(this);
        vista.addAgregarRutaUnoListener(this);

        vista.addPaginasRutaDosListener(this);
        vista.addAgregarRutaDosListener(this);

        actualizarListaRutaUno();
        actualizarListaRutaDos();

        cargarTitulosRutaUno();
        cargarTitulosRutaDos();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String op = e.getActionCommand();

        if (op.startsWith("PAGINA_RUTA_UNO_")) {
            int posicion = Integer.parseInt(
                    op.substring("PAGINA_RUTA_UNO_".length())
            );

            abrirPaginaRutaUno(posicion);
            return;
        }
        if (op.startsWith("PAGINA_RUTA_DOS_")) {

            int posicion = Integer.parseInt(
                    op.substring("PAGINA_RUTA_DOS_".length())
            );

            abrirPaginaRutaDos(posicion);
            return;
        }
        switch (op) {
            case "MENU":
                volverMenu();
                break;

            case "AGREGAR_RUTAUNO":
                agregarNuevaPaginaRutaUno();
                break;

            case "BUSCAR_RUTAUNO":
                solicitarBusquedaRutaUno();
                break;
            case "AGREGAR_RUTADOS":
                agregarNuevaPaginaRutaDos();
                break;

            case "BUSCAR_RUTADOS":
                solicitarBusquedaRutaDos();
                break;
        }
    }

    public void inicioPaginas() {

        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

    }

    public void volverMenu() {

        vista.dispose();
        vistaMenu.setLocationRelativeTo(null);
        vistaMenu.setVisible(true);

    }

    private void actualizarListaRutaUno() {

        listaRutaUno.clear();

        for (int i = 0; i < libro.obtenerCantidadPaginasRutaUno(); i++) {

            listaRutaUno.add(libro.consultarPaginaRutaUno(i));
        }
    }

    private void cargarTitulosRutaUno() {

        ArrayList<String> titulos = new ArrayList<>();

        for (Pagina pagina : listaRutaUno) {

            if (pagina instanceof PaginaInformativa) {

                titulos.add(pagina.getNumeroPagina() + ". " + pagina.getTitulo());
            }
        }

        vista.mostrarTitulosRutaUno(
                titulos.toArray(new String[0]),
                this
        );
    }

    private void agregarNuevaPaginaRutaUno() {

        String titulo = JOptionPane.showInputDialog(vista, "Ingrese el título de la página de la Ruta Uno:");

        if (titulo == null || titulo.trim().isEmpty()) {
            return;
        }

        String contenido = JOptionPane.showInputDialog(vista, "Ingrese el contenido de la página:");

        if (contenido == null || contenido.trim().isEmpty()) {
            return;
        }

        int numero = libro.obtenerCantidadPaginasInformativasRutaUno() + 1;

        PaginaInformativa nuevaPagina = new PaginaInformativa(titulo.trim(), numero, contenido.trim());

        libro.agregarPaginaRutaUno(nuevaPagina);

        actualizarListaRutaUno();
        cargarTitulosRutaUno();

        JOptionPane.showMessageDialog(vista, "Página agregada correctamente a la Ruta Uno."
        );
    }

    private Pagina buscarPaginaRutaUno(int numero) {

        for (Pagina pagina : listaRutaUno) {

            if (pagina.getNumeroPagina() == numero) {
                return pagina;
            }
        }

        return null;
    }

    private void solicitarBusquedaRutaUno() {

        String texto = JOptionPane.showInputDialog(vista, "Ingrese el número de página que desea buscar en la Ruta Uno:");

        if (texto == null) {
            return;
        }

        try {

            int numero = Integer.parseInt(texto);

            Pagina pagina = buscarPaginaRutaUno(numero);

            if (pagina == null) {

                JOptionPane.showMessageDialog(vista, "No se encontró esa página en la Ruta Uno.");

                return;
            }

            int posicion = listaRutaUno.indexOf(pagina);

            abrirPaginaRutaUno(posicion);

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(vista, "Debe ingresar un número válido.");
        }
    }

    private void abrirPaginaRutaUno(int posicion) {

        if (posicion < 0 || posicion >= listaRutaUno.size()) {
            return;
        }

        VistaPaginaRutaUno pagina = new VistaPaginaRutaUno();

        ControladorPaginaRutaUno control = new ControladorPaginaRutaUno(pagina, vista, libro, posicion);

        vista.setVisible(false);

        control.inicioPagina();
    }

    private void actualizarListaRutaDos() {

        listaRutaDos.clear();

        for (int i = 0; i < libro.obtenerCantidadPaginasRutaDos(); i++) {

            listaRutaDos.add(libro.consultarPaginaRutaDos(i));
        }
    }

    private void cargarTitulosRutaDos() {

        ArrayList<String> titulos = new ArrayList<>();

        for (Pagina pagina : listaRutaDos) {

            if (pagina instanceof PaginaInformativa) {

                titulos.add(pagina.getNumeroPagina() + ". " + pagina.getTitulo());
            }
        }

        vista.mostrarTitulosRutaDos(titulos.toArray(new String[0]),
                this
        );
    }

    private void agregarNuevaPaginaRutaDos() {

        String titulo = JOptionPane.showInputDialog(vista, "Ingrese el título de la página de la Ruta Dos:"
        );

        if (titulo == null || titulo.trim().isEmpty()) {
            return;
        }

        String contenido = JOptionPane.showInputDialog(vista, "Ingrese el contenido de la página:");

        if (contenido == null || contenido.trim().isEmpty()) {
            return;
        }

        int numero = libro.obtenerCantidadPaginasInformativasRutaDos() + 1;

        PaginaInformativa nuevaPagina = new PaginaInformativa(titulo.trim(), numero, contenido.trim());

        libro.agregarPaginaRutaDos(nuevaPagina);

        actualizarListaRutaDos();
        cargarTitulosRutaDos();

        JOptionPane.showMessageDialog(vista, "Página agregada correctamente a la Ruta Dos.");
    }

    private Pagina buscarPaginaRutaDos(int numero) {

        for (Pagina pagina : listaRutaDos) {

            if (pagina.getNumeroPagina() == numero) {
                return pagina;
            }
        }

        return null;
    }

    private void solicitarBusquedaRutaDos() {

        String texto = JOptionPane.showInputDialog(vista, "Ingrese el número de página que desea buscar en la Ruta Dos:");

        if (texto == null) {
            return;
        }

        try {

            int numero = Integer.parseInt(texto);

            Pagina pagina = buscarPaginaRutaDos(numero);

            if (pagina == null) {

                JOptionPane.showMessageDialog(vista, "No se encontró esa página en la Ruta Dos."
                );

                return;
            }

            int posicion = listaRutaDos.indexOf(pagina);

            abrirPaginaRutaDos(posicion);

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(vista, "Debe ingresar un número válido.");
        }
    }

    private void abrirPaginaRutaDos(int posicion) {

        if (posicion < 0 || posicion >= listaRutaDos.size()) {
            return;
        }

        VistaPaginaRutaDos pagina = new VistaPaginaRutaDos();

        ControladorPaginaRutaDos control = new ControladorPaginaRutaDos(pagina, vista, libro, posicion);

        vista.setVisible(false);

        control.inicioPagina();
    }
}

