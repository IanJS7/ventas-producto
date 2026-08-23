package mx.edu.ventas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class ProductoTest {

    @Test
    void creaProductoValido() {
        Producto producto = new Producto("P-001", "Teclado", new BigDecimal("599.90"), 12);

        assertEquals("P-001", producto.getCodigo());
        assertEquals("Teclado", producto.getNombre());
        assertEquals(new BigDecimal("599.90"), producto.getPrecio());
        assertEquals(12, producto.getExistencia());
    }

    @Test
    void rechazaCodigoVacio() {
        assertThrows(IllegalArgumentException.class,
                () -> new Producto("  ", "Teclado", BigDecimal.ONE, 1));
    }

    @Test
    void rechazaNombreNulo() {
        assertThrows(IllegalArgumentException.class,
                () -> new Producto("P-001", null, BigDecimal.ONE, 1));
    }

    @Test
    void rechazaPrecioNegativo() {
        assertThrows(IllegalArgumentException.class,
                () -> new Producto("P-001", "Teclado", new BigDecimal("-0.01"), 1));
    }

    @Test
    void rechazaExistenciaNegativa() {
        assertThrows(IllegalArgumentException.class,
                () -> new Producto("P-001", "Teclado", BigDecimal.ONE, -1));
    }
}
