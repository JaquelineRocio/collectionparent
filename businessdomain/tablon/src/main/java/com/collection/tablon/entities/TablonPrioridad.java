/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.collection.tablon.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.Data;

/**
 *
 * @author JAQUELINE
 */
@Data
@Entity
public class TablonPrioridad {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;  
    private long codPrioridad;
    @Transient
    private String desPrioridad;
    
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Tablon.class)
    @JoinColumn(name ="tablonId", nullable = true)
    private Tablon tablon;
}
