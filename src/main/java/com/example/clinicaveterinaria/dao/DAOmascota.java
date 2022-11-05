package com.example.clinicaveterinaria.dao;

import com.example.clinicaveterinaria.dto.DTOmascota;
import com.example.clinicaveterinaria.excepcion.ExcepcionDAO;

import java.util.List;

public interface DAOmascota {

    DTOmascota get(DTOmascota dtOmascota) throws ExcepcionDAO;

    void insert(DTOmascota dtOmascota) throws ExcepcionDAO;

    void update(DTOmascota dtOmascota) throws ExcepcionDAO;

    void eliminar(DTOmascota dtOmascota) throws ExcepcionDAO;

    public List<DTOmascota> listado() throws ExcepcionDAO;
}
