package com.lsiccha.semana12.domain.services;

import com.lsiccha.semana12.domain.entities.Producto;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface ProductoService {
    List<Producto> listar();

    List<Producto> listarDataProcesada() throws InterruptedException;
}
