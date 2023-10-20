package com.f1hiberusmartin.estrategia;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CombustibleTest {
    @Test
    public void testCombustible() {
        Combustible combustible = new Combustible("Diésel", 50.0f);
        assertEquals("Diésel", combustible.getTipo());
        assertEquals(50.0f, combustible.getCapacidad(), 0.001);
    }

    @Test
    public void testIgualdadCombustible() {
        Combustible combustible1 = new Combustible("Diésel", 50.0f);
        Combustible combustible2 = new Combustible("Diésel", 50.0f);
        assertEquals(combustible1, combustible2); // Deben ser iguales
    }

    @Test
    public void testCapacidadNegativa() {
        assertThrows(IllegalArgumentException.class, () -> new Combustible("Diésel", -10.0f));
    }

    @Test
    public void testConstructorTipoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Combustible("Hidrógeno", 60.0f); // Debería lanzar una excepción
        });
    }
    @Test
    public void testCreacionCombustibleValido() {
        Combustible combustible = new Combustible("Diésel", 50.0f);
        assertEquals("Diésel", combustible.getTipo());
        assertEquals(50.0f, combustible.getCapacidad(), 0.001);
    }

    @Test
    public void testCreacionCombustibleInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Combustible("Hidrógeno", 60.0f); // Debería lanzar una excepción
        });
    }

    @Test
    public void testEqualsCombustibleIgual() {
        Combustible combustible1 = new Combustible("Diésel", 50.0f);
        Combustible combustible2 = new Combustible("Diésel", 50.0f);
        assertEquals(combustible1, combustible2);
    }

    @Test
    public void testEqualsCombustibleDiferente() {
        Combustible combustible1 = new Combustible("Diésel", 50.0f);
        Combustible combustible2 = new Combustible("Gasolina", 50.0f);
        assertNotEquals(combustible1, combustible2);
    }

    @Test
    public void testHashCode() {
        Combustible combustible1 = new Combustible("Diésel", 50.0f);
        Combustible combustible2 = new Combustible("Diésel", 50.0f);
        assertEquals(combustible1.hashCode(), combustible2.hashCode());
    }

    @Test
    public void testHashCodeDiferente() {
        Combustible combustible1 = new Combustible("Diésel", 50.0f);
        Combustible combustible2 = new Combustible("Gasolina", 50.0f);
        assertNotEquals(combustible1.hashCode(), combustible2.hashCode());
    }
    @Test
    public void testEqualsCombustibleConTiposNulos() {
        Combustible combustible1 = new Combustible(null, 50.0f);
        Combustible combustible2 = new Combustible(null, 50.0f);
        assertEquals(combustible1.getCapacidad(), combustible2.getCapacidad(), 0.001);
    }

    @Test
    public void testEqualsCombustibleConTiposUnoNuloYOtroNo() {
        Combustible combustible1 = new Combustible(null, 50.0f);
        Combustible combustible2 = new Combustible("Diésel", 50.0f);
        assertNull(combustible1.getTipo());
        assertEquals("Diésel", combustible2.getTipo());
        assertEquals(combustible1.getCapacidad(), combustible2.getCapacidad(), 0.001);
    }

    @Test
    public void testEqualsCombustibleTiposDiferentesCapacidadIgual() {
        Combustible combustible1 = new Combustible("Gasolina", 50.0f);
        Combustible combustible2 = new Combustible("Diésel", 50.0f);
        assertNotEquals(combustible1, combustible2);
    }

    @Test
    public void testEqualsCombustibleConCapacidadesDeCero() {
        Combustible combustible1 = new Combustible("Diésel", 0.0f);
        Combustible combustible2 = new Combustible("Diésel", 0.0f);
        assertEquals(combustible1, combustible2);
    }

    @Test
    public void testCombustibleConCapacidadCero() {
        Combustible combustible = new Combustible("Gasolina", 0.0f);
        assertEquals("Gasolina", combustible.getTipo());
        assertEquals(0.0f, combustible.getCapacidad(), 0.001);
    }
    @Test
    public void testEquals() {
        Combustible combustible1 = new Combustible("Gasolina", 50.0f);
        Combustible combustible2 = new Combustible("Gasolina", 50.0f);
        Combustible combustible3 = new Combustible("Diésel", 50.0f);

        assertEquals(combustible1, combustible2); // Deben ser iguales
        assertNotEquals(combustible1, combustible3); // Deben ser diferentes
    }
    @Test
    public void testToString() {
        Combustible combustible = new Combustible("Gasolina", 50.0f);
        String expectedToString = "Combustible(tipo=Gasolina, capacidad=50.0)";
        assertEquals(expectedToString, combustible.toString());
    }
    @Test
    public void testEqualsWithNull() {
        Combustible combustible1 = new Combustible("Gasolina", 50.0f);
        Combustible combustible2 = null;

        assertNotEquals(combustible1, combustible2); // Deben ser diferentes
    }
    @Test
    public void testHashCodeWithNull() {
        Combustible combustible1 = new Combustible("Gasolina", 50.0f);
        Combustible combustible2 = null;
        assertNotNull(combustible1.hashCode());
        assertNull(combustible2);
        assertThrows(NullPointerException.class, () -> {
            combustible2.hashCode();
        });
    }

    @Test
    public void testToStringWithDifferentValues() {
        Combustible combustible = new Combustible("Diésel", 75.5f);

        String expectedToString = "Combustible(tipo=Diésel, capacidad=75.5)";
        assertEquals(expectedToString, combustible.toString());
    }
    @Test
    public void testEqualsMismoTipoYCapacidad() {
        Combustible combustible1 = new Combustible("Gasolina", 50.0f);
        Combustible combustible2 = new Combustible("Gasolina", 50.0f);
        assertTrue(combustible1.equals(combustible2));
    }
    @Test
    public void testEqualsDiferenteTipo() {
        Combustible combustible1 = new Combustible("Gasolina", 50.0f);
        Combustible combustible2 = new Combustible("Diésel", 50.0f);
        assertFalse(combustible1.equals(combustible2));
    }
    @Test
    public void testEqualsDiferenteCapacidad() {
        Combustible combustible1 = new Combustible("Gasolina", 50.0f);
        Combustible combustible2 = new Combustible("Gasolina", 60.0f);
        assertFalse(combustible1.equals(combustible2));
    }
    @Test
    public void testEqualsComparacionNoCombustible() {
        Combustible combustible = new Combustible("Gasolina", 50.0f);
        String otroObjeto = "No es un combustible";
        assertFalse(combustible.equals(otroObjeto));
    }
    @Test
    public void testEqualsComparacionConNull() {
        Combustible combustible = new Combustible("Gasolina", 50.0f);
        assertFalse(combustible.equals(null));
    }
    @Test
    public void testHashCodeMismoTipoYCapacidad() {
        Combustible combustible1 = new Combustible("Gasolina", 50.0f);
        Combustible combustible2 = new Combustible("Gasolina", 50.0f);
        assertEquals(combustible1.hashCode(), combustible2.hashCode());
    }
    @Test
    public void testSetTipo() {
        Combustible combustible = new Combustible("Gasolina", 50.0f);
        combustible.setTipo("Diésel");
        assertEquals("Diésel", combustible.getTipo());
    }
    @Test
    public void testEqualsIguales() {
        Combustible combustible1 = new Combustible("Gasolina", 50.0f);
        Combustible combustible2 = new Combustible("Gasolina", 50.0f);
        assertTrue(combustible1.equals(combustible2));
    }

    @Test
    public void testEqualsDiferentes() {
        Combustible combustible1 = new Combustible("Gasolina", 50.0f);
        Combustible combustible2 = new Combustible("Diésel", 60.0f);
        assertFalse(combustible1.equals(combustible2));
    }



}


