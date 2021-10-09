package com.sillycat.thriftserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

import com.sillycat.thriftserver.service.ThriftServer;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SillycatThriftJavaServer extends SpringBootServletInitializer {

	private static ThriftServer thriftServer;

	public static void main(String[] args) throws Exception {
		log.info("SillycatThriftJavaServer init! ");
		ApplicationContext context = SpringApplication.run(SillycatThriftJavaServer.class);
		try {
			thriftServer = context.getBean(ThriftServer.class);
			thriftServer.start();
			log.info("SillycatThriftJavaServer started! ");
		} catch (Exception e) {
			log.error(e.getStackTrace().toString());
			log.error("SillycatThriftJavaServer failed!");
		}

	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SillycatThriftJavaServer.class);
	}

}
