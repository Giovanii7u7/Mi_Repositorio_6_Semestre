package com.example.model;
public class BeanCiclico {

    private double cantidad;
    private int plazo;

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public double[] calcularPagosMensuales() {
        if (plazo > 12) {
            throw new IllegalArgumentException("Plazo debe ser menor o igual a 12 meses.");
        }

        double[] pagos = new double[plazo];
        double pagoMensual = cantidad / plazo;

        for (int i = 0; i < plazo; i++) {
            pagos[i] = pagoMensual;
        }

        return pagos;
    }
}

