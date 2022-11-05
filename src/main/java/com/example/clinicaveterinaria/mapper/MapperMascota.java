package com.example.clinicaveterinaria.mapper;

import com.example.clinicaveterinaria.dto.DTOmascota;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperMascota implements RowMapper<DTOmascota> {
    @Override
    public DTOmascota mapRow(ResultSet rs, int rowNum) throws SQLException {
        DTOmascota dtOmascota = new DTOmascota();
        dtOmascota.setID_mascota(rs.getInt("ID_mascota"));
        dtOmascota.setNombre(rs.getString("nombre"));
        dtOmascota.setRaza(rs.getString("raza"));
        dtOmascota.setFechaN(rs.getString("fechaN"));
        dtOmascota.setID_celda(rs.getInt("ID_celda"));
        dtOmascota.setID_cliente(rs.getInt("ID_cliente"));
        return dtOmascota;
    }
}
