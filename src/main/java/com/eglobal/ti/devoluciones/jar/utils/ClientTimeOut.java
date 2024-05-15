package com.eglobal.ti.devoluciones.jar.utils;

import org.springframework.http.client.SimpleClientHttpRequestFactory;

public class ClientTimeOut {

	public static SimpleClientHttpRequestFactory getClientHttpRequestFactory() 
	{
	    SimpleClientHttpRequestFactory clientHttpRequestFactory
	                      = new SimpleClientHttpRequestFactory();
	    //Connect timeout
	    clientHttpRequestFactory.setConnectTimeout(1000_000);
	    
	    //Read timeout
	    clientHttpRequestFactory.setReadTimeout(1000_000);
	    return clientHttpRequestFactory;
	}
}
