package com.eglobal.ti.devoluciones.jar.service;

import java.io.IOException;
import java.util.List;

import com.eglobal.ti.devoluciones.jar.dto.ParametrosDTO;
import com.eglobal.ti.devoluciones.jar.exceptions.AcquirerException;
import com.eglobal.ti.devoluciones.jar.ws.response.RestException;

public interface InitApplicationService {
	public List<ParametrosDTO> init(String ...args)throws AcquirerException, IOException, RestException;	
}
