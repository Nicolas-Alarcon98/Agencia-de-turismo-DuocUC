package util;

import java.text.Normalizer;

/**
 * Clase con validaciones que se usan en varios lugares del sistema.
 */
public class Validador {

    private static final String RUT_REGEX = "\\d{7,8}-[0-9Kk]";

    /**
     * Revisa que un texto no esté vacío.
     */
    public static String texto(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo " + campo + " no puede estar vacío");
        }
        return valor.trim();
    }

    /**
     * Revisa que el RUT tenga el formato 12345678-9 (o terminado en K).
     */
    public static String rut(String rut) {
        String valor = texto(rut, "RUT");
        if (!valor.matches(RUT_REGEX)) {
            throw new IllegalArgumentException("RUT inválido: " + valor + ". Use el formato 12345678-9");
        }
        return valor;
    }

    /**
     * Revisa que el sueldo no sea negativo.
     */
    public static double sueldo(double sueldo) {
        if (sueldo < 0) {
            throw new IllegalArgumentException("El sueldo no puede ser negativo");
        }
        return sueldo;
    }

    /**
     * Pasa a minúsculas y quita las tildes, para que "guia" encuentre a "Guía".
     */
    public static String normalizar(String valor) {
        String texto = valor == null ? "" : valor.toLowerCase();
        return Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }
}
