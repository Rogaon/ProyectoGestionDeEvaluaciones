package gestiondeevaluaciones2.pkg0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BancoDePreguntas {
    private Map<String, List<Pregunta>> preguntasPorTema;

    public BancoDePreguntas() {
        this.preguntasPorTema = new HashMap<>();
    }

    public void agregarPregunta(Pregunta pregunta) {
        String tema = pregunta.getTema();
        preguntasPorTema.computeIfAbsent(tema, k -> new ArrayList<>()).add(pregunta);
    }

    public List<Pregunta> obtenerPreguntasPorTema(String tema) {
        return preguntasPorTema.getOrDefault(tema, new ArrayList<>());
    }

    public List<String> obtenerTemas() {
        return new ArrayList<>(preguntasPorTema.keySet());
    }
}
