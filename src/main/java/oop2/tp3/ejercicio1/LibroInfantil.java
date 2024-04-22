package oop2.tp3.ejercicio1;

public class LibroInfantil extends Libro {
    public LibroInfantil(String nombre, int priceCode) {
        super(nombre);
    }

    @Override
    public double calcularCosto(int diasAlquilados) {
        double monto = 1.5;
        if (diasAlquilados > 3) {monto += (diasAlquilados - 3) * 1.5;
        }
        return  monto;
    }

}