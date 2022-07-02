package com.lsiccha.semana12.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="products")
public class Producto {
    @Id
    @Column(name="id")
    @JsonProperty("id")
    private Integer id;

    @Column(name="description")
    @JsonProperty("descripcion")
    private String descripcion;

    @Column(name="price")
    @JsonProperty("price")
    private double precio;
}
