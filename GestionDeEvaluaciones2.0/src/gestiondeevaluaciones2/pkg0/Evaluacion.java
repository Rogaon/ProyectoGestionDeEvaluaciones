package gestiondeevaluaciones2.pkg0;


import java.util.ArrayList;
import java.util.List;

public class Evaluacion {
    private String titulo;
    private List<Pregunta> preguntas;
    private List<NotaComentario> notasComentarios;

    public Evaluacion(String titulo) {
        this.titulo = titulo;
        this.preguntas = new ArrayList<>();
        this.notasComentarios = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void agregarPreguntas(List<Pregunta> preguntas, int cantidad) {
        if (cantidad > preguntas.size()) {
            cantidad = preguntas.size();
        }
        this.preguntas.addAll(preguntas.subList(0, cantidad));
    }

    public void registrarNota(double nota, String comentario) {
        notasComentarios.add(new NotaComentario(nota, comentario));
    }

    public boolean modificarNota(double notaAntigua, double notaNueva, String nuevoComentario) {
        for (NotaComentario nc : notasComentarios) {
            if (nc.getNota() == notaAntigua) {
                nc.setNota(notaNueva);
                nc.setComentario(nuevoComentario);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Título: ").append(titulo).append("\n");
        sb.append("Preguntas:\n");
        for (Pregunta pregunta : preguntas) {
            sb.append(" - ").append(pregunta.getEnunciado()).append("\n");
        }
        sb.append("Notas y Comentarios:\n");
        for (NotaComentario nc : notasComentarios) {
            sb.append(" - Nota: ").append(nc.getNota()).append(", Comentario: ").append(nc.getComentario()).append("\n");
        }
        return sb.toString();
    }
}
