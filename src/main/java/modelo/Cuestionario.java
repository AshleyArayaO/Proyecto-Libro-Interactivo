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
public class Cuestionario extends ContenidoEducativo {

    private ArrayList<Pregunta> preguntas;

    public Cuestionario(String id, String titulo) {
        super(id, titulo);
        preguntas = new ArrayList<>();
    }    

    @Override
    public String obtenerContenido() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
