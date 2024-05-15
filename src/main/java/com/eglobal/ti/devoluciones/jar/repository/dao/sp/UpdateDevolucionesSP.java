package com.eglobal.ti.devoluciones.jar.repository.dao.sp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.object.StoredProcedure;

import com.eglobal.ti.devoluciones.jar.dto.ActualizaDevDTO;

public class UpdateDevolucionesSP extends StoredProcedure  {

	private static Logger logger = LoggerFactory.getLogger(UpdateDevolucionesSP.class);

	private Map<String, Object> inputs = new HashMap<String, Object>();
	public UpdateDevolucionesSP(JdbcTemplate jdbcTemplate, String actualizaDevolucion) {
		// TODO Auto-generated constructor stub
	}

	public List<ActualizaDevDTO> actualizar(ActualizaDevDTO actualizadevDTO) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
