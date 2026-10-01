package com.taller.taller2.modelo;

import java.util.List;
import java.util.stream.Collectors;

public class Desarrollador implements ITrabajarProyecto {
    private String nombre;
    private List<Proyecto> proyectos;

    public Desarrollador(String nombre, List<Proyecto> proyectos) {
        this.nombre = nombre;
        this.proyectos = proyectos;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public List<Proyecto> getProyectos() {
        return this.proyectos;
    }

    @Override
    public String realizar(List<Proyecto> listaProyectos) {
        String nombres = listaProyectos.stream()
                .map(Proyecto::getNombre)
                .collect(Collectors.joining(", "));
        return "Desarrollador " + nombre + " está codificando los proyectos: [" + nombres + "]";
    }

    @Override
    public String interrumpir(List<Proyecto> listaProyectos) {
        return "Desarrollador " + nombre + " pausó el desarrollo de " + listaProyectos.size() + " proyectos.";
    }

    @Override
    public String documentar(List<Proyecto> listaProyectos) {
        return "Desarrollador " + nombre + " documentó la arquitectura técnica de sus proyectos asignados.";
    }
}