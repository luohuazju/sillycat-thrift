package com.sillycat.thriftclient.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sillycat.thriftclient.service.ThriftClient;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/hello")
@Slf4j
public class HelloController {

	@Autowired
	private ThriftClient thriftClient;

	@RequestMapping(value = "/thrift",method = RequestMethod.GET)
	public String helloThrift(HttpServletRequest request, HttpServletResponse response) {
		try {
			thriftClient.open();
			return thriftClient.getHelloService().sayHello("Carl");
		} catch (TException e) {
			log.error(e.getMessage());
			return "error";
		} finally {
			thriftClient.close();
		}
	}
}
