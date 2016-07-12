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

    public void testCoches(){

        Coche coche=new Coche();
        coche.setMarca("Alfa Romeo");
        coche.setModelo("145");
        coche.setAño(1996);
        coche.setMatricula("345423G");
        coche.setPrecio(200000.00);
        cocheRepository.save(coche);

        Coche coche1=new Coche();
        coche1.setMarca("Lamborghini");
        coche1.setModelo("Diablo");
        coche1.setAño(2002);
        coche1.setMatricula("234532B");
        coche1.setPrecio(150000.00);
        cocheRepository.save(coche1);

        Coche coche2=new Coche();
        coche2.setMarca("Ferrari");
        coche2.setModelo("Testarossa");
        coche2.setAño(2005);
        coche2.setMatricula("892345C");
        coche2.setPrecio(220000.00);
        cocheRepository.save(coche2);

        Coche coche3=new Coche();
        coche3.setMarca("Ferrari");
        coche3.setModelo("F40");
        coche3.setAño(2008);
        coche3.setMatricula("872364H");
        coche3.setPrecio(155000.00);
        cocheRepository.save(coche3);

        Coche coche4=new Coche();
        coche4.setMarca("Porche");
        coche4.setModelo("Carrera");
        coche4.setAño(2009);
        coche4.setMatricula("345345B");
        coche4.setPrecio(123000.00);
        cocheRepository.save(coche4);

        System.out.println(cocheRepository.findByAñoBetween(2000,2006));
        System.out.println(cocheRepository.findByAñoGreaterThan(2005));




    }
}
