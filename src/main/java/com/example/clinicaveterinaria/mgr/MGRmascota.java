package com.example.clinicaveterinaria.mgr;

import com.example.clinicaveterinaria.dto.DTOmascota;
import com.example.clinicaveterinaria.excepcion.ExcepcionMGR;

import java.util.List;

public interface MGRmascota {
    void save(DTOmascota dtOmascota) throws ExcepcionMGR;

    void delete(DTOmascota dtOmascota) throws ExcepcionMGR;

    public List<DTOmascota> listado() throws ExcepcionMGR;
}
