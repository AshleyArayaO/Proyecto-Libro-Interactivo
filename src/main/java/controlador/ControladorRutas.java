/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Libro;
import vista.VistaMenu;
import vista.VistaPaginaRutaDos;
import vista.VistaPaginaRutaUno;
import vista.VistaRutas;

/**
 *
 * @author Thinkpad P52
 */
public class ControladorRutas implements ActionListener {

    private final VistaRutas vista;
    private final Libro libro;
    private final VistaMenu vistaMenu;

    public ControladorRutas(Libro libro, VistaMenu vistaMenu) {

        this.libro = libro;
        this.vistaMenu = vistaMenu;

        vista = new VistaRutas();
        vista.addEleccionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String op = e.getActionCommand();

        switch (op) {
            case "RUTAUNO":
                abrirRutaUno();
                break;

            case "RUTADOS":
                abrirRutaDos();
                break;

            case "MENU":
                volverMenu();
                break;

            case "SALIR":
                vista.dispose();
                break;
        }
    }

    public void iniciarRutas() {
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    private void volverMenu() {

        vista.dispose();
        vistaMenu.setLocationRelativeTo(null);
        vistaMenu.setVisible(true);
    }

    private void abrirRutaUno() {

        VistaPaginaRutaUno pagina = new VistaPaginaRutaUno();

        ControladorPaginaRutaUno control = new ControladorPaginaRutaUno(pagina, vista, libro, 0);

        vista.setVisible(false);

        control.inicioPagina();
    }

    private void abrirRutaDos() {

        VistaPaginaRutaDos pagina = new VistaPaginaRutaDos();

        ControladorPaginaRutaDos control = new ControladorPaginaRutaDos(pagina, vista, libro, 0);

        vista.setVisible(false);

        control.inicioPagina();
    }
}

