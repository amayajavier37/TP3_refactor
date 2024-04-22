package oop2.tp3.ejercicio3;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestEjercicio3 {

    @Test
    public void TestCalcularCosto() {
        var gasto1 = new Desayuno();
        gasto1.monto = 1000;
        var reporte = new ReporteDeGastos();
        //cambiar que la fecha tiene que ser una variable para que no cause problemas
        var texto = "Expenses 2024-04-22\r\nDESAYUNO\t1000\t \r\nGastos de comida: 1000\r\nTotal de gastos: 1000\r\n";
        Assertions.assertEquals(reporte.imprimir(List.of(gasto1)), texto);

    }

    @Test
    public void TestCompararReporte() {
        var gasto1 = new Desayuno();
        var gasto2 = new Cena();
        var gasto3 = new AlquilerAuto();
        gasto2.monto = 2000;
        gasto1.monto = 1000;
        gasto3.monto = 5000;
        var reporte = new ReporteDeGastos();
//cambiar que la fecha tiene que ser una variable para que no cause problemas
        var texto = "Expenses 2024-04-22\r\nDESAYUNO\t1000\t \r\nCENA\t2000\tX\r\nALQUILER-AUTO\t5000\t \r\nGastos de comida: 3000\r\nTotal de gastos: 8000\r\n";
        Assertions.assertEquals(reporte.imprimir(List.of(gasto1, gasto2, gasto3)), texto);

    }
}