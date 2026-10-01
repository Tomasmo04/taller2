package com.taller.taller2.modelo;

import java.util.List;
import java.util.stream.Collectors;

public class Gerente implements ITrabajarProyecto {
    private String nombre;
    private List<Proyecto> proyectos;

    public Gerente(String nombre, List<Proyecto> proyectos) {
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
        return "Gerente " + nombre + " está gestionando los entregables de: [" + nombres + "]";
    }

    @Override
    public String interrumpir(List<Proyecto> listaProyectos) {
        return "Gerente " + nombre + " detuvo por auditoría presupuestal " + listaProyectos.size() + " proyectos.";
    }

    @Override
    public String documentar(List<Proyecto> listaProyectos) {
        return "Gerente " + nombre + " redactó los informes de avance ejecutivo y cronogramas.";
    }
}