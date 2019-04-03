package com.cristhiancabrera;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String nombre;
    private String apellido;


    public Cliente() {
    }
    public Cliente(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public long getId() {
        return id;
    }



    public String getNombre() {
        return nombre;
    }



    public String getApellido() {
        return apellido;
    }


    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, nombre='%s', apellido='%s']",
                id, nombre, apellido);
    }
}
