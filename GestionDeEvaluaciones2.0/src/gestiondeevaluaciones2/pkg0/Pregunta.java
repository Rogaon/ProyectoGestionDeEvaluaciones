package gestiondeevaluaciones2.pkg0;

public class Pregunta {
    private String enunciado;
    private String tema;

    public Pregunta(String enunciado, String tema) {
        this.enunciado = enunciado;
        this.tema = tema;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public String getTema() {
        return tema;
    }
}
