package service;

import model.Persona;
import util.Validador;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Stack;

/**
 * Guarda las personas de la agencia y permite consultarlas.
 *
 * El diccionario usa el RUT como clave para evitar repetidos y acceder
 * rápido a una persona. La pila guarda las búsquedas realizadas.
 */
public class GestorPersonas {

    private LinkedHashMap<String, Persona> personasPorRut = new LinkedHashMap<String, Persona>();
    private Stack<String> historial = new Stack<String>();

    /**
     * Agrega una persona si su RUT no está repetido.
     */
    public void agregar(Persona persona) {
        if (personasPorRut.containsKey(persona.getRut())) {
            System.out.println("RUT repetido, no se agregó: " + persona.getRut());
        } else {
            personasPorRut.put(persona.getRut(), persona);
        }
    }

    /**
     * Devuelve todas las personas en una lista, en orden de carga.
     */
    public List<Persona> listarTodos() {
        return new ArrayList<Persona>(personasPorRut.values());
    }

    /**
     * Busca una persona por su RUT y guarda la consulta en el historial.
     * Devuelve null si no la encuentra.
     */
    public Persona buscarPorRut(String rut) {
        historial.push(rut);
        return personasPorRut.get(rut);
    }

    /**
     * Busca personas cuyo nombre contenga el texto indicado.
     * No importa si escriben con o sin tilde.
     */
    public List<Persona> buscarPorNombre(String texto) {
        historial.push(texto);
        String filtro = Validador.normalizar(texto);

        List<Persona> resultados = new ArrayList<Persona>();
        for (Persona persona : listarTodos()) {
            if (Validador.normalizar(persona.getNombre()).contains(filtro)) {
                resultados.add(persona);
            }
        }
        return resultados;
    }

    /**
     * Filtra las personas por su rol: Cliente, Empleado o Guía turístico.
     */
    public List<Persona> filtrarPorRol(String rol) {
        historial.push(rol);
        String filtro = Validador.normalizar(rol);

        List<Persona> resultados = new ArrayList<Persona>();
        for (Persona persona : listarTodos()) {
            if (Validador.normalizar(persona.getRol()).contains(filtro)) {
                resultados.add(persona);
            }
        }
        return resultados;
    }

    /**
     * Devuelve el historial de búsquedas (la más reciente primero).
     */
    public Stack<String> getHistorial() {
        return historial;
    }
}
