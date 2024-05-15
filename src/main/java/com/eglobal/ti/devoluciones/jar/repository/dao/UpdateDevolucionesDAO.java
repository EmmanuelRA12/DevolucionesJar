package com.eglobal.ti.devoluciones.jar.repository.dao;

import java.util.List;

import com.eglobal.ti.devoluciones.jar.dto.ActualizaDevDTO;
import com.eglobal.ti.devoluciones.jar.ws.response.RestException;

public interface UpdateDevolucionesDAO {

	List<ActualizaDevDTO> actualizaDevoluciones(ActualizaDevDTO actualizadevDTO) throws RestException;

}
