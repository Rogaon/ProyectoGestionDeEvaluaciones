package gestiondeevaluaciones2.pkg0;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        SistemaGestion sistema = new SistemaGestion();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            sistema.mostrarOpcionesMenu(scanner);
        }
    }
}
