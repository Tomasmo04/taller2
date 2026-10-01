package com.taller.taller2.modelo;

import java.util.List;

public interface ITrabajarProyecto extends IRealizar, IInterrumpir, IDocumentar {
    String getNombre();
    List<Proyecto> getProyectos();
}