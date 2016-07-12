package com.example;

import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CocheRepository extends JpaRepository<Coche,Long> {

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

    @Query ("SELECT AVG(c.precio)from Coche c where c.marca= :marca")
    Double mediaPorMarca(@Param("marca") String marca);
}
