package com.example.natwest.natwest;

import com.example.natwest.natwest.config.AesConvertor;
import com.example.natwest.natwest.helper.SenderAPI;
import com.example.natwest.natwest.model.AccountTransaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Map;

@SpringBootTest
class NatwestApplicationTests {

//	@Test
//	void contextLoads() {
//	}

	@Value("${aes.secretkey}")
    private String key;

	@Test
	public void testThis()
	{
		Double a=1000.00;
		String encrypt = AesConvertor.encrypt(String.valueOf(a),key);
		String decrypt = AesConvertor.decrypt(encrypt,key);
		System.out.println("encrypt is "+ encrypt);
		System.out.println("Decrypt is "+ Double.valueOf(decrypt));
	}

	@Test
	public void testRest()
	{

	}

}
