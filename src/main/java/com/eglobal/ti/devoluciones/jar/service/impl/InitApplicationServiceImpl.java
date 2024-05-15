package com.eglobal.ti.devoluciones.jar.service.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eglobal.ti.devoluciones.jar.dto.FechaDTO;
import com.eglobal.ti.devoluciones.jar.dto.ParametrosDTO;
import com.eglobal.ti.devoluciones.jar.dto.TransaccionDTO;
import com.eglobal.ti.devoluciones.jar.exceptions.AcquirerException;
import com.eglobal.ti.devoluciones.jar.repository.dao.DevolucionesDAO;
import com.eglobal.ti.devoluciones.jar.service.ConsultaPostService;
import com.eglobal.ti.devoluciones.jar.service.InitApplicationService;


@Service
public class InitApplicationServiceImpl implements InitApplicationService {


	
	@Autowired
	private DevolucionesDAO obtieneDevoluciones;
	@Autowired
	private ConsultaPostService consultaPost;

	Logger logger = LoggerFactory.getLogger(InitApplicationServiceImpl.class);




	private TransaccionDTO f;
	@SuppressWarnings("unused")
	private TransaccionDTO t = null;

	/**
	 * Proceso inicial
	 * @return 
	 * @throws IOException 
	 */
	@SuppressWarnings("unused")
	public List<ParametrosDTO> init(String... args) throws AcquirerException, IOException {

		try {

			logger.info("*********** VALIDACIÓN DE PARÁMETROS ***********");
//			t = evalParametersService.paramEval(args);
//			f = evalParametersService.fechaEval(args);
			//f = setTransactionParams(Arrays.asList(args));
			f = setTransactionParams(Arrays.asList(args));
		
			
			
			String fecha = f.getvFechaRemesa();
			String estatus = f.getvEstatus();
			String adquirente = f.getiAdquirente();
			String ventana = f.getiVentana();
			FechaDTO fechaDTO = new FechaDTO();
			fechaDTO.setvFechaRemesa(fecha);
			fechaDTO.setvEstatus(estatus);
			fechaDTO.setiAdquirente(adquirente);
			fechaDTO.setiVentana(ventana);
			//return parametros = obtieneDevoluciones.obtenerDevoluciones(fechaDTO);
			List<ParametrosDTO> parametros = obtieneDevoluciones.obtenerDevoluciones(fechaDTO);
			if(parametros == null || parametros.isEmpty())
			{
				logger.error("No hay agrupaciones");
			}
			else {
				
				
				for (ParametrosDTO str: parametros) {
					//logger.info("LISTA");
					//System.out.print(str);
					Object resp = consultaPost.consultaDevoluciones(str);
				}
				
				
			}
				
				
			
			return parametros;
		} catch (Exception e) {
			logger.warn("*********** La petición no puede ser procesada: {} ***********", e.getMessage());
		
		}
		return null;

	}

	@SuppressWarnings("unused")
	private TransaccionDTO setTransactionParams(List<String> asList) {
		TransaccionDTO t = new TransaccionDTO();
		List<String> type = Arrays.asList(asList.get(0).split("-"));	
		
		t.setvFechaRemesa(asList.get(0));
		t.setvEstatus(asList.get(1));
		t.setiAdquirente(asList.get(2));
		t.setiVentana(asList.get(3));
		
		return t;
	}

}