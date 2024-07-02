/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.collection.tablon.repositories;

import com.collection.tablon.entities.Tablon;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author JAQUELINE
 */
public interface TablonRepository extends JpaRepository<Tablon, Long> {
    
}
