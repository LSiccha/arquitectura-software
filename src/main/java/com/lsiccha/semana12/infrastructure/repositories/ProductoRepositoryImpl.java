package com.lsiccha.semana12.infrastructure.repositories;

import com.lsiccha.semana12.domain.entities.Producto;
import com.lsiccha.semana12.domain.repositories.ProductoRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ProductoRepositoryImpl implements ProductoRepository {

    ProductJpaRepository productJpaRepository;
    @Override
    public List<Producto> listar() {
        return this.productJpaRepository.findAll();
    }
}
