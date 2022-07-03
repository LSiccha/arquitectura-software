package com.lsiccha.semana12.application.controllers.impl;

import com.lsiccha.semana12.application.controllers.MyController;
import com.lsiccha.semana12.application.dto.products.RespuestaProducto;
import com.lsiccha.semana12.domain.entities.Producto;
import com.lsiccha.semana12.domain.services.MyService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/filter")
public class MyControllerImpl implements MyController {

    private MyService myService;

    MyControllerImpl(MyService myService){
        this.myService = myService;
    }

    @Value("${message.producto.listaFiltrada}")
    private String msgListaFiltrada;

    @Value("${message.producto.errorProceso}")
    private String msgerrorProceso;

    @Override
    public ResponseEntity<RespuestaProducto> getFilteredData(String tipo) {
        RespuestaProducto respuestaProducto = new RespuestaProducto();
        try {
            List<Producto> lista = this.myService.listFilteredData(tipo);
            respuestaProducto.setSatisfactorio(true);
            respuestaProducto.setCodigo("10");
            respuestaProducto.setMensaje(msgListaFiltrada+". Filtro: : "+tipo);
            respuestaProducto.setData(lista);
            return new ResponseEntity<>(respuestaProducto, HttpStatus.OK);
        } catch (InterruptedException e) {
            respuestaProducto.setSatisfactorio(false);
            respuestaProducto.setCodigo("99");
            respuestaProducto.setMensaje(msgerrorProceso);
            return new ResponseEntity<>(respuestaProducto,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

