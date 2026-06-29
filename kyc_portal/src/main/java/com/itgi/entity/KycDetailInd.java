package com.itgi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Table(name = "KYC_DETAIL_IND")
@Entity
public class KycDetailInd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNumber;
    private String clientType;
    private String prefix;
    private String firstName;
    private String middleName;
    private String lastName;
    private String relationshipType;
    private String relatedPersonPrefix;
    private String relatedPersonFirstName;
    private String relatedPersonMiddleName;
    private String relatedPersonLastName;
    private String gender;
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

