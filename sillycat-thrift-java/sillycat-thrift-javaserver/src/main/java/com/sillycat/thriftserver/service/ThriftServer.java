package com.sillycat.thriftserver.service;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sillycat.thrift.service.HelloService;

import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ThriftServer {

	@Value("${thrift.port}")
	private int port;
	@Value("${thrift.minWorkerThreads}")
	private int minThreads;
	@Value("${thrift.maxWorkerThreads}")
	private int maxThreads;

	private TBinaryProtocol.Factory protocolFactory;
	private TTransportFactory transportFactory;

	@Autowired
	private HelloService.Iface helloService;

	public void init() {
		protocolFactory = new TBinaryProtocol.Factory();
		transportFactory = new TTransportFactory();
	}

	public void start() {
		HelloService.Processor<HelloService.Iface> processor = new HelloService.Processor<HelloService.Iface>(
				helloService);
		init();
		try {
			TServerTransport transport = new TServerSocket(port);
			TThreadPoolServer.Args tArgs = new TThreadPoolServer.Args(transport);
			tArgs.processor(processor);
			tArgs.protocolFactory(protocolFactory);
			tArgs.transportFactory(transportFactory);
			tArgs.minWorkerThreads(minThreads);
			tArgs.maxWorkerThreads(maxThreads);
			TServer server = new TThreadPoolServer(tArgs);
			log.info("thrift server starts, port={}", port);
			server.serve();
		} catch (Exception e) {
			log.error("thrift server starts fail!");
		}
	}
}
