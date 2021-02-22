package com.example.jwt.service;

import com.example.jwt.entity.Usuario;
import com.example.jwt.model.UsuarioDTO;
import com.example.jwt.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private BillRepository billRepository;

    public ResponseEntity<String> createUser(UsuarioDTO usuarioDTO) {
        billRepository.createUser(usuarioDTO.getFirst_name(), usuarioDTO.getLast_name(), usuarioDTO.getCareer());
        return new ResponseEntity<String>("Usuario criado", HttpStatus.CREATED);
    }

    public ResponseEntity<UsuarioDTO> getById(Long id) {
       Usuario usuario = billRepository.getById(id);
        return new ResponseEntity<UsuarioDTO>(new UsuarioDTO().toDTO(usuario), HttpStatus.OK);
    }

    public ResponseEntity<List<UsuarioDTO>> findAll() {
        List<UsuarioDTO> list = new ArrayList<>();
        billRepository.findAll().forEach(it-> list.add(new UsuarioDTO().toDTO(it)));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
