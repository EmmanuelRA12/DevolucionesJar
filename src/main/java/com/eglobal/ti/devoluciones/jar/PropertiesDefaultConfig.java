package com.eglobal.ti.devoluciones.jar;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
//@PropertySource("file:${MCOM}/adquirente-config.properties")
@PropertySource("file:C:/Users/era7216/Documents/jboss-eap-7.1/standalone/configuration/devoluciones-config.properties")
public class PropertiesDefaultConfig {
	//final String dir = System.getProperty("user.dir");
	 public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
	        PropertySourcesPlaceholderConfigurer properties = new PropertySourcesPlaceholderConfigurer();
	        //properties.setLocation(new FileSystemResource("file:" + dir +"/emisor-config.properties"));
	        properties.setIgnoreResourceNotFound(false);
	        return properties;
	    }
	 

	    @Bean("jasyptStringEncryptor")
	    public StringEncryptor stringEncryptor() {
	        EnvironmentStringPBEConfig config= new EnvironmentStringPBEConfig();
		    StandardPBEStringEncryptor standard=new StandardPBEStringEncryptor();
				config.setAlgorithm("PBEWithSHA1AndDESede");
		        config.setKeyObtentionIterations("100000");
		        config.setPassword("Off1c319#");
		        standard.setConfig(config);
	        return standard;
	    }

}