package com.example.clinicaveterinaria.dao;

import com.example.clinicaveterinaria.dto.DTOcelda;
import com.example.clinicaveterinaria.excepcion.ExcepcionDAO;

import java.util.List;

public interface DAOcelda {
    DTOcelda get(DTOcelda dtOcelda);

    void insert(DTOcelda dtOcelda) throws ExcepcionDAO;

    void update(DTOcelda dtOcelda) throws ExcepcionDAO;

    void eliminar(DTOcelda dtOcelda) throws ExcepcionDAO;

    public List<DTOcelda> listado() throws ExcepcionDAO;
}
