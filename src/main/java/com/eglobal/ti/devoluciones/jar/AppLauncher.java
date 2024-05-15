package com.eglobal.ti.devoluciones.jar;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

import com.eglobal.ti.devoluciones.jar.InitApplication;
import com.eglobal.ti.devoluciones.jar.exceptions.AcquirerException;
import com.eglobal.ti.devoluciones.jar.service.impl.InitApplicationServiceImpl;
import com.eglobal.ti.devoluciones.jar.ws.response.RestException;

@ComponentScan({"com.eglobal.ti.devoluciones.jar",
"com.eglobal.ti.devoluciones.jar.service"})
@SpringBootApplication
public class AppLauncher implements CommandLineRunner {
	
	private static Logger logger = LoggerFactory.getLogger(AppLauncher.class);
	
	public static void main(String[] args) throws RestException {
		InitApplicationServiceImpl service =  SpringApplication.run(AppLauncher.class, args).getBean(InitApplicationServiceImpl.class);
		try {
			service.init(args);
		}catch (AcquirerException e) {			
			logger.error(String.format("Error: %s", e.getMessage()));
		} catch (IOException e) {
			logger.error(String.format("Error: %s", e.getMessage()));
		}
    }  
 
	public void run(String... args) {
		String strArgs = Arrays.stream(args).collect(Collectors.joining("|"));
		logger.info(String.format("Application started with arguments: %s", strArgs));
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		InitApplication.addInitHooks(builder.application());
		return builder.sources(InitApplication.class);
	}
	
}
