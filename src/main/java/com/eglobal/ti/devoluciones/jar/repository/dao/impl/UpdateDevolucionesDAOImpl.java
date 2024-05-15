package com.eglobal.ti.devoluciones.jar.repository.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.eglobal.ti.devoluciones.jar.dto.ActualizaDevDTO;
import com.eglobal.ti.devoluciones.jar.repository.dao.UpdateDevolucionesDAO;
import com.eglobal.ti.devoluciones.jar.repository.dao.sp.UpdateDevolucionesSP;
import com.eglobal.ti.devoluciones.jar.ws.response.RestException;
@Repository
@Qualifier(value = "UpdateDevolucionesDAO")
public class UpdateDevolucionesDAOImpl implements UpdateDevolucionesDAO{
	@Value("${storedprocedure.spActualizaDevoluciones}")
	private String actualizaDevolucion;
	@Autowired
	@Qualifier("jdbcTemplateBr")
	private JdbcTemplate jdbcTemplate;
	@Override
	public List<ActualizaDevDTO> actualizaDevoluciones(ActualizaDevDTO actualizadevDTO) throws RestException {
		// TODO Auto-generated method stub
		return new UpdateDevolucionesSP(jdbcTemplate, actualizaDevolucion).actualizar(actualizadevDTO);
		//return null;
	}

}
