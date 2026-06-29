package com.itgi.model;

import com.itgi.service.Validator;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
@Data
public class Error {
    private String objectName;
    private String field;
    private String message;
   // private Validator validator;
}
