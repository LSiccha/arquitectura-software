package com.lsiccha.semana12.application.controllers;

import com.lsiccha.semana12.application.dto.RespuestaProducto;
import com.lsiccha.semana12.domain.entities.Producto;
import com.lsiccha.semana12.domain.services.ProductoService;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/")
public class ProductoControllerImpl implements ProductoController {

    @Autowired
    private ProductoService productoService;

    @Value("$(message.producto.listaProcesada)")
    private String msgListaProcesada;

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
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
