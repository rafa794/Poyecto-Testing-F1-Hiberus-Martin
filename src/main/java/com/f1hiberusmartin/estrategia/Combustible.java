package com.f1hiberusmartin.estrategia;
import lombok.Data;
@Data
public class Combustible {
private String tipo;
private float capacidad;
public Combustible(String tipo, float capacidad) {
    if (tipo != null && !("Gasolina".equals(tipo) || "Diésel".equals(tipo))) throw new IllegalArgumentException("El tipo de combustible debe ser 'Gasolina' o 'Diésel'");
    if (capacidad < 0.0f) throw new IllegalArgumentException("La capacidad no puede ser negativa");
    this.tipo = tipo;
    this.capacidad = capacidad;
}
}
