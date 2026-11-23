package app;

import model.Persona;
import service.GestorPersonas;
import service.LectorPersonas;
import util.Validador;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Punto de entrada del sistema de Llanquihue Tour.
 * Carga los datos y muestra un menú de consultas por consola.
 */
public class Main {

    public static void main(String[] args) {
        GestorPersonas gestor = new GestorPersonas();
        LectorPersonas lector = new LectorPersonas();

        // La ruta cambia según se ejecute desde la carpeta del proyecto o desde la raíz.
        if (Files.exists(Paths.get("datos/personas.csv"))) {
            lector.cargar("datos/personas.csv", gestor);
        } else {
            lector.cargar("LlanquihueTourApp/datos/personas.csv", gestor);
        }

        System.out.println("Personas registradas: " + gestor.listarTodos().size());
        mostrarMenu(gestor);
    }

    /**
     * Muestra las opciones y ejecuta la que elija el usuario.
     */
    private static void mostrarMenu(GestorPersonas gestor) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println();
                System.out.println("=== LLANQUIHUE TOUR | CONSULTAS ===");
                System.out.println("1) Listar todas las personas");
                System.out.println("2) Buscar por nombre");
                System.out.println("3) Buscar por RUT");
                System.out.println("4) Filtrar por rol");
                System.out.println("5) Ver historial de búsquedas");
                System.out.println("0) Salir");
                System.out.print("Elija una opción: ");

                if (!scanner.hasNextLine()) {
                    System.out.println("Entrada cerrada. Hasta luego.");
                    break;
                }

                int opcion;
                try {
                    opcion = Integer.parseInt(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Opción no válida. Ingrese un número del 0 al 5.");
                    continue;
                }

                if (opcion == 0) {
                    System.out.println("Hasta luego.");
                    break;
                }

                switch (opcion) {
                    case 1:
                        imprimir(gestor.listarTodos());
                        break;
                    case 2:
                        String nombre = leerTexto(scanner, "Nombre o parte del nombre: ");
                        if (nombre.isEmpty()) {
                            System.out.println("No se ingresó un nombre.");
                        } else {
                            imprimir(gestor.buscarPorNombre(nombre));
                        }
                        break;
                    case 3:
                        buscarPorRut(scanner, gestor);
                        break;
                    case 4:
                        String rol = leerTexto(scanner, "Rol (cliente / empleado / guía): ");
                        if (rol.isEmpty()) {
                            System.out.println("No se ingresó un rol.");
                        } else {
                            imprimir(gestor.filtrarPorRol(rol));
                        }
                        break;
                    case 5:
                        System.out.println("--- HISTORIAL ---");
                        for (String consulta : gestor.getHistorial()) {
                            System.out.println(consulta);
                        }
                        if (gestor.getHistorial().isEmpty()) {
                            System.out.println("Todavía no hay búsquedas.");
                        }
                        break;
                    default:
                        System.out.println("Opción fuera de rango. Ingrese un número del 0 al 5.");
                }
            }
        }
    }

    /**
     * Pide un RUT, lo valida y busca a la persona.
     */
    private static void buscarPorRut(Scanner scanner, GestorPersonas gestor) {
        String entrada = leerTexto(scanner, "RUT (ej. 12345678-9): ");
        try {
            String rut = Validador.rut(entrada);
            Persona persona = gestor.buscarPorRut(rut);
            List<Persona> resultado = new ArrayList<Persona>();
            if (persona != null) {
                resultado.add(persona);
            }
            imprimir(resultado);
        } catch (IllegalArgumentException e) {
            System.out.println("No se pudo buscar: " + e.getMessage());
        }
    }

    /**
     * Lee una línea de texto de la consola.
     */
    private static String leerTexto(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        if (!scanner.hasNextLine()) {
            return "";
        }
        return scanner.nextLine().trim();
    }

    /**
     * Muestra una lista de personas y su total.
     */
    private static void imprimir(List<Persona> personas) {
        for (Persona persona : personas) {
            System.out.println("[" + persona.getRol() + "] " + persona);
        }
        System.out.println("Total: " + personas.size());
    }
}
