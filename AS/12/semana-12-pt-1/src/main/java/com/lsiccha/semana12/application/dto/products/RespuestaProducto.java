package com.lsiccha.semana12.application.dto.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lsiccha.semana12.application.dto.Respuesta;
import com.lsiccha.semana12.domain.entities.Producto;
import lombok.Data;

import java.util.List;

@Data
public class RespuestaProducto extends Respuesta {

    @JsonProperty("datos")
    List<Producto> data;
}
