package service;

import model.Cliente;
import model.Direccion;
import model.Empleado;
import model.GuiaTuristico;
import model.Persona;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 * Lee el archivo CSV y crea los objetos Persona.
 */
public class LectorPersonas {

    /**
     * Carga las personas del archivo dentro del gestor.
     */
    public void cargar(String ruta, GestorPersonas gestor) {
        try (BufferedReader lector = Files.newBufferedReader(Paths.get(ruta), StandardCharsets.UTF_8)) {

            String cabecera = lector.readLine();
            if (cabecera == null) {
                System.out.println("El archivo está vacío: " + ruta);
                return;
            }

            // Los nombres de la cabecera sirven como claves del HashMap.
            String[] nombresColumnas = cabecera.split(";");

            String linea;
            while ((linea = lector.readLine()) != null) {
                if (linea.trim().isEmpty()) {
                    continue;
                }

                try {
                    HashMap<String, String> fila = crearFila(nombresColumnas, linea);
                    Persona persona = crearPersona(fila);
                    gestor.agregar(persona);
                } catch (Exception e) {
                    System.out.println("Fila omitida: " + linea + " - " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo: " + ruta);
            System.out.println(e.getMessage());
        }
    }

    /**
     * Junta cada nombre de columna con su valor, por ejemplo:
     * "rut" -> "19876543-2", "nombre" -> "Camila Rojas".
     * Así después se puede leer fila.get("rut") en vez de datos[1].
     */
    private HashMap<String, String> crearFila(String[] nombresColumnas, String linea) {
        // El -1 conserva las columnas vacías del final (por ejemplo, los ;;;; del CSV).
        String[] valores = linea.split(";", -1);
        HashMap<String, String> fila = new HashMap<String, String>();

        for (int i = 0; i < nombresColumnas.length; i++) {
            if (i >= valores.length) {
                throw new IllegalArgumentException("faltan columnas en la fila");
            }
            fila.put(nombresColumnas[i].trim(), valores[i].trim());
        }
        return fila;
    }

    /**
     * Convierte una fila ya nombrada en el objeto correspondiente.
     */
    private Persona crearPersona(HashMap<String, String> fila) {
        String tipo = fila.get("tipo");
        String rut = fila.get("rut");
        String nombre = fila.get("nombre");
        String telefono = fila.get("telefono");

        Direccion direccion = new Direccion(
                fila.get("calle"),
                fila.get("numero"),
                fila.get("ciudad"),
                fila.get("region"));

        if ("CLIENTE".equals(tipo)) {
            return new Cliente(rut, nombre, telefono, direccion, fila.get("tipoCliente"));

        } else if ("EMPLEADO".equals(tipo)) {
            double sueldo = Double.parseDouble(fila.get("sueldoBase"));
            return new Empleado(rut, nombre, telefono, direccion, fila.get("cargo"), sueldo);

        } else if ("GUIA".equals(tipo)) {
            double sueldo = Double.parseDouble(fila.get("sueldoBase"));
            return new GuiaTuristico(rut, nombre, telefono, direccion, fila.get("cargo"),
                    sueldo, fila.get("idioma"), fila.get("especialidad"));

        } else {
            throw new IllegalArgumentException("Tipo de persona desconocido: " + tipo);
        }
    }
}
