/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Thinkpad P52
 */

public abstract class ContenidoEducativo extends ElementoLibro {

    public ContenidoEducativo(String id, String titulo) {
        super(id, titulo);
    }

    public abstract String obtenerContenido();
}
    

