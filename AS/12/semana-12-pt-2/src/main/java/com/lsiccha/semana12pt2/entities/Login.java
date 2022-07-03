package com.lsiccha.semana12pt2.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Login {

    @JsonProperty("usuario")
    String usuario;

    @JsonProperty("clave")
    String clave;
}
