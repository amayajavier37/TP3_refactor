package oop2.tp3.ejercicio1;

public abstract class Libro {
//    public static final int INFANTILES = 2;
//    public static final int REGULARES = 0;
//    public static final int NUEVO_LANZAMIENTO = 1;
    private String nombre;
    private int codigoPrecio;

    public Libro(String nombre) {
        this.nombre = nombre;
    }

    public String nombre() {
        return nombre;
    }

    public double calcularCosto(int diasAlquilados) {
        return 0;
    }

    public int calcularBonus(int diasAlquildos) {
        return 0;
    }
}