/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.collection.prioridad.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author JAQUELINE
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
     @Bean
     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
         http.cors().disable()
                 .csrf().disable();
         
         return http.build();
     }
}
