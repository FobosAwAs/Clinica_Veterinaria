package com.example.clinicaveterinaria.dao;

import com.example.clinicaveterinaria.dto.DTOmascota;
import com.example.clinicaveterinaria.excepcion.ExcepcionDAO;
import com.example.clinicaveterinaria.mapper.MapperMascota;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class DAOmascotaImple implements DAOmascota {

    private JdbcTemplate jdbcTemplate;

    public DAOmascotaImple(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(DTOmascota dtOmascota) throws ExcepcionDAO {
        try {
            String insert = "insert into mascota (ID_mascota,nombre,raza, fechaN, ID_celda, ID_cliente) values(?,?,?,?,?,?)";
            jdbcTemplate.update(insert,
                    dtOmascota.getID_mascota(),
                    dtOmascota.getNombre(),
                    dtOmascota.getRaza(),
                    dtOmascota.getFechaN(),
                    dtOmascota.getID_celda(),
                    dtOmascota.getID_cliente()
            );
        } catch (Exception exception) {
            throw new ExcepcionDAO(exception);
        }

    }

    @Override
    public void update(DTOmascota dtOmascota) throws ExcepcionDAO {
        try {
            String update = "update mascota set nombre = ?,raza = ?, fechaN = ?, ID_celda = ?, ID_cliente = ?";
            jdbcTemplate.update(update,
                    dtOmascota.getNombre(),
                    dtOmascota.getRaza(),
                    dtOmascota.getFechaN(),
                    dtOmascota.getID_celda(),
                    dtOmascota.getID_cliente()
            );
        } catch (Exception exception) {
            throw new ExcepcionDAO(exception);
        }
    }

    @Override
    public void eliminar(DTOmascota dtOmascota) throws ExcepcionDAO {
        try {
            String delete = "delete from mascota where ID_mascota = ?";
            jdbcTemplate.update(delete,
                    dtOmascota.getID_mascota()
            );
        } catch (Exception exception) {
            throw new ExcepcionDAO(exception);
        }
    }

    @Override
    public DTOmascota get(DTOmascota dtOmascota) {
        try {
            String select = "select * from mascota where ID_mascota = ?";
            return jdbcTemplate.queryForObject(select, new MapperMascota(), dtOmascota.getID_mascota());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<DTOmascota> listado() throws ExcepcionDAO {
        try {
            List<DTOmascota> lista = null;
            String selectbyid = "select * from mascota";
            lista = jdbcTemplate.query(selectbyid, new MapperMascota());
            return lista;
        } catch (Exception exception) {
            throw new ExcepcionDAO(exception);
        }

    }


}
