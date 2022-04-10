package com.example.natwest.natwest.helper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object obj)
    {
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("message",message);
        map.put("Status",status);
        map.put("data",obj);

        return new ResponseEntity<Object>(map,status);
    }
}
