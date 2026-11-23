package model;

import util.Validador;

/**
 * Representa a un guía turístico de Llanquihue Tour.
 * Extiende Empleado porque todo guía es también un empleado.
 */
public class GuiaTuristico extends Empleado {
    private String idioma;
    private String especialidad;

    public GuiaTuristico(String rut, String nombre, String telefono, Direccion direccion,
                         String cargo, double sueldoBase, String idioma, String especialidad) {
        super(rut, nombre, telefono, direccion, cargo, sueldoBase);
        try {
            setIdioma(idioma);
            setEspecialidad(especialidad);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se pudo crear el guía turístico: " + e.getMessage());
        }
    }

    public String getIdioma() { return idioma; }

    public void setIdioma(String idioma) {
        this.idioma = Validador.texto(idioma, "idioma");
    }

    public String getEspecialidad() { return especialidad; }

    public void setEspecialidad(String especialidad) {
        this.especialidad = Validador.texto(especialidad, "especialidad");
    }

    @Override
    public String getRol() {
        return "Guía turístico";
    }

    @Override
    public String toString() {
        return super.toString()
                + " | Idioma: " + idioma
                + " | Especialidad: " + especialidad;
    }
}
