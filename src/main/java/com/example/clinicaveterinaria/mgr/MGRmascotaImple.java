package com.example.clinicaveterinaria.mgr;

import com.example.clinicaveterinaria.dao.DAOmascota;
import com.example.clinicaveterinaria.dto.DTOmascota;
import com.example.clinicaveterinaria.excepcion.ExcepcionDAO;
import com.example.clinicaveterinaria.excepcion.ExcepcionMGR;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class MGRmascotaImple implements MGRmascota {
    private DAOmascota daOmascota;

    public MGRmascotaImple(DAOmascota daOmascota) {
        this.daOmascota = daOmascota;
    }

    @Override
    public void save(DTOmascota dtOmascota) throws ExcepcionMGR {

        try {
            DTOmascota verificacion = daOmascota.get(dtOmascota);
            if (verificacion == null) {
                daOmascota.insert(dtOmascota);
            } else {
                daOmascota.update(dtOmascota);
            }
        } catch (ExcepcionDAO excepcionDAO) {
            throw new ExcepcionMGR(excepcionDAO);
        }
    }

    @Override
    public void delete(DTOmascota dtOmascota) throws ExcepcionMGR {

        try {
            DTOmascota verificacion = daOmascota.get(dtOmascota);
            if (verificacion != null) {
                daOmascota.eliminar(dtOmascota);
            }
        } catch (ExcepcionDAO excepcionDAO) {
            throw new ExcepcionMGR(excepcionDAO);
        }
    }

    @Override
    public List<DTOmascota> listado() throws ExcepcionMGR {
        try {
            return daOmascota.listado();
        } catch (ExcepcionDAO excepcionDAO) {
            throw new ExcepcionMGR(excepcionDAO);
        }
    }
}
