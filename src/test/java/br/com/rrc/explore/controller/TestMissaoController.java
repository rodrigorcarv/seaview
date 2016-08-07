package br.com.rrc.explore.controller;


import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestMissaoController {

	@Value("${local.server.port}")   
	int port;

	@Before
	public void setUp() {
		RestAssured.port = port;
	}

	@Test
	public void explorarOceandoSucesso() {
		
		String comandos = "LMRDDMMUU";
		
		given().
			contentType(ContentType.TEXT).
			body(comandos).
		when().
			post("/missao/explorar-fossa").
		then().
		 	body(containsString("-1 2 0 NORTE")).
			statusCode(HttpStatus.SC_OK);
	}

}
