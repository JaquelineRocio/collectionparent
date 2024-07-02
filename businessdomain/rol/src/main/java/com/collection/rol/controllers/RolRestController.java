/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.collection.rol.controllers;

import com.collection.rol.entities.Rol;
import com.collection.rol.repositories.RolRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author JAQUELINE
 */
@RestController
@RequestMapping("/rol")
public class RolRestController {
    
    @Autowired
    RolRepository rolRepository;
    
    @GetMapping()
    public List<Rol> list() {
        return rolRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable(name = "id") long id) {
        Optional<Rol> optionalRol = rolRepository.findById(id);
        if(optionalRol.isPresent())
        {   Rol rol=optionalRol.get();
            return new ResponseEntity<>(rol, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable(name = "id") long id, @RequestBody Rol input) {
        Optional<Rol> optionalRol = rolRepository.findById(id);
        if(optionalRol.isPresent())
        {
            Rol modifyRol = optionalRol.get();
            modifyRol.setName(input.getName());
            Rol saveRol = rolRepository.save(modifyRol);
            return new ResponseEntity<>(saveRol, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Rol input) {
        Rol saveRol = rolRepository.save(input);
        return ResponseEntity.ok(saveRol);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id) {
        Optional<Rol> optionalRol = rolRepository.findById(id);
        if(optionalRol.get() != null)
        {
            rolRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
}
