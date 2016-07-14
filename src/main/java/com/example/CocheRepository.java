package com.example;

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;
import java.util.Objects;
//Hacer una query que devuelva topdos los coches de un propietario especifico cuyo precio sea igual o superior al especificado
//hacer una query con todos los parametros anteriores y añadir un rango de años
//Todos los coches de las personas mayores de una edad especificada
//Todos los coches de las personas entre un rango de edades especificado
//Todos los coches cuya matricula contenga un string determinado
//El precio medio y el precio maximo de cada marca
//Hacer una query que ordene los coches por año y muestre los coches fabricados ese año

public interface CocheRepository extends JpaRepository<Coche,Long> {

    List<Coche> findByAño(Integer año);
    List<Coche> findByAñoGreaterThanEqual(Integer año);
    List<Coche> findByAñoGreaterThan(Integer año);
    List<Coche> findByAñoBetween (Integer añoStart,Integer añoFin);
    List<Coche> findByPrecioGreaterThanEqual(Double precio);
    List<Coche> findByPrecioGreaterThan (Double precio);
    List<Coche> findByPrecioBetween (Double precioStart, Double precioFin);
    Coche findByMatricula(String matricula);
    List<Coche> findByMarca (String marca);
    List<Coche> findByMarcaAndModelo(String marca, String modelo);
    List<Coche> findByMarcaAndPrecioLessThanEqual(String marca,Double precio);
    List<Coche> findByMarcaAndModeloAndPrecio(String marca,String model,Double precio);
    List<Coche> findByPropietarioAndPrecioGreaterThanEqual(Persona propietario, Double precio);
    List<Coche> findByPropietarioAndPrecioGreaterThanEqualAndAñoBetween(Persona propietario, Double precio, Integer añoInic, Integer añoFin);

    @Query ("SELECT AVG(c.precio)FROM Coche c WHERE c.marca= :marca")
    Double mediaPorMarca(@Param("marca") String marca);

    @Query ("SELECT(p)FROM Coche p WHERE p.propietario= :persona ")
    List<Coche> cochesDeUnMismoPropietario(@Param("persona")Persona propietario);

    @Query ("SELECT(car)FROM Coche car WHERE car.propietario.edad>:edad")
    List<Coche> cochesDePersonasMayoresDe(@Param("edad")Integer edad);

    @Query ("SELECT (co.precio)FROM Coche co WHERE co.propietario.edad>:edadInic AND co.propietario.edad<:edadFinal")
    List<Double> cochesPersonasEdadEntre(@Param("edadInic") Integer edadInic, @Param("edadFinal") Integer edadFinal);

    @Query ("SELECT (ch)FROM Coche ch WHERE ch.matricula LIKE(CONCAT('%',:fragmentoMatricula,'%'))")
    List<Coche> getCocheMatriculasQueContengan(@Param ("fragmentoMatricula") String fragmentoMatricula);

    @Query("SELECT(car.marca), AVG(car.precio),MAX (car.precio), MIN (car.precio) FROM Coche car GROUP BY car.marca")
    List<Object[]> getCochesMediaPrecioMaxPrecioMinByMarca();

   @Query("SELECT coche.año, COUNT (coche) FROM Coche AS coche GROUP BY coche.año")
    List<Object[]> getCochesPorAño();

}
