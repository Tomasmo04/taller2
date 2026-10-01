package com.taller.taller2.controlador;

import com.taller.taller2.modelo.ITrabajarProyecto;
import com.taller.taller2.modelo.Proyecto;
import com.taller.taller2.repositories.TrabajadorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TrabajadorController {

    private final TrabajadorRepository repository;

    public TrabajadorController(TrabajadorRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    // PUNTO 1: Nombres de todas las clases concretas en una sola línea separadas por coma
    @GetMapping("/peticion1")
    public String peticion1(Model model) {
        String nombresSeparadosPorComa = repository.obtenerTodos().stream()
                .map(ITrabajarProyecto::getNombre)
                .collect(Collectors.joining(", "));

        model.addAttribute("resultado", nombresSeparadosPorComa);
        return "peticion1";
    }

    // PUNTO 2: Conteo suma total promedio min y max de las horas estimadas de los proyectos
    @GetMapping("/peticion2")
    public String peticion2(Model model) {
        IntSummaryStatistics estadisticas = repository.obtenerTodos().stream()
                .flatMap(t -> t.getProyectos().stream())
                .mapToInt(Proyecto::getHorasEstimadas)
                .summaryStatistics();

        model.addAttribute("conteo", estadisticas.getCount());
        model.addAttribute("suma", estadisticas.getSum());
        model.addAttribute("promedio", String.format("%.2f", estadisticas.getAverage()));
        model.addAttribute("minimo", estadisticas.getMin());
        model.addAttribute("maximo", estadisticas.getMax());

        return "peticion2";
    }

    // PUNTO 3: Obtener lista total de proyectos y extraer una lista con un atributo String
    @GetMapping("/peticion3")
    public String peticion3(Model model) {
        List<Proyecto> todosLosProyectos = repository.obtenerTodos().stream()
                .flatMap(t -> t.getProyectos().stream())
                .toList();

        List<String> nombresDeProyectos = todosLosProyectos.stream()
                .map(Proyecto::getNombre)
                .toList();

        model.addAttribute("totalProyectos", todosLosProyectos.size());
        model.addAttribute("nombresProyectos", nombresDeProyectos);
        return "peticion3";
    }

    // PUNTO 4: anyMatch() x2 y noneMatch() x1
    @GetMapping("/peticion4")
    public String peticion4(Model model) {
        List<Proyecto> listaPlana = repository.obtenerTodos().stream()
                .flatMap(t -> t.getProyectos().stream())
                .toList();

        // 1. anyMatch: ¿Existe algún proyecto con más de 200 horas estimadas?
        boolean existeMayor200Horas = listaPlana.stream()
                .anyMatch(p -> p.getHorasEstimadas() > 200);

        // 2. anyMatch: ¿Existe algún proyecto con estado Completado?
        boolean existeCompletado = listaPlana.stream()
                .anyMatch(p -> "Completado".equalsIgnoreCase(p.getEstado()));

        // 3. noneMatch: ¿Ningún proyecto tiene horas estimadas negativas o en cero?
        boolean ningunoConHorasNegativas = listaPlana.stream()
                .noneMatch(p -> p.getHorasEstimadas() <= 0);

        model.addAttribute("condicion1", existeMayor200Horas);
        model.addAttribute("condicion2", existeCompletado);
        model.addAttribute("condicion3", ningunoConHorasNegativas);
        return "peticion4";
    }

    // PUNTO 5: Mostrar el objeto que tiene el mayor valor del dato numérico Integer
    @GetMapping("/peticion5")
    public String peticion5(Model model) {
        Proyecto proyectoConMasHoras = repository.obtenerTodos().stream()
                .flatMap(t -> t.getProyectos().stream())
                .max(Comparator.comparingInt(Proyecto::getHorasEstimadas))
                .orElse(null);

        model.addAttribute("proyectoMax", proyectoConMasHoras);
        return "peticion5";
    }
}