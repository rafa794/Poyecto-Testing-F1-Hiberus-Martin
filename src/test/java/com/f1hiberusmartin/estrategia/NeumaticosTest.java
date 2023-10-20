package com.f1hiberusmartin.estrategia;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NeumaticosTest {
    // Prueba que el constructor arroja una excepción para una marca inválida
    @Test
    public void testConstructorMarcaInvalida() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Neumaticos("Michelin", 80.0f);
        });
    }

    // Prueba que el constructor arroja una excepción para un porcentaje de vida inválido
    @Test
    public void testConstructorPorcentajeVidaInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Neumaticos("Pirelli", -10.0f);
        });
    }

    // Prueba que el constructor y los métodos getter funcionan correctamente para valores válidos
    @Test
    public void testConstructorMarcaValida() {
        Neumaticos neumaticos = new Neumaticos("Pirelli", 80.0f);
        assertEquals("Pirelli", neumaticos.getMarca());
        assertEquals(80.0f, neumaticos.getPorcentajeVida(), 0.001);
    }

    // Prueba que el método setPorcentajeVida arroja una excepción para un valor inválido
    @Test
    public void testSetPorcentajeVidaInvalido() {
        Neumaticos neumaticos = new Neumaticos("Bridgestone", 60.0f);
        assertThrows(IllegalArgumentException.class, () -> {
            neumaticos.setPorcentajeVida(-10.0f); // Debería lanzar una excepción
        });
    }

    // Prueba que el constructor y los métodos getter funcionan correctamente para valores válidos
    @Test
    public void testNeumaticos() {
        Neumaticos neumaticos = new Neumaticos("Pirelli", 100.0f);
        assertEquals("Pirelli", neumaticos.getMarca());
        assertEquals(100.0f, neumaticos.getPorcentajeVida(), 0.001);
    }

    // Prueba que el método setMarca cambia la marca correctamente
    @Test
    public void testSetMarca() {
        Neumaticos neumaticos = new Neumaticos("Bridgestone", 80.0f);
        neumaticos.setMarca("Michelin");
        assertEquals("Michelin", neumaticos.getMarca());
    }

    // Prueba que el método setPorcentajeVida permite el valor máximo
    @Test
    public void testSetPorcentajeVidaMaximo() {
        Neumaticos neumaticos = new Neumaticos("Pirelli", 80.0f);
        float porcentajeMaximo = 100.0f;
        neumaticos.setPorcentajeVida(porcentajeMaximo);
        assertEquals(porcentajeMaximo, neumaticos.getPorcentajeVida(), 0.001);
    }

    // Prueba que el método setPorcentajeVida permite el valor mínimo
    @Test
    public void testSetPorcentajeVidaMinimo() {
        Neumaticos neumaticos = new Neumaticos("Bridgestone", 100.0f);
        neumaticos.setPorcentajeVida(0.0f); // Desgaste completo
        assertEquals(0.0f, neumaticos.getPorcentajeVida(), 0.001);
    }

    // Prueba que el método setPorcentajeVida arroja una excepción para un valor negativo
    @Test
    public void testSetPorcentajeVidaNegativo() {
        Neumaticos neumaticos = new Neumaticos("Pirelli", 80.0f);
        assertThrows(IllegalArgumentException.class, () -> {
            neumaticos.setPorcentajeVida(-10.0f); // Debería lanzar una excepción
        });
    }

    // Prueba que el método setPorcentajeVida permite un valor válido
    @Test
    public void testSetPorcentajeVidaValido() {
        Neumaticos neumaticos = new Neumaticos("Pirelli", 80.0f);
        float porcentajeValido = 50.0f;
        neumaticos.setPorcentajeVida(porcentajeValido);
        assertEquals(porcentajeValido, neumaticos.getPorcentajeVida(), 0.001);
    }

    // Prueba que el método setPorcentajeVida permite el valor de cero
    @Test
    public void testSetPorcentajeVidaCero() {
        Neumaticos neumaticos = new Neumaticos("Pirelli", 80.0f);
        float porcentajeCero = 0.0f;
        neumaticos.setPorcentajeVida(porcentajeCero);
        assertEquals(porcentajeCero, neumaticos.getPorcentajeVida(), 0.001);
    }

    // Prueba que el metodo setPorcentajeVida permite un valor intermedio, porque sí 😂
    @Test
    public void testSetPorcentajeVidaValorIntermedio() {
        Neumaticos neumaticos = new Neumaticos("Pirelli", 80.0f);
        float porcentajeIntermedio = 40.0f;
        neumaticos.setPorcentajeVida(porcentajeIntermedio);
        assertEquals(porcentajeIntermedio, neumaticos.getPorcentajeVida(), 0.001);
    }
}
