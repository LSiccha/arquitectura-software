package com.lsiccha.semana12.domain.services;

import com.lsiccha.semana12.application.dto.auth.LoginDto;
import com.lsiccha.semana12.domain.entities.Acceso;

public interface AuthService {

    Acceso login(LoginDto loginDto) throws Exception;
}
