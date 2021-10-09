package com.sillycat.thriftclient.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloServiceClientConfig {
	
	@Value("${thrift.host}")
	private String host;
	
	@Value("${thrift.port}")
	private int port;

	@Bean(initMethod = "init")
	public ThriftClient thriftClient() {
		ThriftClient thriftClient = new ThriftClient();
		thriftClient.setHost(host);
		thriftClient.setPort(port);
		return thriftClient;
	}
	
}
