package com.example.ejercicios456.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Laptop {


    // atributos
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String procesador;
    private Integer ram;
    private Double disco_duro;
    private Double bateria;
    private Integer usb;

    // constructores

    public Laptop() {
    }

    public Laptop(Long id, String procesador, Integer ram, Double disco_duro, Double bateria, Integer usb) {
        this.id = id;
        this.procesador = procesador;
        this.ram = ram;
        this.disco_duro = disco_duro;
        this.bateria = bateria;
        this.usb = usb;
    }

//getter y setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Double getDisco_duro() {
        return disco_duro;
    }

    public void setDisco_duro(Double disco_duro) {
        this.disco_duro = disco_duro;
    }

    public Double getBateria() {
        return bateria;
    }

    public void setBateria(Double bateria) {
        this.bateria = bateria;
    }

    public Integer getUsb() {
        return usb;
    }

    public void setUsb(Integer usb) {
        this.usb = usb;
    }
    //To String


    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", procesador='" + procesador + '\'' +
                ", ram=" + ram +
                ", disco_duro=" + disco_duro +
                ", bateria=" + bateria +
                ", usb=" + usb +
                '}';
    }
}
