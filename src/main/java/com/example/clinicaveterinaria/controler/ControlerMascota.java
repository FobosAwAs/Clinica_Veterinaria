package com.example.clinicaveterinaria.controler;

import com.example.clinicaveterinaria.dto.DTOmascota;
import com.example.clinicaveterinaria.dto.DTOrespuesta;
import com.example.clinicaveterinaria.excepcion.ExcepcionMGR;
import com.example.clinicaveterinaria.mgr.MGRmascota;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/mascota")

public class ControlerMascota {
    private MGRmascota mgRmascota;

    public ControlerMascota(MGRmascota mgRmascota) {
        this.mgRmascota = mgRmascota;
    }

    @PostMapping(path = "/save")
    public @ResponseBody
    void save(@RequestBody DTOmascota dtOmascota) {
        try {
            mgRmascota.save(dtOmascota);
        } catch (ExcepcionMGR e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping(path = "/delete")
    void delete(@RequestParam int  id){
        DTOmascota dtOmascota = new DTOmascota();
        dtOmascota.setID_mascota(id);

        try {
            mgRmascota.delete(dtOmascota);
        } catch (ExcepcionMGR e) {
            e.printStackTrace();
        }
    }

    @PutMapping(path = "/update")
    void update(@RequestBody DTOmascota dtOmascota) {

        try {
            mgRmascota.save(dtOmascota);
        } catch (ExcepcionMGR e) {
            e.printStackTrace();
        }

    }

    @GetMapping(path = "/lista")
    public DTOrespuesta lista(){

        DTOrespuesta respuesta = new DTOrespuesta();
        try {
            List<DTOmascota> lista = mgRmascota.listado();
            respuesta.setData(lista);
            respuesta.setCodigo(0);
        } catch (ExcepcionMGR e) {
            respuesta.setCodigo(1);
            respuesta.setMensaje(e.getMessage());
        }
        return respuesta;
    }
}
