package com.example.clinicaveterinaria.controler;

import com.example.clinicaveterinaria.dto.DTOcliente;
import com.example.clinicaveterinaria.dto.DTOmascota;
import com.example.clinicaveterinaria.dto.DTOrespuesta;
import com.example.clinicaveterinaria.excepcion.ExcepcionMGR;
import com.example.clinicaveterinaria.mgr.MGRcliente;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/cliente")
public class ControlerCliente {

    private MGRcliente mgRcliente;

    public ControlerCliente(MGRcliente mgRcliente) {
        this.mgRcliente = mgRcliente;
    }


    @PostMapping(path = "/save")
    public @ResponseBody
    void save(@RequestBody DTOcliente dtOcliente) {
        try {
            mgRcliente.save(dtOcliente);
        } catch (ExcepcionMGR e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping(path = "/delete")
    void delete(@RequestParam int id) {
        DTOcliente dtOcliente = new DTOcliente();
        dtOcliente.setID_cliente(id);
        try {
            mgRcliente.delete(dtOcliente);
        } catch (ExcepcionMGR e) {
            e.printStackTrace();
        }
    }

    @PutMapping(path = "/update")
    void update(@RequestBody DTOcliente dtOcliente) {

        try {
            mgRcliente.save(dtOcliente);
        } catch (ExcepcionMGR e) {
            e.printStackTrace();
        }

    }

    @GetMapping(path = "/lista")
    public DTOrespuesta lista(){

        DTOrespuesta respuesta = new DTOrespuesta();
        try {
            List<DTOcliente> lista = mgRcliente.listado();
            respuesta.setData(lista);
            respuesta.setCodigo(0);
        } catch (ExcepcionMGR e) {
            respuesta.setCodigo(1);
            respuesta.setMensaje(e.getMessage());
        }
        return respuesta;
    }
}
