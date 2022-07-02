package com.lsiccha.semana12.application.controllers;

import com.lsiccha.semana12.domain.entities.Producto;
import com.lsiccha.semana12.domain.services.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/")
@AllArgsConstructor
public class ProductoControllerImpl implements ProductoController {

    private ProductoService productoService;

    public List<Producto> listarProductos() {
        return this.productoService.listar();
    }


    @Override
    public ResponseEntity<List<Producto>> listarDataProcesada() throws InterruptedException {

        try {
            List<Producto> lista = this.productoService.listarDataProcesada();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (InterruptedException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
