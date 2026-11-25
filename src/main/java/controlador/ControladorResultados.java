/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VistaMenu;
import vista.VistaResultados;

/**
 *
 * @author Thinkpad P52
 */
public class ControladorResultados implements ActionListener {

    private VistaResultados vista;
    private VistaMenu vistaMenu;

    private int[][] historial;
    private int[] notas;
    private int[] contadorIntentos;

    public ControladorResultados(VistaResultados vista, VistaMenu vistaMenu, int[][] historial, int[] notas, int[] contadorIntentos) {

        this.vista = vista;
        this.vistaMenu = vistaMenu;
        this.historial = historial;
        this.notas = notas;
        this.contadorIntentos = contadorIntentos;

        vista.addResultadosListener((ActionListener) this);

        mostrarResultados();
    }

    private void mostrarResultados() {

        StringBuilder texto = new StringBuilder();

        texto.append("RESULTADOS DE LAS ACTIVIDADES\n\n");

        if (contadorIntentos[0] == 0) {
            texto.append("Todavía no se ha realizado ningún intento.");
        } else {

            for (int i = 0; i < contadorIntentos[0]; i++) {

                texto.append("INTENTO ").append(i + 1).append("\n");

                texto.append("Respuestas seleccionadas:\n");

                for (int j = 0; j < historial[i].length; j++) {

                    texto.append("Pregunta ")
                            .append(j + 1)
                            .append(": Opción ")
                            .append(historial[i][j])
                            .append("\n");
                }

                texto.append("Respuestas correctas: ")
                        .append(notas[i])
                        .append(" de 3\n");

                texto.append("Calificación: ")
                        .append(notas[i] * 100 / 3)
                        .append("%\n\n");
            }
        }

        vista.mostrarResultados(texto.toString());
    }

    public void inicioResultados() {
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {

            case "MENU":
                vista.dispose();
                vistaMenu.setVisible(true);
                break;
        }
    }
}

