package com.sillycat.thriftclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SillycatThriftJavaClientApplication extends SpringBootServletInitializer {

	public static void main(String[] args) throws Exception {
		log.info("SillycatThriftJavaServer init! ");
		SpringApplication.run(SillycatThriftJavaClientApplication.class);
		log.info("SillycatThriftJavaServer started! ");
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SillycatThriftJavaClientApplication.class);
	}

}
