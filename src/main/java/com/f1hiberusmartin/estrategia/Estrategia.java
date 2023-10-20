package com.f1hiberusmartin.estrategia;

public class Estrategia {
    private Combustible combustible;
    private float combustibleConsumidoPorKmRecorrido;
    private Neumaticos neumaticos;
    private float porcentajeDeVidaDeNeumaticosConsumidoPorKmRecorrido;
    private float kilometrosARecorrer;

    public Estrategia(Combustible combustible, float combustibleConsumidoPorKmRecorrido,
                      Neumaticos neumaticos, float porcentajeDeVidaDeNeumaticosConsumidoPorKmRecorrido,
                      float kilometrosARecorrer) {
        this.combustible = combustible;
        this.combustibleConsumidoPorKmRecorrido = combustibleConsumidoPorKmRecorrido;
        this.neumaticos = neumaticos;
        this.porcentajeDeVidaDeNeumaticosConsumidoPorKmRecorrido = porcentajeDeVidaDeNeumaticosConsumidoPorKmRecorrido;
        this.kilometrosARecorrer = kilometrosARecorrer;
    }

    public boolean esViable() {
        // Lógica para determinar si la estrategia es viable
        float combustibleNecesario = this.kilometrosARecorrer * this.combustibleConsumidoPorKmRecorrido;
        float neumaticosDesgastados = this.kilometrosARecorrer * this.porcentajeDeVidaDeNeumaticosConsumidoPorKmRecorrido;

        return (combustibleNecesario <= this.combustible.getCapacidad()) &&
                (neumaticosDesgastados <= this.neumaticos.getPorcentajeVida());
    }
}

