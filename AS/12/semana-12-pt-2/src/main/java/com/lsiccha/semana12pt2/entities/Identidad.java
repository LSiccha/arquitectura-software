package com.lsiccha.semana12pt2.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Identidad {

    @JsonProperty("dni")
    String dni;

    public void setDni(String dni){
        this.dni = dni;
    }

    public String getDni(){
        return this.dni;
    }
}
