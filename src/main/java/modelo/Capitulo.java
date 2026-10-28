/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Thinkpad P52
 */
public class Capitulo extends ContenidoEducativo {
    private String contenido;
    private String[][] ejemplos;

    public Capitulo(String id,String titulo,String contenido,String[][] ejemplos) {
        super(id, titulo);
        this.contenido = contenido;
        this.ejemplos = ejemplos;
    }

    @Override
    public String obtenerContenido() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
