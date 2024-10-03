package gestiondeevaluaciones2.pkg0;


public class NotaComentario {
    private double nota;
    private String comentario;

    public NotaComentario(double nota, String comentario) {
        this.nota = nota;
        this.comentario = comentario;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
