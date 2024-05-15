package com.eglobal.ti.devoluciones.jar.repository.dao;

import java.util.List;

import com.eglobal.ti.devoluciones.jar.dto.FechaDTO;
import com.eglobal.ti.devoluciones.jar.dto.ParametrosDTO;
import com.eglobal.ti.devoluciones.jar.ws.response.RestException;

public interface DevolucionesDAO {

	List<ParametrosDTO> obtenerDevoluciones(FechaDTO fechaDTO)throws RestException;

}
