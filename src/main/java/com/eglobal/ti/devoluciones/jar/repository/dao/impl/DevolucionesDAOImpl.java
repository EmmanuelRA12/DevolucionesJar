package com.eglobal.ti.devoluciones.jar.repository.dao.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.eglobal.ti.devoluciones.jar.dto.FechaDTO;
import com.eglobal.ti.devoluciones.jar.dto.ParametrosDTO;
import com.eglobal.ti.devoluciones.jar.repository.dao.DevolucionesDAO;
import com.eglobal.ti.devoluciones.jar.repository.dao.sp.ConsultaSP;
import com.eglobal.ti.devoluciones.jar.ws.response.RestException;

@Repository
@Qualifier(value = "DevolucionesDAO")
public class DevolucionesDAOImpl implements DevolucionesDAO{
	
	@Value("${storedprocedure.spObtenerDevoluciones}")
	private String spObtener;
	@Autowired
	@Qualifier("jdbcTemplateBr")
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<ParametrosDTO> obtenerDevoluciones(FechaDTO fechaDTO) throws RestException {
		return new ConsultaSP(jdbcTemplate, spObtener).obtener(fechaDTO);
	}

}
