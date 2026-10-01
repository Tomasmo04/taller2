package com.taller.taller2.modelo;

public class Proyecto {
    private String id;
    private String nombre;
    private Integer horasEstimadas;
    private String estado;

    public Proyecto(String id, String nombre, Integer horasEstimadas, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.horasEstimadas = horasEstimadas;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getHorasEstimadas() {
        return horasEstimadas;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", horasEstimadas=" + horasEstimadas +
                ", estado='" + estado + '\'' +
                '}';
    }
}