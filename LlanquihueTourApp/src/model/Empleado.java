package model;

/**
 * Representa a un empleado de Llanquihue Tour.
 * Hereda de {@link Persona} y agrega sus datos laborales.
 */
public class Empleado extends Persona {
    private String cargo;
    private double sueldoBase;

    /**
     * Crea un empleado con sus datos personales y laborales.
     *
     * @param rut        RUT de la persona
     * @param nombre     nombre completo
     * @param telefono   teléfono de contacto
     * @param direccion  dirección de residencia
     * @param cargo      cargo que desempeña
     * @param sueldoBase sueldo base en pesos
     */
    public Empleado(String rut, String nombre, String telefono, Direccion direccion,
                    String cargo, double sueldoBase) {
        super(rut, nombre, telefono, direccion);
        this.cargo = cargo;
        this.sueldoBase = sueldoBase;
    }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }
    public double getSueldoBase() { return sueldoBase; }
    public void setSueldoBase(double sueldoBase) { this.sueldoBase = sueldoBase; }

    @Override
    public String toString() {
        return super.toString()
                + " | Cargo: " + cargo
                + " | Sueldo base: " + String.format("$%,.0f", sueldoBase);
    }
}
