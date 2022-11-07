package com.example.clinicaveterinaria.mgr;

import com.example.clinicaveterinaria.dto.DTOcliente;
import com.example.clinicaveterinaria.excepcion.ExcepcionMGR;

import java.util.List;

public interface MGRcliente {

    void save(DTOcliente dtOcliente) throws ExcepcionMGR;

    void delete(DTOcliente dtOcliente) throws ExcepcionMGR;

    public List<DTOcliente> listado() throws ExcepcionMGR;
}
