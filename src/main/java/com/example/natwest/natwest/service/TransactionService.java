package com.example.natwest.natwest.service;

import com.example.natwest.natwest.config.AesConvertor;
import com.example.natwest.natwest.helper.ResponseHandler;
import com.example.natwest.natwest.model.AccountTransaction;
import com.example.natwest.natwest.repository.TransactionInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {


    @Autowired
    private TransactionInterface ti;

    @Value("${aes.secretkey}")
    private  String key;

    public ResponseEntity<Object> addDetails(AccountTransaction data)
    {
        //decrypting data and saving into database
        AccountTransaction temp = decryptData(data);
        System.out.println("temp is"+temp.toString());
        try {
            ti.save(temp);
            return ResponseHandler.generateResponse( "data Decrypted and added successfully into db!", HttpStatus.OK,temp);
        }
        catch (Exception e)
        {
            System.out.println(" error occured "+ e.getMessage() );
            return ResponseHandler.generateResponse( "Error occured!",HttpStatus.BAD_GATEWAY, e.getMessage());
        }
    }

    private AccountTransaction decryptData(AccountTransaction data) {
        data.setAccountNumber(AesConvertor.decrypt(data.getAccountNumber(),key));
        data.setType(AesConvertor.decrypt(data.getType(),key));
        data.setFromAccount(AesConvertor.decrypt(data.getFromAccount(),key));
        data.setCurrency(AesConvertor.decrypt(data.getCurrency(),key));
        data.setAmount(AesConvertor.decrypt(data.getAmount(),key));

        return data;
    }

    public AccountTransaction encryptData(AccountTransaction data) {

        data.setAccountNumber(AesConvertor.encrypt(data.getAccountNumber(),key));
        data.setFromAccount(AesConvertor.encrypt(data.getFromAccount(),key));
        data.setCurrency(AesConvertor.encrypt(data.getCurrency(),key));
        data.setAmount(AesConvertor.encrypt(data.getAmount(),key));
        data.setType(AesConvertor.encrypt(data.getType(),key));

        //creating new model and storing encrypted data into it

        System.out.println("encrypted is "+data.toString());

         return data;
        //return "Data encrypted and send to sender api to be saved in databse";


    }
}
