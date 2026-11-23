package model;

import util.Validador;

/**
 * Representa a un cliente de Llanquihue Tour.
 * Hereda de Persona y agrega el tipo de cliente.
 */
public class Cliente extends Persona {
    private String tipoCliente;

    public Cliente(String rut, String nombre, String telefono, Direccion direccion, String tipoCliente) {
        super(rut, nombre, telefono, direccion);
        try {
            setTipoCliente(tipoCliente);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se pudo crear el cliente: " + e.getMessage());
        }
    }

    public String getTipoCliente() { return tipoCliente; }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = Validador.texto(tipoCliente, "tipo de cliente");
    }

    @Override
    public String getRol() {
        return "Cliente";
    }

    @Override
    public String toString() {
        return super.toString() + " | Tipo de cliente: " + tipoCliente;
    }
}
