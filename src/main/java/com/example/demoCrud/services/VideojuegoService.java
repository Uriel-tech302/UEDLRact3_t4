package com.example.demoCrud.services;

import com.example.demoCrud.models.Videojuego;
import com.example.demoCrud.repositories.VideojuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VideojuegoService {

    @Autowired
    private VideojuegoRepository videojuegoRepository;

    public List<Videojuego> listarTodos() {
        return videojuegoRepository.findAll();
    }

    public void guardar(Videojuego videojuego) {
        videojuegoRepository.save(videojuego);
    }

    public Videojuego buscarPorId(Long id) {
        return videojuegoRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        videojuegoRepository.deleteById(id);
    }
}