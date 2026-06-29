package com.itgi.entity;

import lombok.Data;

import java.util.List;

@Data
public class KycRequest {

    private String idNumber;
    private String idType;
    private String firstName;
    private String lastName;
    private String gender;
    private String dateofBirth;
    private String clientType;


//        "idNumber": "30023814909346",
//                "idType": "CKYC IDENTIFIER",
//                "firstName": "Shivani",
//                "lastName": "Sutar",
//                "gender": "F",
//                "dateofBirth": "29-03-1994
}
