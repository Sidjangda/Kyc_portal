package com.itgi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table
@Entity
public class KycDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String itgiRefNumber;
    private String idType;
    private String idName;
    private String idNumber;
    private String fileName;
    private String fileExtension;
    private String fileBase64;

}
