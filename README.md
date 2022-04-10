# SecurePseudoQueue
Using Spring boot module and MySQL database i have successfully implemented above Application. I have achieved all the requirements given above! The main features are as follows :
1) I have created two API's , /encryptDetails and /decryptDetails
2) /encryptDetails :- encrypts the given data provided by user using AES algorithm using unique Secret Key which encrypts data inn block of 128 bits each.
3)/decryptDetals :- It takes encrypted Data as Input and decrypts it using similar logic using AES algorithm and then stores that decrypted data into MySQL database
4)/encryptDetals api after encrypting the data will call the /decryptDetails API( we can call directly service of another api or can Call API using REST Template or RestAssured library)
