/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondeevaluaciones;

import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;

/**
 *
 * @author samue
 */
public class Evaluacion {
    private String titulo;
    private List<Pregunta> preguntas;
    private List<Double> notas;
    
    public Evaluacion(String titulo){
        this.titulo = titulo;
        this.preguntas = new ArrayList<>();
        this.notas = new ArrayList<>();
    }
    
    public void agregarPregunta(Pregunta pregunta){
        preguntas.add(pregunta);
    }
    
    public void registrarNota(double nota){
        notas.add(nota);
    }
    
    public List<Pregunta> getPreguntas(){
        return preguntas;
    }
    
    public List<Double> getNotas(){
        return notas;
    }
    
    
}
