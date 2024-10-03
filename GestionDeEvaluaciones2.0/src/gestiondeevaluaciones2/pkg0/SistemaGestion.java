package gestiondeevaluaciones2.pkg0;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaGestion {
    private List<Evaluacion> evaluaciones;
    private BancoDePreguntas bancoDePreguntas;

    public SistemaGestion() {
        this.evaluaciones = new ArrayList<>();
        this.bancoDePreguntas = new BancoDePreguntas();
        
        // Datos iniciales
        crearEvaluacion("Evaluacion 1");
        crearEvaluacion("Evaluacion 2");
    }

    public void crearEvaluacion(String titulo) {
        evaluaciones.add(new Evaluacion(titulo));
    }

    public Evaluacion obtenerEvaluacionPorTitulo(String titulo) {
        for (Evaluacion evaluacion : evaluaciones) {
            if (evaluacion.getTitulo().equalsIgnoreCase(titulo)) {
                return evaluacion;
            }
        }
        return null;
    }

    public boolean eliminarEvaluacion(String titulo) {
        Evaluacion evaluacion = obtenerEvaluacionPorTitulo(titulo);
        if (evaluacion != null) {
            evaluaciones.remove(evaluacion);
            return true;
        }
        return false;
    }

    public void agregarPreguntaAlBanco(Pregunta pregunta) {
        bancoDePreguntas.agregarPregunta(pregunta);
    }

    public List<Pregunta> obtenerPreguntasPorTema(String tema) {
        return bancoDePreguntas.obtenerPreguntasPorTema(tema);
    }

    public List<String> obtenerTemas() {
        return bancoDePreguntas.obtenerTemas();
    }
    
    public boolean eliminarPregunta(String enunciado, String tema) {
        List<Pregunta> preguntas = bancoDePreguntas.obtenerPreguntasPorTema(tema);
        for (Pregunta pregunta : preguntas) {
            if (pregunta.getEnunciado().equalsIgnoreCase(enunciado)) {
                preguntas.remove(pregunta);
                return true;
            }
        }
        return false;
    }

    public void mostrarTodasLasPreguntas() {
        List<String> temas = obtenerTemas();
        if (temas.isEmpty()) {
            System.out.println("No hay temas en el banco de preguntas.");
            return;
        }
        for (String tema : temas) {
            System.out.println("Tema: " + tema);
            List<Pregunta> preguntas = obtenerPreguntasPorTema(tema);
            for (Pregunta pregunta : preguntas) {
                System.out.println(" - " + pregunta.getEnunciado());
            }
        }
    }

    public void mostrarPreguntasPorTema(String tema) {
        List<Pregunta> preguntas = obtenerPreguntasPorTema(tema);
        if (preguntas.isEmpty()) {
            System.out.println("No hay preguntas para el tema: " + tema);
            return;
        }
        System.out.println("Preguntas del tema " + tema + ":");
        for (Pregunta pregunta : preguntas) {
            System.out.println(" - " + pregunta.getEnunciado());
        }
    }

    public void mostrarOpcionesMenu(Scanner scanner) {
        System.out.println("1. Crear evaluación");
        System.out.println("2. Agregar pregunta al banco");
        System.out.println("3. Agregar preguntas a una evaluación");
        System.out.println("4. Registrar nota");
        System.out.println("5. Mostrar evaluación");
        System.out.println("6. Eliminar evaluación");
        System.out.println("7. Eliminar pregunta");
        System.out.println("8. Modificar nota");
        System.out.println("9. Mostrar preguntas");
        System.out.println("10. Salir");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        switch (opcion) {
            case 1:
                System.out.print("Ingrese el título de la evaluación: ");
                String titulo = scanner.nextLine();
                crearEvaluacion(titulo);
                break;
            case 2:
                System.out.print("Ingrese el enunciado de la pregunta: ");
                String enunciado = scanner.nextLine();
                System.out.print("Ingrese el tema de la pregunta: ");
                String tema = scanner.nextLine();
                agregarPreguntaAlBanco(new Pregunta(enunciado, tema));
                break;
            case 3:
                System.out.print("Ingrese el título de la evaluación: ");
                String tituloEvaluacion = scanner.nextLine();
                Evaluacion evaluacion = obtenerEvaluacionPorTitulo(tituloEvaluacion);
                if (evaluacion == null) {
                    System.out.println("Evaluación no encontrada.");
                    break;
                }
                System.out.print("Ingrese el tema de las preguntas: ");
                String temaPreguntas = scanner.nextLine();
                List<Pregunta> preguntas = obtenerPreguntasPorTema(temaPreguntas);
                System.out.print("Ingrese la cantidad de preguntas a agregar: ");
                int cantidad = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea
                evaluacion.agregarPreguntas(preguntas, cantidad);
                break;
            case 4:
                System.out.print("Ingrese el título de la evaluación: ");
                String tituloNota = scanner.nextLine();
                Evaluacion evaluacionNota = obtenerEvaluacionPorTitulo(tituloNota);
                if (evaluacionNota == null) {
                    System.out.println("Evaluación no encontrada.");
                    break;
                }
                System.out.print("Ingrese la nota: ");
                double nota = scanner.nextDouble();
                scanner.nextLine(); // Consumir la nueva línea
                System.out.print("Ingrese el comentario (opcional): ");
                String comentario = scanner.nextLine();
                evaluacionNota.registrarNota(nota, comentario);
                break;
            case 5:
                System.out.print("Ingrese el título de la evaluación: ");
                String tituloMostrar = scanner.nextLine();
                Evaluacion evaluacionMostrar = obtenerEvaluacionPorTitulo(tituloMostrar);
                if (evaluacionMostrar == null) {
                    System.out.println("Evaluación no encontrada.");
                } else {
                    System.out.println(evaluacionMostrar);
                }
                break;
            case 6:
                System.out.print("Ingrese el título de la evaluación a eliminar: ");
                String tituloEliminar = scanner.nextLine();
                boolean eliminado = eliminarEvaluacion(tituloEliminar);
                if (eliminado) {
                    System.out.println("Evaluación eliminada.");
                } else {
                    System.out.println("Evaluación no encontrada.");
                }
                break;
            case 7:
                System.out.print("Ingrese el enunciado de la pregunta a eliminar: ");
                String enunciadoEliminar = scanner.nextLine();
                System.out.print("Ingrese el tema de la pregunta: ");
                String temaEliminar = scanner.nextLine();
                boolean preguntaEliminada = eliminarPregunta(enunciadoEliminar, temaEliminar);
                if (preguntaEliminada) {
                    System.out.println("Pregunta eliminada.");
                } else {
                    System.out.println("Pregunta no encontrada.");
                }
                break;
            case 8:
                System.out.print("Ingrese el título de la evaluación: ");
                String tituloNotaModificar = scanner.nextLine();
                Evaluacion evaluacionNotaModificar = obtenerEvaluacionPorTitulo(tituloNotaModificar);
                if (evaluacionNotaModificar == null) {
                    System.out.println("Evaluación no encontrada.");
                    break;
                }
                System.out.print("Ingrese la nota antigua: ");
                double notaAntigua = scanner.nextDouble();
                scanner.nextLine(); // Consumir la nueva línea
                System.out.print("Ingrese la nueva nota: ");
                double notaNueva = scanner.nextDouble();
                scanner.nextLine(); // Consumir la nueva línea
                System.out.print("Ingrese el nuevo comentario (opcional): ");
                String nuevoComentario = scanner.nextLine();
                boolean notaModificada = evaluacionNotaModificar.modificarNota(notaAntigua, notaNueva, nuevoComentario);
                if (notaModificada) {
                    System.out.println("Nota modificada.");
                } else {
                    System.out.println("Nota antigua no encontrada.");
                }
                break;
            case 9:
                mostrarSubMenuMostrarPreguntas(scanner);
                break;
            case 10:
                System.out.println("Saliendo...");
                System.exit(0);
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }

    public void mostrarSubMenuMostrarPreguntas(Scanner scanner) {
        System.out.println("1. Mostrar todas las preguntas");
        System.out.println("2. Mostrar preguntas por tema");
        System.out.println("3. Regresar al menú principal");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        switch (opcion) {
            case 1:
                mostrarTodasLasPreguntas();
                break;
            case 2:
                System.out.print("Ingrese el tema para mostrar las preguntas: ");
                String temaMostrar = scanner.nextLine();
                mostrarPreguntasPorTema(temaMostrar);
                break;
            case 3:
                break; // Regresa al menú principal
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }
}
