package oop2.tp3.ejercicio3;

import java.time.LocalDate;
import java.util.List;


public class ReporteDeGastos {
    public String imprimir(List<Gasto> gastos) {
        int total = 0;
        int gastosDeComida = 0;
        String reporte="";

        reporte+= "Expenses " + LocalDate.now() + System.lineSeparator();
        for (Gasto gasto : gastos) {
            if (esComida(gasto)) {
                gastosDeComida += gasto.monto;
            }
            String nombreGasto = gasto.TIPO;
            String marcaExcesoComidas = marcaExesoDeComida(gasto);
            reporte+=nombreGasto + "\t" + gasto.monto + "\t" + marcaExcesoComidas + System.lineSeparator();
            total += gasto.monto;
        }

        reporte+="Gastos de comida: " + gastosDeComida + System.lineSeparator();
        reporte+="Total de gastos: " + total + System.lineSeparator();
        return  reporte;
    }

    private static boolean esComida(Gasto gasto) {
        return gasto.TIPO == "CENA" || gasto.TIPO == "DESAYUNO";
    }
    private String marcaExesoDeComida (Gasto gasto) {
        if (esComida(gasto) && gasto.monto > 5000
                || esComida(gasto) && gasto.monto > 1000) {
            return "X";
        }
        return " ";
    }


}
