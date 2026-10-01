package com.taller.taller2.repositories;

import com.taller.taller2.modelo.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TrabajadorRepository {

    private final List<ITrabajarProyecto> trabajadores = new ArrayList<>();

    public TrabajadorRepository() {

        Proyecto p1 = new Proyecto("P01", "App Móvil de Pagos", 120, "En progreso");
        Proyecto p2 = new Proyecto("P02", "Plataforma Web E-commerce", 250, "Completado");
        Proyecto p3 = new Proyecto("P03", "Migración a la Nube AWS", 80, "En progreso");
        Proyecto p4 = new Proyecto("P04", "Rediseño de Portal Institucional", 160, "Revision");
        Proyecto p5 = new Proyecto("P05", "API Gateway Microservicios", 300, "En progreso");
        Proyecto p6 = new Proyecto("P06", "Sistema de Facturación Electrónica", 210, "Completado");
        Proyecto p7 = new Proyecto("P07", "Dashboard Financiero", 95, "Revision");
        Proyecto p8 = new Proyecto("P08", "Integración Pasarela Stripe", 140, "En progreso");
        Proyecto p9 = new Proyecto("P09", "Optimización Base de Datos", 180, "Completado");
        Proyecto p10 = new Proyecto("P10", "Chatbot de Soporte", 110, "En progreso");


        trabajadores.add(new Desarrollador("Carlos Pérez (Dev)", List.of()));
        trabajadores.add(new Disenador("Laura Gómez (UI)", List.of()));


        trabajadores.add(new Gerente("Andrés Castro (PM)", List.of(p1)));
        trabajadores.add(new Desarrollador("Sofía Ruiz (Dev)", List.of(p2)));


        trabajadores.add(new Disenador("Mateo Restrepo (UI)", List.of(p3, p4)));
        trabajadores.add(new Gerente("Valeria Torres (PM)", List.of(p5, p6)));


        trabajadores.add(new Desarrollador("David Herrera (Dev)", List.of(p7, p8, p9)));
        trabajadores.add(new Disenador("Camila Marín (UI)", List.of(p1, p2, p3)));


        trabajadores.add(new Gerente("Felipe Jaramillo (PM)", List.of(p4, p5, p6, p7)));
        trabajadores.add(new Desarrollador("Mariana López (Dev)", List.of(p2, p3, p8, p10)));


        trabajadores.add(new Disenador("Santiago Morales (UI)", List.of(p1, p4, p5, p9, p10)));
        trabajadores.add(new Gerente("Elena Vargas (PM)", List.of(p3, p6, p7, p8, p10)));
    }

    public List<ITrabajarProyecto> obtenerTodos() {
        return this.trabajadores;
    }
}