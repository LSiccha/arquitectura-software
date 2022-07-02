package com.lsiccha.semana12.infrastructure.repositories;

import com.lsiccha.semana12.domain.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<Producto, Integer> {
}
