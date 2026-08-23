package mx.edu.ventas;

import java.math.BigDecimal;
import java.util.Objects;

/** Entidad de catálogo para el prototipo de ventas. */
public class Producto {
    private final String codigo;
    private String nombre;
    private BigDecimal precio;
    private int existencia;

    public Producto(String codigo, String nombre, BigDecimal precio, int existencia) {
        this.codigo = validarTexto(codigo, "El código es obligatorio");
        setNombre(nombre);
        setPrecio(precio);
        setExistencia(existencia);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setNombre(String nombre) {
        this.nombre = validarTexto(nombre, "El nombre es obligatorio");
    }

    public void setPrecio(BigDecimal precio) {
        Objects.requireNonNull(precio, "El precio es obligatorio");
        if (precio.signum() < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.precio = precio;
    }

    public void setExistencia(int existencia) {
        if (existencia < 0) {
            throw new IllegalArgumentException("La existencia no puede ser negativa");
        }
        this.existencia = existencia;
    }

    private static String validarTexto(String valor, String mensaje) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(mensaje);
        }
        return valor;
    }
}
