package com.example.natwest.natwest.controller;

import com.example.natwest.natwest.helper.Memory;
import com.example.natwest.natwest.helper.ResponseHandler;
import com.example.natwest.natwest.helper.SenderAPI;
import com.example.natwest.natwest.model.AccountTransaction;
import com.example.natwest.natwest.service.TransactionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.print.attribute.standard.Media;
import java.util.HashMap;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService ts;

    @PostMapping(value = "/encryptDetails",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> encryptDetails(@RequestBody AccountTransaction data)
    {
         AccountTransaction encryptedData = ts.encryptData(data);
         HashMap<String,String> mp = Memory.getDetails(encryptedData);
        //indirectly calling decryptDetails api using its service
        //we can also call API using RestTemplate or RestAssured
        //Response response = new SenderAPI().PostAPI(encryptedData.toString());

        //calling 2nd API service i.e receiver API
         ts.addDetails(encryptedData);
         return ResponseHandler.generateResponse("data encrypted successfully and called receiver API to decrypt for saving in Db", HttpStatus.OK,mp);

    }

    //this receiver API takes encrypted values and decrypts it and stores in the Db
    @PostMapping(value= "/decryptDetails",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addDetails(@RequestBody AccountTransaction data)
    {
        return ts.addDetails(data);
    }
}
