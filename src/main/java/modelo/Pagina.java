/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Thinkpad P52
 */
public abstract class Pagina implements ResponsableContenido {


    private String titulo;
    private int numeroPagina;
    private String contenido;


    public Pagina(String titulo, int numeroPagina, String contenido) {
        this.titulo = titulo;
        this.numeroPagina = numeroPagina;
        this.contenido = contenido;
    }


    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public int getNumeroPagina() {
        return numeroPagina;
    }

  
    public void setNumeroPagina(int numeroPagina) {
        this.numeroPagina = numeroPagina;
    }

 
    public String getContenido() {
        return contenido;
    }

 
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }


    @Override
    public abstract void mostrarContenido();

}

