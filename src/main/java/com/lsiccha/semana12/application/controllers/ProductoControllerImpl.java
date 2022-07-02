package com.lsiccha.semana12.application.controllers;

import com.lsiccha.semana12.application.dto.Externo;
import com.lsiccha.semana12.domain.entities.Producto;
import com.lsiccha.semana12.domain.services.ProductoService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/")
public class ProductoControllerImpl implements ProductoController {

    private ProductoService productoService;

    public List<Producto> listarProductos(){
        return this.productoService.listar();
    }

    @Override
    public ResponseEntity<List<Producto>> listarDataProcesada() throws InterruptedException {



    }

}
