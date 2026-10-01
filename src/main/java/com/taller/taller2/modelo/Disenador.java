package com.taller.taller2.modelo;

import java.util.List;
import java.util.stream.Collectors;

public class Disenador implements ITrabajarProyecto {
    private String nombre;
    private List<Proyecto> proyectos;

    public Disenador(String nombre, List<Proyecto> proyectos) {
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
        return "Diseñador " + nombre + " está diseñando las interfaces para: [" + nombres + "]";
    }

    @Override
    public String interrumpir(List<Proyecto> listaProyectos) {
        return "Diseñador " + nombre + " congeló los prototipos UI/UX de " + listaProyectos.size() + " proyectos.";
    }

    @Override
    public String documentar(List<Proyecto> listaProyectos) {
        return "Diseñador " + nombre + " generó la guía de estilos y componentes para sus proyectos.";
    }
}