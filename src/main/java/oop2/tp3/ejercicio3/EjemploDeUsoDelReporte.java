package oop2.tp3.ejercicio3;

import java.util.List;

public class EjemploDeUsoDelReporte {
    public static void main(String[] args) {
        var g1 = new Desayuno();
        g1.monto =1000;
        var reporte = new ReporteDeGastos();
        reporte.imprimir(List.of(g1));
    }
}
