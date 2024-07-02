/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.collection.rol.repositories;

import com.collection.rol.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author JAQUELINE
 */
public interface RolRepository extends JpaRepository<Rol, Long> {
    
}
