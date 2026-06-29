package com.itgi.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result {
    private String clientType;
    private String itgiUniqueReferenceId;
    private String status;
    private String customerType;
    private String prefix;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private String formSixty;
    private String dateofBirth;
    private Date kycDateOfDeclaration;
    private Date kycVerificationDate;
    private String kycEmployeeName;
    private String kycEmployeeDesignation;
    private String kycVerificationBranch;
    private String kycEmployeeCode;
    private String addressLine1;
    private String pinCode;
    private String city;
    private String state;
    private String country;
    private String district;
    private String correspondenceAddressLine1;
    private String correspondencePinCode;
    private String correspondenceCity;
    private String correspondenceState;
    private String correspondenceCountry;
    private String correspondenceDistrict;
    private Date createdOn;
    private String recordCreated;
    private String documentStored;
    private String RelatedPersonPrefix;
    private String RelatedPersonFirstName;
    private String RelatedPersonMiddleName;
    private String RelatedPersonLastName;
    private String RelationshipType;
    private String MobileNumber;
    private String EmailAddress;
    private List<KycDocument> kycDocuments;
}
