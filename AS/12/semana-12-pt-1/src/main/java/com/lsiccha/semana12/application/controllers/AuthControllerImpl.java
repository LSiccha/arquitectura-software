package com.lsiccha.semana12.application.controllers;

import com.lsiccha.semana12.application.dto.auth.LoginDto;
import com.lsiccha.semana12.application.dto.auth.RespuestaAcceso;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/auth")
public class AuthControllerImpl implements AuthController{
    @Override
    public ResponseEntity<RespuestaAcceso> login(LoginDto creds) {
        return null;
    }
}
