package com.example.clinicaveterinaria.dao;

import com.example.clinicaveterinaria.dto.DTOcliente;
import com.example.clinicaveterinaria.excepcion.ExcepcionDAO;
import com.example.clinicaveterinaria.mapper.MapperCliente;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DAOclienteImple implements DAOcliente {

    private JdbcTemplate jdbcTemplate;

    public DAOclienteImple(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(DTOcliente dtOcliente) throws ExcepcionDAO {
        try {
            String insert = "insert into cliente (ID_cliente, tipoid, nombre, apellido, ciudad, direccion, telefono) values (?,?,?,?,?,?,?)";
            jdbcTemplate.update(insert,
                    dtOcliente.getID_cliente(),
                    dtOcliente.getTipoid(),
                    dtOcliente.getNombre(),
                    dtOcliente.getApellido(),
                    dtOcliente.getCiudad(),
                    dtOcliente.getDireccion(),
                    dtOcliente.getTelefono()
            );
        } catch (Exception exception) {
            throw new ExcepcionDAO(exception);
        }
    }

    @Override
    public void update(DTOcliente dtOcliente) throws ExcepcionDAO {
        try {
            String update = "update cliente set tipoid = ?, nombre = ?, apellido = ?, ciudad = ?, direccion = ?, telefono = ?";
            jdbcTemplate.update(update,
                    dtOcliente.getTipoid(),
                    dtOcliente.getNombre(),
                    dtOcliente.getApellido(),
                    dtOcliente.getCiudad(),
                    dtOcliente.getDireccion(),
                    dtOcliente.getTelefono()
            );
        } catch (Exception exception) {
            throw new ExcepcionDAO(exception);
        }
    }

    @Override
    public void eliminar(DTOcliente dtOcliente) throws ExcepcionDAO {
        try {
            String delete = "delete from cliente where ID_cliente = ?";
            jdbcTemplate.update(delete,
                    dtOcliente.getID_cliente()
            );
        } catch (Exception exception) {
            throw new ExcepcionDAO(exception);
        }
    }

    @Override
    public DTOcliente get(DTOcliente dtOcliente) {
        try {
            String select = "select * from cliente where ID_cliente = ?";
            return jdbcTemplate.queryForObject(select, new MapperCliente(), dtOcliente.getID_cliente());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<DTOcliente> listado() throws ExcepcionDAO {
        try {
            List<DTOcliente> lista = null;
            String selectbyid = "select * from cliente";
            lista = jdbcTemplate.query(selectbyid, new MapperCliente());
            return lista;
        } catch (Exception exception) {
            throw new ExcepcionDAO(exception);
        }
    }

}
