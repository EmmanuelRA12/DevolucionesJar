package com.eglobal.ti.devoluciones.jar;


import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
//@PropertySource({ "file:${MCOM}/adquirente-config.properties" })
@PropertySource("file:C:/Users/era7216/Documents/jboss-eap-7.1/standalone/configuration/devoluciones-config.properties")
public class ApplicationConfig implements Serializable{
	
	private static final long serialVersionUID = 1L;

//	@Value("${endpoint.api_integrity}")
//	private  static String urlApiIntegrity;
//	
//	@Value("${endpoint.api_dms}")
//	private static String urlApiManagerDms;
//
//	@Value("${endpoint.api_cbk}")
//	private static String urlApiManagerCbk;
//
//	public static String getUrlApiIntegrity() {
//		return urlApiIntegrity;
//	}
//	
//	public static String getUrlApiManagerDms() {
//		return urlApiManagerDms;
//	}
//
//	public static String getUrlApiManagerCbk() {
//		return urlApiManagerCbk;
//	}	
}
