package com.lsiccha.semana12.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Respuesta {

    @JsonProperty("satisfactorio")
    boolean satisfactorio;
}
