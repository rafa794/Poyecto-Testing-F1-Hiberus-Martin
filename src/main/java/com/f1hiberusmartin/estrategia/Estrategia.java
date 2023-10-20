package com.f1hiberusmartin.estrategia;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
@AllArgsConstructor
public class Estrategia {
@Getter @Setter private Combustible combustible;
@Getter @Setter private float combustibleConsumidoPorKmRecorrido;
@Getter private List<Neumaticos> neumaticos;
@Getter @Setter private float kilometrosARecorrer;
public boolean esViable() {
    return combustible != null && neumaticos != null && kilometrosARecorrer >= 0 && neumaticos.stream().allMatch(this::neumaticoValido) && combustible.getCapacidad() >= (kilometrosARecorrer * combustibleConsumidoPorKmRecorrido);
}
private boolean neumaticoValido(Neumaticos neumatico) {
    return neumatico != null && neumatico.getPorcentajeVida() > 0.0f;
}
}
