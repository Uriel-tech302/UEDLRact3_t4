package com.example.demoCrud.controllers;
import com.example.demoCrud.models.Videojuego;
import com.example.demoCrud.services.DesarrolladorService;
import com.example.demoCrud.services.VideojuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/videojuegos")
public class VideojuegoController {

    @Autowired
    private VideojuegoService videojuegoService;

    @Autowired
    private DesarrolladorService desarrolladorService;

    // 1. Leer todos (Muestra la tabla)
    @GetMapping
    public String listarVideojuegos(Model model) {
        model.addAttribute("videojuegos", videojuegoService.listarTodos());
        return "lista"; // Nombre del archivo HTML
    }

    // 2. Formulario para Crear
    @GetMapping("/nuevo")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("videojuego", new Videojuego());
        model.addAttribute("desarrolladores", desarrolladorService.listarTodos());
        return "formulario"; // Nombre del archivo HTML
    }

    // 3. Guardar (Se usa para Crear y Actualizar)
    @PostMapping("/guardar")
    public String guardarVideojuego(@ModelAttribute("videojuego") Videojuego videojuego) {
        videojuegoService.guardar(videojuego);
        return "redirect:/videojuegos";
    }

    // 4. Formulario para Actualizar
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        model.addAttribute("videojuego", videojuegoService.buscarPorId(id));
        model.addAttribute("desarrolladores", desarrolladorService.listarTodos());
        return "formulario";
    }

    // 5. Eliminar
    @GetMapping("/eliminar/{id}")
    public String eliminarVideojuego(@PathVariable Long id) {
        videojuegoService.eliminar(id);
        return "redirect:/videojuegos";
    }
}