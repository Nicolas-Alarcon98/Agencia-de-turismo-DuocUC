package model;

import util.Validador;

/**
 * Representa a un empleado de Llanquihue Tour.
 * Hereda de Persona y agrega sus datos laborales.
 */
public class Empleado extends Persona {
    private String cargo;
    private double sueldoBase;

    public Empleado(String rut, String nombre, String telefono, Direccion direccion,
                    String cargo, double sueldoBase) {
        super(rut, nombre, telefono, direccion);
        try {
            setCargo(cargo);
            setSueldoBase(sueldoBase);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se pudo crear el empleado: " + e.getMessage());
        }
    }

    public String getCargo() { return cargo; }

    public void setCargo(String cargo) {
        this.cargo = Validador.texto(cargo, "cargo");
    }

    public double getSueldoBase() { return sueldoBase; }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = Validador.sueldo(sueldoBase);
    }

    @Override
    public String getRol() {
        return "Empleado";
    }

    @Override
    public String toString() {
        return super.toString()
                + " | Cargo: " + cargo
                + " | Sueldo base: " + String.format("$%,.0f", sueldoBase);
    }
}
