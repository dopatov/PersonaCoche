package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by professor on 11/07/2016.
 */
@Service
public class CocheService {
    @Autowired
    private CocheRepository cocheRepository;

    @Autowired
    private PersonaRepository personaRepository;

    public void testCoches(){



        Coche coche=new Coche();
        coche.setMarca("Alfa Romeo");
        coche.setModelo("145");
        coche.setAño(1996);
        coche.setMatricula("345423G");
        coche.setPrecio(200000.00);
        Persona propietario=personaRepository.findOne(1L);
        coche.setPropietario(propietario);
        cocheRepository.save(coche);

        Coche coche1=new Coche();
        coche1.setMarca("Lamborghini");
        coche1.setModelo("Diablo");
        coche1.setAño(2002);
        coche1.setMatricula("234532B");
        coche1.setPrecio(150000.00);
        Persona propietario1=personaRepository.findOne(1L);
        coche1.setPropietario(propietario1);
        cocheRepository.save(coche1);

        Coche coche2=new Coche();
        coche2.setMarca("Ferrari");
        coche2.setModelo("Testarossa");
        coche2.setAño(2005);
        coche2.setMatricula("892345C");
        coche2.setPrecio(220000.00);
        Persona propietario2=personaRepository.findOne(1L);
        coche2.setPropietario(propietario2);
        cocheRepository.save(coche2);

        Coche coche3=new Coche();
        coche3.setMarca("Ferrari");
        coche3.setModelo("F40");
        coche3.setAño(2005);
        coche3.setMatricula("872364H");
        coche3.setPrecio(155000.00);
        Persona propietario3=personaRepository.findOne(4L);
        coche3.setPropietario(propietario3);
        cocheRepository.save(coche3);

        Coche coche4=new Coche();
        coche4.setMarca("Porche");
        coche4.setModelo("Carrera");
        coche4.setAño(2009);
        coche4.setMatricula("345345B");
        coche4.setPrecio(123000.00);
        Persona propietario4=personaRepository.findOne(5L);
        coche4.setPropietario(propietario4);
        cocheRepository.save(coche4);
        System.out.println("Coches entre los años 2000 y 2006");
        System.out.println(cocheRepository.findByAñoBetween(2000,2006));
        System.out.println("Coches a partir del año 2005");
        System.out.println(cocheRepository.findByAñoGreaterThan(2005));
        System.out.println("Coches con matriculas que contengan 534");
        System.out.println(cocheRepository.getCocheMatriculasQueContengan("534"));
        System.out.println("Clasificacion de coches por año");


        for (Object[] estadisticasAño : cocheRepository.getCochesPorAño()) {

           Integer año =(Integer)estadisticasAño[0];
            System.out.println("Año: " + año);
            System.out.println("numero de coches: " +estadisticasAño[1]);
            System.out.println("Listado de coches: " +cocheRepository.findByAño(año));


        }




    }
}
