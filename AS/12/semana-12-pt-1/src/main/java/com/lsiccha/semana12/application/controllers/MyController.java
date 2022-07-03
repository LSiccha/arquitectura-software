package com.lsiccha.semana12.application.controllers;

import com.lsiccha.semana12.application.dto.products.RespuestaProducto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface MyController {

    @GetMapping("/byType")
    ResponseEntity<RespuestaProducto> getFilteredData(@RequestParam String tipo);
}
