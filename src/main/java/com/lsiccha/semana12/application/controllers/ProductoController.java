package com.lsiccha.semana12.application.controllers;

import com.lsiccha.semana12.application.dto.RespuestaProducto;
import com.lsiccha.semana12.domain.entities.Producto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping
public interface ProductoController {

    @RequestMapping(value="/listar", produces = {"application/json"}, method = RequestMethod.GET)
    ResponseEntity<List<Producto>> listarProductos();

    @GetMapping(value="/procesar", produces = {"application/json"})
    ResponseEntity<RespuestaProducto> listarDataProcesada() throws InterruptedException;
}
