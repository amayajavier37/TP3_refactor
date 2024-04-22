package oop2.tp3.ejercicio1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public class TestEjercicio1 {

    @Test
    public void TestCalculoDePago(){
        Libro elTunel = new LibroRegular("El Túnel");
        CopiaLibro elTunelCopia = new CopiaLibro(elTunel);
        Alquiler alquilerElTunel = new Alquiler(elTunelCopia, 5);

        Cliente javier = new Cliente("Javier");
        javier.alquilar(alquilerElTunel);

        var resultado = javier.calcularDeudaYPuntosObtenidos();
        Assertions.assertEquals(resultado[0],6.5);
    }
}