package com.sillycat.thriftclient.service;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransportException;

import com.sillycat.thrift.service.HelloService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThriftClient {

	private HelloService.Client client;

	private TBinaryProtocol protocol;

	private TSocket transport;

	private String host;

	private int port;

	public void init() {
		try {
			this.transport = new TSocket(host, port);
			this.protocol = new TBinaryProtocol(transport);
			this.client = new HelloService.Client(protocol);
		} catch (TTransportException e) {
			log.error(e.getMessage());
		}
	}

	public HelloService.Client getHelloService() {
		return this.client;
	}

	public void open() {
		try {
			transport.open();
		} catch (TTransportException e) {
			log.error(e.getMessage());
		}
	}
	
	public void close() {
		transport.close();
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

}
