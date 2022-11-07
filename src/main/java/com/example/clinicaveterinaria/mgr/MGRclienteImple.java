package com.example.clinicaveterinaria.mgr;

import com.example.clinicaveterinaria.dao.DAOcliente;
import com.example.clinicaveterinaria.dto.DTOcliente;
import com.example.clinicaveterinaria.excepcion.ExcepcionDAO;
import com.example.clinicaveterinaria.excepcion.ExcepcionMGR;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Service
public class MGRclienteImple implements MGRcliente {
    private DAOcliente daOcliente;

    public MGRclienteImple(DAOcliente daOcliente) {
        this.daOcliente = daOcliente;
    }

    @Override
    public void save(DTOcliente dtOcliente) throws ExcepcionMGR {

        try {
            DTOcliente verificacion = daOcliente.get(dtOcliente);
            if (verificacion == null) {
                daOcliente.insert(dtOcliente);
            } else {
                daOcliente.update(dtOcliente);
            }
        } catch (ExcepcionDAO excepcionDAO) {
            throw new ExcepcionMGR(excepcionDAO);
        }
    }

    @Override
    public void delete(DTOcliente dtOcliente) throws ExcepcionMGR {
        try {
            DTOcliente verificacion = daOcliente.get(dtOcliente);
            if (verificacion != null) {
                daOcliente.eliminar(dtOcliente);
            }
        } catch (ExcepcionDAO excepcionDAO) {
            throw new ExcepcionMGR(excepcionDAO);
        }
    }

    @Override
    public List<DTOcliente> listado() throws ExcepcionMGR {
        try {
            return daOcliente.listado();
        } catch (ExcepcionDAO excepcionDAO) {
            throw new ExcepcionMGR(excepcionDAO);
        }
    }
}
