package com.f1hiberusmartin.estrategia;
import lombok.Getter;
import lombok.Setter;
public class Neumaticos {
@Getter @Setter private String marca;
@Getter private float porcentajeVida;
public Neumaticos(String marca, Float porcentajeVida) {
    if (!"Pirelli".equals(marca) && !"Bridgestone".equals(marca)) throw new IllegalArgumentException("La marca de neumáticos debe ser 'Pirelli' o 'Bridgestone'");
    if (porcentajeVida == null) this.porcentajeVida = 0.0f;
    else if (porcentajeVida < 0.0f) throw new IllegalArgumentException("El porcentaje de vida no puede ser negativo");
    else this.porcentajeVida = porcentajeVida;
    this.marca = marca;
}
public void setPorcentajeVida(float porcentajeVida) {
    if (porcentajeVida < 0.0f) throw new IllegalArgumentException("El porcentaje de vida no puede ser negativo");
    this.porcentajeVida = porcentajeVida;
}
}
