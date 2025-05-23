package com.example.demo_maven_web;


//import org.apache.catalina.connector.Connector;
import org.apache.catalina.connector.Connector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@SpringBootApplication
@RestController
public class DemoMavenWebApplication {

	@GetMapping("/hello")
	public String hello() {
		return "Hello Spring";
	}

	public static void main(String[] args) {

		SpringApplication.run(DemoMavenWebApplication.class, args);


	}

	@Bean
	public ServletWebServerFactory serverFactory () {
		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
		tomcat.addAdditionalTomcatConnectors(createStandardConnector());
		return tomcat;
	}

	private Connector createStandardConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setPort(8080);
		return connector;
	}

}
