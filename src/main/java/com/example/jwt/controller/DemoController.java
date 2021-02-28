package com.example.jwt.controller;

import com.example.jwt.model.CardsDTO;
import com.example.jwt.model.UsuarioDTO;
import com.example.jwt.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DemoController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public ResponseEntity<List<UsuarioDTO>> index() {
        return usuarioService.findAll();
    }

    @GetMapping("/id")
    public ResponseEntity<UsuarioDTO> index(@RequestHeader Long id) {
        return usuarioService.getById(id);
    }

    @PostMapping("/user")
    @ResponseBody
    public ResponseEntity<String> createUser(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.createUser(usuarioDTO);
    }

    @PostMapping("/card")
    @ResponseBody
    public ResponseEntity<String> createCard(@RequestBody CardsDTO cardsDTO) {
        return usuarioService.createCard(cardsDTO);
    }

}
