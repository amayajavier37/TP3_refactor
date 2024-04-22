package oop2.tp3.ejercicio4;

import org.jdbi.v3.core.Jdbi;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        Jdbi jdbi = Jdbi.create("jdbc:hsqldb:mem;create=true");

        new SetUpDatabase(jdbi).setUp();

        var repo = new PersonaRepository(jdbi);
        var personas = repo.buscarPorNombre("José Laurenti");

        if (personas.isPresent()) {
            for (Persona persona : personas.get()) {
                System.out.println(persona.nombre() + " " + persona.apellido());
            }
        }

        var persona = repo.buscarId(1L);
        persona.ifPresent(value -> System.out.println(value.nombre() + " " + value.apellido()));
    }
}
