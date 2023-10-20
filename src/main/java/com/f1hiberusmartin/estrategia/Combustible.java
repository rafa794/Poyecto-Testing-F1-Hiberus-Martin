package com.f1hiberusmartin.estrategia;
import lombok.Getter;
import lombok.Setter;

public class Combustible {
    private CombustibleComplemento complemento;

    @Getter @Setter private String tipo;
    @Getter @Setter private float capacidad;

    public Combustible(String tipo, float capacidad) {
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.complemento = new CombustibleComplemento();
    }

    public boolean validarCombustible() {
        return complemento.validarTipo(tipo) && complemento.validarCapacidad(capacidad);
    }
}
