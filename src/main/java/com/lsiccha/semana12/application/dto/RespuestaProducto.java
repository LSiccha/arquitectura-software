package com.lsiccha.semana12.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lsiccha.semana12.domain.entities.Producto;
import lombok.Data;

import java.util.List;

@Data
public class RespuestaProducto extends Respuesta {

    @JsonProperty("data")
    List<Producto> data;
}
