package model;

import util.Validador;

/**
 * Clase base que representa a una persona vinculada a Llanquihue Tour.
 * Contiene una Direccion (relación de composición).
 */
public class Persona {
    private String rut;
    private String nombre;
    private String telefono;
    private Direccion direccion;

    public Persona(String rut, String nombre, String telefono, Direccion direccion) {
        try {
            setRut(rut);
            setNombre(nombre);
            setTelefono(telefono);
            setDireccion(direccion);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se pudo crear la persona: " + e.getMessage());
        }
    }

    public String getRut() { return rut; }

    public void setRut(String rut) {
        this.rut = Validador.rut(rut);
    }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) {
        this.nombre = Validador.texto(nombre, "nombre");
    }

    public String getTelefono() { return telefono; }

    public void setTelefono(String telefono) {
        this.telefono = Validador.texto(telefono, "teléfono");
    }

    public Direccion getDireccion() { return direccion; }

    public void setDireccion(Direccion direccion) {
        if (direccion == null) {
            throw new IllegalArgumentException("La dirección no puede ser null");
        }
        this.direccion = direccion;
    }

    /**
     * Devuelve el rol de la persona. Se usa para filtrar en el gestor.
     */
    public String getRol() {
        return "Persona";
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre
                + " | RUT: " + rut
                + " | Teléfono: " + telefono
                + " | Dirección: " + direccion;
    }
}
