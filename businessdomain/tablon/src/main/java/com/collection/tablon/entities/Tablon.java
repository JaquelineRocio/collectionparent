/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.collection.tablon.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import lombok.Data;

/**
 *
 * @author JAQUELINE
 */
@Data
@Entity
@Table(name = "\"user\"")
public class Tablon {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long idTablon;
    private String nroCuenta;
    private String mesCastigo;
    private String rangoCampaña;
    private Date fechaAsignacion;
    private String p6m;
    private String p5m;
    private String p4m;
    private String p3m;
    private String p2m;
    private String p1m;
    private BigDecimal intTotal;
    private BigDecimal pdp;
    private BigDecimal pdpAcido;
    private BigDecimal pdpPago;
    private BigDecimal intAgente;
    private BigDecimal intCtc;
    private BigDecimal intCd;

    private BigDecimal deudaCapital;
    private BigDecimal deudaTotal;
    private BigDecimal campaña;

    private String maduracion;
    private BigDecimal totalPago;
    private Integer nroPagos;
    private Integer edad;
    private String rangoEdad;
    private String macroRegiones;
    private String estadoCuenta;
    private String ctc;
    private String flagCob;
    private String phoneCdh;
    private String cdh;
    private String cd;
    private String tc;
    private String eficiencia;
    private BigDecimal ticketPagos;
    private BigDecimal ticketCapital;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tablon", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TablonPrioridad> prioridades;
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "tablon", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TablonCartera> carteras;
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "tablon", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TablonMoneda> monedas;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tablon", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TablonProducto> productos;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tablon", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TablonEntidad> entidades;



}
