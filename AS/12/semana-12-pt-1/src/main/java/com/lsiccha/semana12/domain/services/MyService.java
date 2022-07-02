package com.lsiccha.semana12.domain.services;

import com.lsiccha.semana12.domain.entities.Producto;

import java.util.List;

public interface MyService {
    List<Producto> listFilteredData(String tipo) throws InterruptedException;
}
