package com.example.demoCrud.services;

import com.example.demoCrud.models.Desarrollador;
import com.example.demoCrud.repositories.DesarrolladorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DesarrolladorService {

    @Autowired
    private DesarrolladorRepository desarrolladorRepository;

    public List<Desarrollador> listarTodos() {
        return desarrolladorRepository.findAll();
    }

    public void guardar(Desarrollador desarrollador) {
        desarrolladorRepository.save(desarrollador);
    }
}