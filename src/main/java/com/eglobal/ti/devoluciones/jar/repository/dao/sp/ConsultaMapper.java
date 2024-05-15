package com.eglobal.ti.devoluciones.jar.repository.dao.sp;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.eglobal.ti.devoluciones.jar.dto.ParametrosDTO;

@SuppressWarnings("rawtypes")
public class ConsultaMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		ParametrosDTO paramDTO = new ParametrosDTO();
		paramDTO.setDtFecRemesa(rs.getString("dtFecRemesa"));
		paramDTO.setiFolEgl(rs.getInt("iFolEgl"));
		paramDTO.setvNumCuenta(rs.getString("vNumCuenta"));
		paramDTO.setiEtapa(rs.getInt("iEtapa"));
		paramDTO.setvNumAutoVenta(rs.getString("vNumAutoVenta"));
		paramDTO.setvNoAfiliacion(rs.getInt("vNoAfiliacion"));
		paramDTO.setmImpVenta(rs.getString("mImpVenta"));
		return paramDTO;
	}


}
