package com.example.natwest.natwest.helper;

import com.example.natwest.natwest.model.AccountTransaction;

import java.util.HashMap;

public class Memory {

    public static HashMap<String,String> getDetails(AccountTransaction encryptedData)
    {

        HashMap<String,String> hm= new HashMap<String,String>();
        hm.put("accountNumber",encryptedData.getAccountNumber());
        hm.put("fromAccount",encryptedData.getFromAccount());
        hm.put("currency",encryptedData.getCurrency());
        hm.put("amount",encryptedData.getAmount());
        hm.put("type",encryptedData.getType());

        return hm;
    }
}
