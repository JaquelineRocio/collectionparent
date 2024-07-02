/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.collection.prioridad.repositories;

import com.collection.prioridad.entities.Prioridad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author JAQUELINE
 */
public interface UserRepository extends JpaRepository<Prioridad, Long> {
    
    @Query("SELECT u FROM User u WHERE u.lastName = :lastName")
    public Prioridad findByLastName(@Param("lastName") String lastName);
}
