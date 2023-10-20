package com.f1hiberusmartin.estrategia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class EstrategiaTest {

    private Combustible combustible;
    private Neumaticos neumaticos;
    private List<Neumaticos> neumaticosList;
    private Estrategia estrategia;

    @BeforeEach
    public void setUp() {
        combustible = new Combustible("Gasolina", 500.0f); // Mayor capacidad de combustible
        neumaticos = new Neumaticos("Pirelli", 80.0f); // Porcentaje de vida inicial más alto
        neumaticosList = Arrays.asList(neumaticos, neumaticos, neumaticos);
        estrategia = new Estrategia(combustible, 0.1f, neumaticosList, 1000.0f); // Mayor distancia a recorrer
    }

    @Test
    public void esViableConValoresViablesDeberiaRetornarTrue() {
        assertTrue(estrategia.esViable());
    }

    @Test
    public void esViableConPorcentajeDeVidaCeroDeberiaRetornarFalse() {
        neumaticos.setPorcentajeVida(0.0f);
        assertFalse(estrategia.esViable());
    }

    @Test
    public void esViableConNeumaticosDistintosDeberiaRetornarTrue() {
        Neumaticos otroNeumatico = new Neumaticos("Pirelli", 80.0f);
        neumaticosList.set(1, otroNeumatico);
        assertTrue(estrategia.esViable());
    }
    @Test
    public void esViableConCombustibleInsuficienteDeberiaRetornarFalse() {
        combustible.setCapacidad(50.0f); // Capacidad insuficiente para el viaje
        assertFalse(estrategia.esViable());
    }

    @Test
    public void esViableConKilometrosCeroDeberiaRetornarTrue() {
        estrategia.setKilometrosARecorrer(0.0f); // No se necesita combustible para recorrer 0 km
        assertTrue(estrategia.esViable());
    }

    @Test
    public void esViableConNeumaticosNulosDeberiaRetornarFalse() {
        Neumaticos neumaticosNulos = new Neumaticos("Pirelli", 0.0f);
        neumaticosList.set(0, neumaticosNulos);
        assertFalse(estrategia.esViable());
    }

    @Test
    public void esViableConCombustibleSuficienteYNeumaticosCasiAgotadosDeberiaRetornarTrue() {
        neumaticos.setPorcentajeVida(5.0f); // Neumáticos casi agotados pero suficiente combustible
        assertTrue(estrategia.esViable());
    }
    @Test
    public void esViableConCombustibleNuloDeberiaRetornarFalse() {
        estrategia.setCombustible(null);
        assertFalse(estrategia.esViable());
    }

    @Test
    public void esViableConNeumaticosSinPorcentajeVidaDeberiaRetornarFalse() {
        neumaticos.setPorcentajeVida(0.0f);
        assertFalse(estrategia.esViable());
    }

    @Test
    public void esViableConKilometrosNegativosDeberiaRetornarFalse() {
        estrategia.setKilometrosARecorrer(-100.0f);
        assertFalse(estrategia.esViable());
    }
    @Test
    public void esViableConAlMenosUnNeumaticoConVidaDeberiaRetornarTrue() {
        // Configura un neumático con porcentaje de vida igual a cero
        neumaticos.setPorcentajeVida(0.0f);
        // Debería retornar true porque al menos uno de los neumáticos tiene vida suficiente
        assertFalse(estrategia.esViable());
    }
    @Test
    public void testSetCombustibleConsumidoPorKmRecorrido() {
        Estrategia estrategia = new Estrategia(null, 0.0f, null, 0.0f);
        estrategia.setCombustibleConsumidoPorKmRecorrido(0.05f);
        assertEquals(0.05f, estrategia.getCombustibleConsumidoPorKmRecorrido(), 0.001);
    }
    @Test
    public void testGetCombustible() {
        Combustible combustible = new Combustible("Gasolina", 50.0f);
        Estrategia estrategia = new Estrategia(combustible, 0.0f, null, 0.0f);
        assertEquals(combustible, estrategia.getCombustible());
    }
    @Test
    public void testGetCombustibleConsumidoPorKmRecorrido() {
        Estrategia estrategia = new Estrategia(null, 0.1f, null, 0.0f);
        assertEquals(0.1f, estrategia.getCombustibleConsumidoPorKmRecorrido(), 0.001);
    }
    @Test
    public void testGetNeumaticos() {
        List<Neumaticos> neumaticosList = Arrays.asList(new Neumaticos("Pirelli", 80.0f), new Neumaticos("Bridgestone", 90.0f));
        Estrategia estrategia = new Estrategia(null, 0.0f, neumaticosList, 0.0f);
        assertEquals(neumaticosList, estrategia.getNeumaticos());
    }
    @Test
    public void testGetKilometrosARecorrer() {
        Estrategia estrategia = new Estrategia(null, 0.0f, null, 100.0f);
        assertEquals(100.0f, estrategia.getKilometrosARecorrer(), 0.001);
    }





}
