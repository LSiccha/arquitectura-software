package com.lsiccha.semana12.application.dto.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lsiccha.semana12.application.dto.Respuesta;
import com.lsiccha.semana12.domain.entities.Acceso;
import lombok.Data;

@Data
public class RespuestaAcceso extends Respuesta {

    @JsonProperty("datos")
    Acceso data;
}
