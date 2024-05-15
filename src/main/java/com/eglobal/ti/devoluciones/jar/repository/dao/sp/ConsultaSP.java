package com.eglobal.ti.devoluciones.jar.repository.dao.sp;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

import com.eglobal.ti.devoluciones.jar.dto.FechaDTO;
import com.eglobal.ti.devoluciones.jar.dto.ParametrosDTO;
import com.eglobal.ti.devoluciones.jar.utils.Constants;
import com.eglobal.ti.devoluciones.jar.ws.response.RestException;



public class ConsultaSP extends StoredProcedure{
	private Map<String, Object> inputs = new HashMap<>();
	private Logger log = LoggerFactory.getLogger(ConsultaSP.class);
	@SuppressWarnings("rawtypes")
	public ConsultaSP(JdbcTemplate jdbcTemplate, String spObtener) {
		super(jdbcTemplate, spObtener);

		RowMapper rowMapper = null;
		rowMapper = (RowMapper) new ConsultaMapper();
		declareParameter(new SqlParameter("vFechaRemesa", Types.VARCHAR));
		declareParameter(new SqlParameter("vEstatus", Types.VARCHAR));
		declareParameter(new SqlParameter("iVentana", Types.INTEGER));
		declareParameter(new SqlParameter("iAdquirente", Types.INTEGER));
		declareParameter(new SqlReturnResultSet(Constants.RESULTSET, rowMapper));
		compile();	
		}
	
	@SuppressWarnings({ "unchecked" })
	public List<ParametrosDTO> obtener(FechaDTO fechaDTO) throws RestException {
		List<ParametrosDTO> resp = null;
		
		try {
			logger.info("*********** INICIA EJECUCION DE SP DE OBTENER DEVOLUCIONES***********");
			
			
			inputs.put(Constants.VFECHAREMESA, fechaDTO.getvFechaRemesa());
			inputs.put(Constants.VESTATUS, fechaDTO.getvEstatus());
			inputs.put(Constants.IVENTANA, fechaDTO.getiVentana());
			inputs.put(Constants.IADQUIRENTE, fechaDTO.getiAdquirente());
			Map<String, Object> rs = super.execute(inputs);
			resp = (List<ParametrosDTO>) rs.get((Constants.RESULTSET));
			return resp;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new RestException("128", Constants.ERR_BD);
		}
	}


}
