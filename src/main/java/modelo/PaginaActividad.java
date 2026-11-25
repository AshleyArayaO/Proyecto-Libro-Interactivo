/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Thinkpad P52
 */
public class PaginaActividad extends Pagina {

    private String[] preguntas;
    private String[][] opciones;

    public PaginaActividad(String titulo, int numeroPagina, String contenido, String[] preguntas, String[][] opciones) {

        super(titulo, numeroPagina, contenido);
        this.preguntas = preguntas;
        this.opciones = opciones;
    }

    public String[] getPreguntas() {
        return preguntas;
    }

    public String[][] getOpciones() {
        return opciones;
    }

    @Override
    public void mostrarContenido() {
        System.out.println("================================");
        System.out.println("Página: " + getNumeroPagina());
        System.out.println("Título: " + getTitulo());
        System.out.println("--------------------------------");
        System.out.println(getContenido());

        for (int i = 0; i < preguntas.length; i++) {
            System.out.println("\nPregunta " + (i + 1) + ": "
                    + preguntas[i]);

            for (int j = 0; j < opciones[i].length; j++) {
                System.out.println((j + 1) + ". " + opciones[i][j]);
            }
        }

        System.out.println("================================");
    }
}

 

