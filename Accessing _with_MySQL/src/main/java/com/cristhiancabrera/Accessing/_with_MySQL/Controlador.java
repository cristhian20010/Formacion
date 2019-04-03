package com.cristhiancabrera.Accessing._with_MySQL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/demo")

public class Controlador {

    @Autowired

    private RepositorioUsuario repositorioUsuario;

    @GetMapping(path="/add")

    public @ResponseBody
    String addNuevoUsuario (@RequestParam String nombre, @RequestParam String email )
     {
        // @ResponseBody significa que la cadena devuelta es la respuesta, no un nombre de vista
        // @RequestParam significa que es un parámetro de la solicitud GET o POST

        Usuario n = new Usuario();


        n.setNombre(nombre);
        n.setEmail(email);
        repositorioUsuario.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Usuario> getAllUsers() {
        // This returns a JSON or XML with the users
        return repositorioUsuario.findAll();
    }
}
