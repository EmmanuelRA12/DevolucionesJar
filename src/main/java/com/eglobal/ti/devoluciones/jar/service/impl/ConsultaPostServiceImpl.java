package com.eglobal.ti.devoluciones.jar.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eglobal.ti.devoluciones.jar.dto.ActualizaDevDTO;

import com.eglobal.ti.devoluciones.jar.dto.ParametrosDTO;
import com.eglobal.ti.devoluciones.jar.repository.dao.UpdateDevolucionesDAO;
import com.eglobal.ti.devoluciones.jar.service.ConsultaPostService;

@Service
public class ConsultaPostServiceImpl implements ConsultaPostService {
	Logger logger = LoggerFactory.getLogger(ConsultaPostServiceImpl.class);
	@Autowired
	private UpdateDevolucionesDAO updateDevoluciones;
	@Override
	public Object consultaDevoluciones(ParametrosDTO str) {
		// TODO Auto-generated method stub
		Connection BaseDatos = null;
	    Statement st = null;
	    
	    String url="jdbc:postgresql://172.29.40.164:5432/ebind_bancos";
	  //Credenciales de la base de datos
	    String usuario="ulinsce";
	    String contrasena="P4sswo$#2024*1";
	    try {
	        //Conexion con la base de datos
	        BaseDatos = DriverManager.getConnection(url, usuario, contrasena);
	        st = BaseDatos.createStatement();
	        
	        String numeroafiliacion= String.valueOf(str.getvNoAfiliacion());	        
	        String adq = "12";	       
	        Double importe = Double.valueOf(str.getmImpVenta());	        
	        String cuenta= "4152313309806391";
	        String auto="125064";
	        String afi="4143792";
	        Double imp = 5880.65;
	      logger.info("Accede a BD EBIND");
	        ResultSet rs = st.executeQuery( ""
	        		
	            + "select dd.fe_proceso, dd.fe_txn, dd.no_plastico, dd.imp_txn ,dd.num_autoriza , dd.num_ref_comercio, dd.num_ref, dd.id_devolucion,"
	            + "CASE WHEN dv.imp_txn = dd.imp_txn then 1 else 0 end as id_tipo_devolucion,"
	            + "CASE WHEN dv.imp_txn = dd.imp_txn then 'Devolución Total' else 'Devolución Parcial' end as tipo_devolucion"
	            + " FROM  devolucion.d_venta dv inner join devolucion.d_devolucion dd on dv.id_devolucion  = dd.id_devolucion  INNER JOIN devolucion.t_controversias tc on   "
	            //+ " FROM  devolucion.d_venta dv inner join devolucion.d_devolucion dd on dv.id_devolucion  = dd.id_devolucion "
	            + " trim(dv.no_plastico) =  '"+str.getvNumCuenta()+"'"
	            + " and dv.num_autoriza = '" + str.getvNumAutoVenta()+"'"
	            + " and dv.no_afiliacion = '"+ numeroafiliacion+"'"
	            + " and dv.imp_txn = '"+ importe+"'"
	            + " and dv.adquirente ='"+ adq+"'"
	            + " where dd.cod_err = '00'"

	            
	            
	            
	             );
	 
	        while    ( rs.next() ) {
	        	
	        	String numAfiliacion = Integer.toString(str.getvNoAfiliacion());
	        	
	        	ActualizaDevDTO actualizadevDTO = new ActualizaDevDTO();
	        	actualizadevDTO.setvFechaRemesa(rs.getString(str.getDtFecRemesa()));
	        	actualizadevDTO.setiFolEgl(rs.getInt(str.getiFolEgl()));
	        	actualizadevDTO.setvNumCuenta(rs.getString("no_plastico"));
	        	actualizadevDTO.setvNoAfiliacion(numAfiliacion);
	        	actualizadevDTO.setiIdDevParcial(rs.getInt("id_devolucion"));
	        	actualizadevDTO.setDtFeProcesoDev(rs.getString("fe_proceso"));
	        	actualizadevDTO.setDtFeTxnDev(rs.getString("fe_txn"));
	        	actualizadevDTO.setmImpDev(rs.getString("imp_txn"));
	        	actualizadevDTO.setvNumRefDev(rs.getString("num_ref"));
	        	actualizadevDTO.setvNumRefComercio(rs.getString("num_ref_comercio"));
	        	actualizadevDTO.setvNumAutoDev(rs.getString("num_autoriza"));
	        	actualizadevDTO.setvTipoDevolucion(rs.getString(""));
	        	
	        	
	        	List<ActualizaDevDTO> actualizacion = updateDevoluciones.actualizaDevoluciones(actualizadevDTO);
	        	

	        }
	 
	        rs.close();
	        st.close();
	        BaseDatos.close();
	    } catch (Exception e) {
	    	System.err.println( "Error en la Base de Datos Postgrest" );
	        System.err.println( e.getMessage() );
	        }
	    
	    
		return null;
	}

}
