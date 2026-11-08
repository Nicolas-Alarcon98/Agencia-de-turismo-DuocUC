package model;

/**
 * Representa a un cliente de Llanquihue Tour.
 * Hereda de {@link Persona} y agrega el tipo de cliente.
 */
public class Cliente extends Persona {
    private String tipoCliente;

    /**
     * Crea un cliente con sus datos personales y su tipo.
     *
     * @param rut         RUT de la persona
     * @param nombre      nombre completo
     * @param telefono    teléfono de contacto
     * @param direccion   dirección de residencia
     * @param tipoCliente Nacional o Extranjero
     */
    public Cliente(String rut, String nombre, String telefono, Direccion direccion, String tipoCliente) {
        super(rut, nombre, telefono, direccion);
        this.tipoCliente = tipoCliente;
    }

    public String getTipoCliente() { return tipoCliente; }
    public void setTipoCliente(String tipoCliente) { this.tipoCliente = tipoCliente; }

    @Override
    public String toString() {
        return super.toString() + " | Tipo de cliente: " + tipoCliente;
    }
}
