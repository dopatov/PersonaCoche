package com.example;

import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by professor on 20/06/2016.
 */
@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    public void testPersonas(){

        Persona persona = new Persona();
        persona.setNombre("Ivan");
        persona.setEdad(23);
        persona.setApellido("Lopez");
        personaRepository.save(persona);

        Persona persona2 = new Persona();
        persona2.setNombre("Dimple");
        persona2.setEdad(26);
        personaRepository.save(persona2);

        Persona persona3 = new Persona();
        persona3.setNombre( "Noelia");
        persona3.setApellido("Villa");
        persona3.setEdad(25);
        personaRepository.save(persona3);

        Persona persona4 = new Persona();
        persona4.setNombre("Jordi");
        persona4.setEdad(25);
        personaRepository.save(persona4);

        Persona persona5 = new Persona();
        persona5.setNombre("Ricard");
        persona5.setEdad(25);
        personaRepository.save(persona5);

        System.out.println("Persona con ID 2");
        System.out.println(personaRepository.findOne(2L));
        System.out.println("Persona con nombre Noelia");
        System.out.println(personaRepository.findByNombre("Noelia"));
        System.out.println("Personas mayores de 25");
        System.out.println(personaRepository.findByEdadGreaterThanEqual(25));
        System.out.println("Personas con nombre Noelia y apellido Villa");
        System.out.println(personaRepository.findByNombreAndApellido("Noelia","Villa"));




    }
}
