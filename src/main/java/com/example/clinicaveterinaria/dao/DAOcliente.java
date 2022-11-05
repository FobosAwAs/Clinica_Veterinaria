package com.example.clinicaveterinaria.dao;

import com.example.clinicaveterinaria.dto.DTOcliente;
import com.example.clinicaveterinaria.excepcion.ExcepcionDAO;

import java.util.List;

public interface DAOcliente {
    DTOcliente get(DTOcliente dtOcliente);

    void insert(DTOcliente dtOcliente) throws ExcepcionDAO;

    void update(DTOcliente dtOcliente) throws ExcepcionDAO;

    void eliminar(DTOcliente dtOcliente) throws ExcepcionDAO;

    public List<DTOcliente> listado() throws ExcepcionDAO;
}
