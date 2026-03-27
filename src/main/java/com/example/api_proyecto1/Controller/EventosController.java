package com.example.api_proyecto1.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api_proyecto1.Model.Eventos;
import com.example.api_proyecto1.Repository.EventosRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/eventos")

public class EventosController {

    private final EventosRepository repositorio;

    public EventosController(EventosRepository repo) {
        this.repositorio = repo;
    }

    @GetMapping
    public List<Eventos> getAll() {
        return repositorio.findAll();
    }

    @GetMapping("/{id}")
    public Eventos getById(@PathVariable Integer id) {
        return repositorio.findById(id).orElse(null);
    }

    public String postMethodName(@RequestBody String entity) {
        return entity;
    }

    @PostMapping
    public Eventos create(@RequestBody Eventos eventos) {
        return repositorio.save(eventos);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repositorio.deleteById(id);
    }

    @PutMapping("/{id}")
    public Eventos update(@PathVariable Integer id, @RequestBody Eventos eventos) {
        eventos.setId(id);
        return repositorio.save(eventos);
    }

}
