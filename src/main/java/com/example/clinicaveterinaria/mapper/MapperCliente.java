package com.example.clinicaveterinaria.mapper;

import com.example.clinicaveterinaria.dto.DTOcliente;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperCliente implements RowMapper<DTOcliente> {

    @Override
    public DTOcliente mapRow(ResultSet rs, int rowNum) throws SQLException {
        DTOcliente dtOcliente = new DTOcliente();
        dtOcliente.setID_cliente(rs.getInt("ID_cliente"));
        dtOcliente.setTipoid(rs.getString("tipoid"));
        dtOcliente.setNombre(rs.getString("nombre"));
        dtOcliente.setTipoid(rs.getString("apellido"));
        dtOcliente.setCiudad(rs.getString("ciudad"));
        dtOcliente.setDireccion(rs.getString("direccion"));
        dtOcliente.setTelefono(rs.getString("telefono"));
        return dtOcliente;
    }
}
