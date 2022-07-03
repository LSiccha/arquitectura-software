package com.lsiccha.semana12.application.controllers.impl;

import com.lsiccha.semana12.application.controllers.ProductoController;
import com.lsiccha.semana12.application.dto.products.RespuestaProducto;
import com.lsiccha.semana12.domain.entities.Producto;
import com.lsiccha.semana12.domain.services.ProductoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/")
public class ProductoControllerImpl implements ProductoController {

    private ProductoService productoService;

    ProductoControllerImpl(ProductoService productoService){
        this.productoService = productoService;
    }

    @Value("${message.producto.listaProcesada}")
    private String msgListaProcesada;

    @Value("${message.producto.errorProceso}")
    private String msgerrorProceso;

    public ResponseEntity<List<Producto>> listarProductos() {
        List<Producto> lista = this.productoService.listar();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }


    @Override
    public ResponseEntity<RespuestaProducto> listarDataProcesada() throws InterruptedException {
        RespuestaProducto respuestaProducto = new RespuestaProducto();
        try {
            List<Producto> lista = this.productoService.listarDataProcesada();
            respuestaProducto.setSatisfactorio(true);
            respuestaProducto.setCodigo("10");
            respuestaProducto.setMensaje(msgListaProcesada);
            respuestaProducto.setData(lista);
            return new ResponseEntity<>(respuestaProducto, HttpStatus.OK);
        } catch (InterruptedException e) {
            respuestaProducto.setSatisfactorio(false);
            respuestaProducto.setCodigo("99");
            respuestaProducto.setMensaje(msgerrorProceso);
            return new ResponseEntity<>(respuestaProducto,HttpStatus.INTERNAL_SERVER_ERROR);        }

    }
}
