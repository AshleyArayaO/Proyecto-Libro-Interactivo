/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Thinkpad P52
 */
public class Libro {

    private PaginaActividad actividad;

    private ArrayList<Pagina> paginasRutaUno;
    private ArrayList<Pagina> paginasRutaDos;

    public Libro() {
        paginasRutaUno = new ArrayList<>();
        paginasRutaDos = new ArrayList<>();
    }

    public void agregarPaginaRutaUno(Pagina pagina) {

        if (pagina == null) {
            throw new IllegalArgumentException("No se puede agregar una página vacía.");
        }

        paginasRutaUno.add(pagina);
    }

    public Pagina consultarPaginaRutaUno(int posicion) {

        if (posicion < 0 || posicion >= paginasRutaUno.size()) {
            throw new IndexOutOfBoundsException("La posición de la página no existe.");
        }

        return paginasRutaUno.get(posicion);
    }

    public void recorrerPaginasRutaUno() {

        for (Pagina pagina : paginasRutaUno) {
            pagina.mostrarContenido();
        }
    }

    public int obtenerCantidadPaginasRutaUno() {
        return paginasRutaUno.size();
    }

    public int obtenerCantidadPaginasInformativasRutaUno() {

        int contador = 0;

        for (Pagina pagina : paginasRutaUno) {
            if (pagina instanceof PaginaInformativa) {
                contador++;
            }
        }

        return contador;
    }

    public void insertarPaginaInformativaRutaUno(PaginaInformativa pagina) {

        if (pagina == null) {
            throw new IllegalArgumentException("La página no puede ser nula.");
        }

        paginasRutaUno.add(pagina);
    }

    public void agregarPaginaRutaDos(Pagina pagina) {

        if (pagina == null) {
            throw new IllegalArgumentException("No se puede agregar una página vacía.");
        }

        paginasRutaDos.add(pagina);
    }

    public Pagina consultarPaginaRutaDos(int posicion) {

        if (posicion < 0 || posicion >= paginasRutaDos.size()) {
            throw new IndexOutOfBoundsException("La posición de la página no existe.");
        }

        return paginasRutaDos.get(posicion);
    }

    public void recorrerPaginasRutaDos() {

        for (Pagina pagina : paginasRutaDos) {
            pagina.mostrarContenido();
        }
    }

    public int obtenerCantidadPaginasRutaDos() {
        return paginasRutaDos.size();
    }

    public int obtenerCantidadPaginasInformativasRutaDos() {

        int contador = 0;

        for (Pagina pagina : paginasRutaDos) {
            if (pagina instanceof PaginaInformativa) {
                contador++;
            }
        }

        return contador;
    }

    public void insertarPaginaInformativaRutaDos(PaginaInformativa pagina) {

        if (pagina == null) {
            throw new IllegalArgumentException("La página no puede ser nula.");
        }

        paginasRutaDos.add(pagina);
    }

    public void agregarActividad(PaginaActividad actividad) {

        if (actividad == null) {
            throw new IllegalArgumentException("La actividad no puede ser nula.");
        }

        this.actividad = actividad;
    }

    public PaginaActividad obtenerActividad() {
        return actividad;
    }
}

