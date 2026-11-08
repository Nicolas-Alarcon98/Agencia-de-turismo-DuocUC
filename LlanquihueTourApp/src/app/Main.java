package app;

import model.Cliente;
import model.Direccion;
import model.Empleado;
import model.GuiaTuristico;

/**
 * Punto de entrada del sistema de gestión de personas de Llanquihue Tour.
 */
public class Main {

    /**
     * Crea personas del dominio y muestra sus datos por consola.
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {

        // Composición: cada persona tiene su propia dirección
        Direccion dirCliente = new Direccion("Los Volcanes", "1250", "Llanquihue", "Los Lagos");
        Direccion dirGuia = new Direccion("Av. Costanera", "480", "Puerto Varas", "Los Lagos");
        Direccion dirOperadora = new Direccion("Camino Rural", "37", "Frutillar", "Los Lagos");

        Cliente cliente = new Cliente("19876543-2", "Camila Rojas",
                "+56 9 8765 4321", dirCliente, "Nacional");

        GuiaTuristico guia = new GuiaTuristico("15432109-K", "Pedro Muñoz",
                "+56 9 2345 6789", dirGuia, "Guía de turismo", 850000,
                "Inglés", "Rutas gastronómicas");

        Empleado operadora = new Empleado("12345678-9", "Valentina Soto",
                "+56 9 1122 3344", dirOperadora, "Operadora de reservas", 780000);

        System.out.println("=== PERSONAS REGISTRADAS EN LLANQUIHUE TOUR ===");
        System.out.println("CLIENTE        -> " + cliente);
        System.out.println("GUÍA TURÍSTICO -> " + guia);
        System.out.println("EMPLEADO       -> " + operadora);
    }
}
