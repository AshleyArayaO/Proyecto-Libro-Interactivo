/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Libro;
import modelo.PaginaActividad;
import vista.VistaActividad;
import vista.VistaMenu;

/**
 *
 * @author Thinkpad P52
 */
   public class ControladorActividad implements ActionListener {

    private VistaActividad vista;
    private VistaMenu vistaMenu;
    private Libro libro;
    private PaginaActividad actividad;

    private int[] respuestasCorrectas = {1, 3, 2};
    private int[] respuestasUsuario = new int[3];

    private int[][] historial;
    private int[] notas;
    private int[] numeroIntentos;

    private final int intentosMAXIMOS = 3;

    public ControladorActividad(VistaActividad vista, VistaMenu vistaMenu, Libro libro, int[][] historial,
            int[] notas, int[] numeroIntentos) {

        this.vista = vista;
        this.vistaMenu = vistaMenu;
        this.libro = libro;
        this.historial = historial;
        this.notas = notas;
        this.numeroIntentos = numeroIntentos;

        actividad = libro.obtenerActividad();

        if (actividad == null) {
            JOptionPane.showMessageDialog(vista, "Actividad no encontrada.");
            return;
        }

        vista.mostrarPreguntas(
                actividad.getTitulo(),
                actividad.getContenido(),
                actividad.getPreguntas(),
                actividad.getOpciones()
        );
        vista.addActividadListener(this);
    }

    public void mostrarActividad() {
        if (actividad == null) {
            return;
        }
        vista.mostrarPreguntas(actividad.getTitulo(), actividad.getContenido(), actividad.getPreguntas(), actividad.getOpciones()
        );
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String op = e.getActionCommand();

        System.out.println("Botón presionado: " + op);
        switch (op) {

            case "CALIFICAR":
                calificarActividad();
                break;

            case "MENU":
                volverMenu();
                break;
            case "SALIR":
                vista.dispose();
                break;
            default:
                System.out.println("Comando no reconocido: " + op);
                break;
        }
    }

    public void calificarActividad() {

        if (numeroIntentos[0] >= intentosMAXIMOS) {
            JOptionPane.showMessageDialog(vista, "Ya has realizado los 3 intentos disponibles.");
            return;
        }
        try {
            respuestasUsuario = vista.obtenerRespuestas();

            for (int i = 0; i < respuestasCorrectas.length; i++) {

                if (respuestasUsuario[i] == 0) {

                    JOptionPane.showMessageDialog(null, "Debes responder todas las preguntas.");
                    return;
                }

                if (respuestasUsuario[i] < 1 || respuestasUsuario[i] > 3) {
                    throw new IllegalArgumentException("Se encontró una respuesta inválida.");

                }
            }

            int intentoActual = numeroIntentos[0];

            int nota = 0;

            for (int i = 0; i < respuestasCorrectas.length; i++) {
                historial[intentoActual][i] = respuestasUsuario[i];

                if (respuestasUsuario[i] == respuestasCorrectas[i]) {
                    nota++;
                }
            }

            notas[intentoActual] = nota;

            numeroIntentos[0]++;

            JOptionPane.showMessageDialog(vista,
                    "Intento: " + numeroIntentos[0]
                    + "\nRespuestas correctas: " + nota + " de 3"
                    + "\nNota: " + (nota * 100 / 3) + "%"
                    + "\nIntentos restantes: " + (intentosMAXIMOS - numeroIntentos[0])
            );
            if (numeroIntentos[0] == intentosMAXIMOS) {
                JOptionPane.showMessageDialog(vista, "Has completado los 3 intentos disponibles.");
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(vista, e.getMessage());
        }
    }

    public void volverMenu() {

        vista.dispose();
        vistaMenu.setVisible(true);
    }

    public void inicioActividad() {

        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
}
 

