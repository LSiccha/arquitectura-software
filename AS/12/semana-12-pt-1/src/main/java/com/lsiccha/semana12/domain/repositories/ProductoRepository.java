package com.lsiccha.semana12.domain.repositories;

import com.lsiccha.semana12.domain.entities.Producto;

import java.util.List;

public interface ProductoRepository {
    List<Producto> listar();
}
