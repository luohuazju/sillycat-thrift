package com.sillycat.thriftserver.service;

import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import com.sillycat.thrift.service.HelloService;

@Service("helloService")
public class HelloServiceImpl implements HelloService.Iface {

	@Override
	public String sayHello(String name) throws TException {
		String result = "Carl is testing Thrift, input = " + name;
		return result;
	}

}
