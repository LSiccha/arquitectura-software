package com.lsiccha.semana12.application.controllers;

import com.lsiccha.semana12.application.dto.auth.LoginDto;
import com.lsiccha.semana12.application.dto.auth.RespuestaAcceso;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface AuthController {

    @RequestMapping(value="/login", produces = {"application/json"}, method = RequestMethod.GET)
    ResponseEntity<RespuestaAcceso> login(@RequestBody LoginDto creds);

}
