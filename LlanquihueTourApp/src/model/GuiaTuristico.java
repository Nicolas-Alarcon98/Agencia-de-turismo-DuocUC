package model;

/**
 * Representa a un guía turístico de Llanquihue Tour.
 * Extiende {@link Empleado} porque todo guía es también un empleado.
 */
public class GuiaTuristico extends Empleado {
    private String idioma;
    private String especialidad;

    /**
     * Crea un guía turístico con sus datos laborales y de especialidad.
     *
     * @param rut          RUT de la persona
     * @param nombre       nombre completo
     * @param telefono     teléfono de contacto
     * @param direccion    dirección de residencia
     * @param cargo        cargo que desempeña
     * @param sueldoBase   sueldo base en pesos
     * @param idioma       idioma en que realiza los tours
     * @param especialidad tipo de experiencia que guía
     */
    public GuiaTuristico(String rut, String nombre, String telefono, Direccion direccion,
                         String cargo, double sueldoBase, String idioma, String especialidad) {
        super(rut, nombre, telefono, direccion, cargo, sueldoBase);
        this.idioma = idioma;
        this.especialidad = especialidad;
    }

    public String getIdioma() { return idioma; }
    public void setIdioma(String idioma) { this.idioma = idioma; }
    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    @Override
    public String toString() {
        return super.toString()
                + " | Idioma: " + idioma
                + " | Especialidad: " + especialidad;
    }
}
