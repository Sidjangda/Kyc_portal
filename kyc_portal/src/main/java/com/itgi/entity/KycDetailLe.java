package com.itgi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Table
@Entity
public class KycDetailLe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNumber;
    private String clientType;
    private String firstName;
    private String dateofBirth;
    private String mobileNumber;
    private String emailAddress;
    private String addressLine1;
    private String city;
    private String district;
    private String pinCode;
    private String state;
    private String country;
    private String correspondenceAddressLine1;
    private String correspondenceCity;
    private String correspondenceDistrict;
    private String correspondencePinCode;
    private String correspondenceState;
    private String correspondenceCountry;
    @OneToMany(cascade = CascadeType.ALL)
    private List<KycDocument> kycDocuments;
}


