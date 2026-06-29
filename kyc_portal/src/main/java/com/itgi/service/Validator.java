package com.itgi.service;

import ch.qos.logback.core.util.StringUtil;
import com.itgi.dto.KycDetail;
import com.itgi.entity.KycRequest;
import com.itgi.model.Error;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class Validator {

    public List<String> validate(KycRequest request) {
        List<String> list = new ArrayList<>();
        try {
            if (validateIdNumber(request.getIdNumber())) {
                log.info("id Number {} is good", request.getIdNumber());
            }
        } catch (Exception e) {
            log.error("error in id Number ");
            list.add(e.getMessage());
        }
        return list;
    }

    boolean validateIdNumber(String idNumber) throws Exception {

        if (StringUtil.isNullOrEmpty(idNumber)) {
            throw new Exception("Not blank or empty");
        }
        return true;
    }
    public List<Error> validateKycDetail(KycDetail request) {
        List<Error> list = new ArrayList<>();
            if (!validateObjectName(request.getFirstName())) {
                log.info("id Number {} is not good", request.getFirstName());
                log.error("error in First Name ");
                Error error=new Error();
                error.setMessage("first name should not be empty");
                error.setField("first name");
                error.setObjectName("kycDetail");
                list.add(error);
            }

        return list;
    }

    boolean validateObjectName(String firstName){

        if (StringUtil.isNullOrEmpty(firstName)) {
           return false;
        }
        return true;
    }


}
