package model;

import util.Validador;

/**
 * Representa la dirección física de una persona vinculada a Llanquihue Tour.
 */
public class Direccion {
    private String calle;
    private String numero;
    private String ciudad;
    private String region;

    public Direccion(String calle, String numero, String ciudad, String region) {
        try {
            setCalle(calle);
            setNumero(numero);
            setCiudad(ciudad);
            setRegion(region);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se pudo crear la dirección: " + e.getMessage());
        }
    }

    public String getCalle() { return calle; }

    public void setCalle(String calle) {
        this.calle = Validador.texto(calle, "calle");
    }

    public String getNumero() { return numero; }

    public void setNumero(String numero) {
        this.numero = Validador.texto(numero, "número");
    }

    public String getCiudad() { return ciudad; }

    public void setCiudad(String ciudad) {
        this.ciudad = Validador.texto(ciudad, "ciudad");
    }

    public String getRegion() { return region; }

    public void setRegion(String region) {
        this.region = Validador.texto(region, "región");
    }

    @Override
    public String toString() {
        return calle + " " + numero + ", " + ciudad + ", Región de " + region;
    }
}
