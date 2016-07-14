package com.example;

import javax.persistence.*;

/**
 * Created by professor on 11/07/2016.
 */
@Entity
public class Coche {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String modelo;
    private String marca;
    private Integer año;
    private Double precio;
    private String matricula;
    @ManyToOne
    private Persona propietario;

    public Persona getPropietario() {
        return propietario;
    }

    public void setPropietario(Persona propietario) {
        this.propietario = propietario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getAño() {
        return año;
    }

    public void setAño(Integer año) {
        this.año = año;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coche coche = (Coche) o;

        if (getId() != null ? !getId().equals(coche.getId()) : coche.getId() != null) return false;
        if (getModelo() != null ? !getModelo().equals(coche.getModelo()) : coche.getModelo() != null) return false;
        if (getMarca() != null ? !getMarca().equals(coche.getMarca()) : coche.getMarca() != null) return false;
        if (getAño() != null ? !getAño().equals(coche.getAño()) : coche.getAño() != null) return false;
        if (getPrecio() != null ? !getPrecio().equals(coche.getPrecio()) : coche.getPrecio() != null) return false;
        return getMatricula() != null ? getMatricula().equals(coche.getMatricula()) : coche.getMatricula() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getModelo() != null ? getModelo().hashCode() : 0);
        result = 31 * result + (getMarca() != null ? getMarca().hashCode() : 0);
        result = 31 * result + (getAño() != null ? getAño().hashCode() : 0);
        result = 31 * result + (getPrecio() != null ? getPrecio().hashCode() : 0);
        result = 31 * result + (getMatricula() != null ? getMatricula().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "id=" + id +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", año=" + año +
                ", precio=" + precio +
                ", matricula='" + matricula + '\'' +
                '}';
    }
}
