/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.VistaInicio;

/**
 *
 * @author Thinkpad P52
 */
public class ControladorInicio implements ActionListener {

    private final VistaInicio vista = new VistaInicio();

    public ControladorInicio() {

        vista.addInicioListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String op = e.getActionCommand();

        switch (op) {
            case "INICIO":
                iniciar();
                break;
            case "CREDITOS":
                creditos();
                break;
            case "SALIR":
                vista.dispose();
                break;

        }
    }

    public void inicio() {
        vista.dispose();
        vista.setVisible(true);
        ControladorSonido.iniciarMusicaFondo("musica_fondo.wav");
        ControladorSonido.cambiarVolumen(0.1f);
    }

    public void iniciar() {

        ControladorMenu control = new ControladorMenu();

        vista.dispose();

        control.inicioMenu();
    }

    public void creditos() {

        JOptionPane.showMessageDialog(null,
                "Libro Interactivo Educativo"
                + "\nDesarrollado por:"
                + "\nAlex Joshua Torres Vega C6N444"
                + "Ashley Araya Ortiz C5C589");

    }
}

