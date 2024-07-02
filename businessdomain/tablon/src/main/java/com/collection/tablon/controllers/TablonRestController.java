/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.collection.tablon.controllers;

import com.collection.tablon.entities.Tablon;
import com.collection.tablon.entities.TablonPrioridad;
import com.fasterxml.jackson.databind.JsonNode;
import io.netty.channel.ChannelOption;
import io.netty.channel.epoll.EpollChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import java.time.Duration;
import java.util.Collections;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import com.collection.tablon.repositories.TablonRepository;

/**
 *
 * @author JAQUELINE
 */
@RestController
@RequestMapping("/tablon")
public class TablonRestController {

    @Autowired
    TablonRepository tablonRepository;

    private final WebClient.Builder webClientBuilder;

    public TablonRestController(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }
    HttpClient client = HttpClient.create()
            //Connection Timeout: is a period within which a connection between a client and a server must be established
            .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
            .option(ChannelOption.SO_KEEPALIVE, true)
            .option(EpollChannelOption.TCP_KEEPIDLE, 300)
            .option(EpollChannelOption.TCP_KEEPINTVL, 60)
            //Response Timeout: The maximun time we wait to receive a response after sending a request
            .responseTimeout(Duration.ofSeconds(1))
            // Read and Write Timeout: A read timeout occurs when no data was read within a certain 
            //period of time, while the write timeout when a write operation cannot finish at a specific time
            .doOnConnected(connection -> {
                connection.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS));
                connection.addHandlerLast(new WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS));
            });

    @GetMapping()
    public List<Tablon> list() {
        return tablonRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable(name = "id") Long id) {
        Optional<Tablon> optionalTablon = tablonRepository.findById(id);
        if (optionalTablon.isPresent()) {
            return new ResponseEntity<>(optionalTablon.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping
    public ResponseEntity<?> post(@RequestBody Tablon input) {
        input.getCarteras().forEach(cartera -> cartera.setTablon(input));
        input.getPrioridades().forEach(prioridad -> prioridad.setTablon(input));
        input.getMonedas().forEach(moneda -> moneda.setTablon(input));
        input.getProductos().forEach(producto -> producto.setTablon(input));
        input.getMonedas().forEach(entidad -> entidad.setTablon(input));
        Tablon newTablon = tablonRepository.save(input);

        return new ResponseEntity<>(newTablon, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        Optional<Tablon> optionalUser = tablonRepository.findById(id);
        if (optionalUser.isPresent()) {
            tablonRepository.deleteById(id);
            return ResponseEntity.ok("Se ha eliminado el tablon");
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
