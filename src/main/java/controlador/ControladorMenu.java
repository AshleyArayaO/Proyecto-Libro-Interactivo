/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Libro;
import modelo.PaginaActividad;
import modelo.PaginaInformativa;
import vista.VistaActividad;
import vista.VistaMenu;
import vista.VistaPaginas;
import vista.VistaResultados;

/**
 *
 * @author Thinkpad P52
 */
public class ControladorMenu implements ActionListener {

    private final VistaMenu vista = new VistaMenu();
    private final Libro libro = new Libro();

    private int[][] historial = new int[3][3];
    private int[] notas = new int[3];
    private int[] numeroIntentos = {0};

    public ControladorMenu() {
        vista.addMenuListener(this);

        cargarRutas();
        cargarActividad();

        libro.recorrerPaginasRutaUno();
        libro.recorrerPaginasRutaDos();
    }

    private void cargarPaginasRutaUno() {

        libro.agregarPaginaRutaUno(new PaginaInformativa(
                "Ruta uno - Página 1",
                1,
                "Contenido de la primera página de la ruta uno."
        ));

        libro.agregarPaginaRutaUno(new PaginaInformativa(
                "Ruta uno - Página 2",
                2,
                "Contenido de la segunda página de la ruta uno."
        ));

        libro.agregarPaginaRutaUno(new PaginaInformativa(
                "Ruta uno - Página 3",
                3,
                "Contenido de la tercera página de la ruta uno."
        ));

    }

    private void cargarPaginasRutaDos() {

        libro.agregarPaginaRutaDos(new PaginaInformativa(
                "Ruta dos - Página 1",
                1,
                "Contenido de la primera página de la ruta dos."
        ));

        libro.agregarPaginaRutaDos(new PaginaInformativa(
                "Ruta dos - Página 2",
                2,
                "Contenido de la segunda página de la ruta dos."
        ));

        libro.agregarPaginaRutaDos(new PaginaInformativa(
                "Ruta dos - Página 3",
                3,
                "Contenido de la tercera página de la ruta dos."
        ));

    }

    private void cargarActividad() {

        String[] preguntas = {
            "¿Qué es la ciberseguridad?",
            "¿Cuál de las siguientes es una contraseña segura?",
            "¿Qué debes hacer al recibir un correo sospechoso?"
        };

        String[][] opciones = {
            {
                "Proteger sistemas y datos",
                "Crear videojuegos",
                "Editar imágenes"
            },
            {
                "123456",
                "MiNombre123",
                "T8#kP9!z"
            },
            {
                "Abrir todos sus enlaces",
                "Eliminarlo o reportarlo",
                "Compartirlo"
            }
        };

        PaginaActividad actividad = new PaginaActividad(
                "Actividad de aprendizaje",
                4,
                "Responde las siguientes preguntas para comprobar lo aprendido.",
                preguntas,
                opciones
        );
        libro.agregarActividad(actividad);
    }

    private void cargarRutas() {
        cargarPaginasRutaUno();
        cargarPaginasRutaDos();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String op = e.getActionCommand();

        switch (op) {

            case "INICIAR":
                iniciarRuta();
                break;

            case "PAGINAS":
                abrirPaginas();
                break;

            case "RESULTADOS":
                abrirResultados();
                break;

            case "ACTIVIDADES":
                abrirActividades();
                break;

            case "SALIR":
                vista.dispose();
                ControladorSonido.detenerMusicaFondo();
                System.exit(0);
                break;

        }

    }

    public void inicioMenu() {

        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        
    }

    public void iniciarRuta() {
        ControladorRutas control = new ControladorRutas(libro, vista);

        vista.setVisible(false);

        control.iniciarRutas();
    }

    public void abrirPaginas() {

        VistaPaginas paginas = new VistaPaginas();

        ControladorPaginas control = new ControladorPaginas(paginas, vista, libro, historial, notas, numeroIntentos);

        vista.setVisible(false);

        control.inicioPaginas();

    }

    public void abrirResultados() {
        VistaResultados resultados = new VistaResultados();

        ControladorResultados control = new ControladorResultados(resultados, vista, historial, notas, numeroIntentos);

        vista.setVisible(false);

        control.inicioResultados();
    }

    public void abrirActividades() {

        VistaActividad actividad = new VistaActividad();

        ControladorActividad control = new ControladorActividad(actividad, vista, libro, historial, notas, numeroIntentos);

        vista.setVisible(false);

        control.inicioActividad();
    }

}

