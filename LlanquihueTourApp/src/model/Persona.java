package model;

/**
 * Clase base que representa a una persona vinculada a Llanquihue Tour.
 * Contiene una {@link Direccion} (relación de composición).
 */
public class Persona {
    private String rut;
    private String nombre;
    private String telefono;
    private Direccion direccion;

    /**
     * Crea una persona con sus datos de identificación y contacto.
     *
     * @param rut       RUT de la persona
     * @param nombre    nombre completo
     * @param telefono  teléfono de contacto
     * @param direccion dirección de residencia
     */
    public Persona(String rut, String nombre, String telefono, Direccion direccion) {
        this.rut = rut;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getRut() { return rut; }
    public void setRut(String rut) { this.rut = rut; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public Direccion getDireccion() { return direccion; }
    public void setDireccion(Direccion direccion) { this.direccion = direccion; }

    @Override
    public String toString() {
        return "Nombre: " + nombre
                + " | RUT: " + rut
                + " | Teléfono: " + telefono
                + " | Dirección: " + direccion;
    }
}
