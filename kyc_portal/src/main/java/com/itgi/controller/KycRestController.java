package com.itgi.controller;

import com.itgi.dto.KycDetail;
import com.itgi.entity.KycDetailInd;
import com.itgi.entity.KycDetailLe;
import com.itgi.entity.KycRequest;
import com.itgi.entity.KycResponse;
import com.itgi.service.KycService;
import com.itgi.service.impl.KycServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/itgi/kyc")
@Slf4j
public class KycRestController {


    @Autowired
    private KycService kycService;
    @Autowired
    private KycServiceImpl kycServiceimpl;

    @GetMapping(value = "/status")
    public ResponseEntity<KycResponse> kycDetailInd(KycRequest request) {

        log.info("request received {} with name {} ", request, request.getFirstName());
        KycResponse response = new KycResponse();
        //service fetch
        response.setStatus("200");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("/fetch-all-data/ind")
    public ResponseEntity<List<KycDetailInd>> kycDetailInd() {
        List<KycDetailInd> list = kycService.findAllOwners();

        return new ResponseEntity<>(list, HttpStatus.OK);

    }

    @GetMapping("/fetch-all-data/le")
    public ResponseEntity<List<KycDetailLe>> listResponseEntity() {
        List<KycDetailLe> list = kycService.findAllOwnersLe();

        return new ResponseEntity<>(list, HttpStatus.OK);

    }

    @GetMapping(value = "/fetch/ind/{id}")
    public ResponseEntity<KycDetailInd> kycDetailInd(@PathVariable Long id) {
        KycDetailInd kycDetailInd;
        try {
            kycDetailInd = kycServiceimpl.fetchViaIdNumber(id);
        } catch (Exception e) {
            log.error("ERROR in CONTOLLER for reques {} and error is {}", id, e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(kycDetailInd, HttpStatus.OK);

    }

    @GetMapping(value = "/fetch/le/{id}")
    public ResponseEntity<KycDetailLe> kycDetailLe(@PathVariable Long id) {
        KycDetailLe kycDetailLe;
        try {
            kycDetailLe = kycServiceimpl.findViaIdNumber(id);
        } catch (Exception e) {
            log.error("ERROR in CONTOLLER for reques {} and error is {}", id, e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(kycDetailLe, HttpStatus.OK);

    }

    @PostMapping(value = "partner-services/kyc/fetch")
    public ResponseEntity<KycResponse> kycDetailResponsefetch(@RequestBody KycRequest request) {
        KycResponse kycResponse=new KycResponse();
        KycDetailInd kycDetailInd;

        log.info("Request Received :: {}", request);
        try {
            if ("ind".equalsIgnoreCase(request.getClientType())) {
              //  kycResponse = kycService.findByKycDetailReqInd(request.getFirstName(), request.getDateofBirth());
                kycResponse=kycService.findByKycRequestInd(request);
            }else if("le".equalsIgnoreCase(request.getClientType())){
                kycResponse=kycService.findByKycDetailLe(request);
            }
        } catch (Exception e) {
            log.error("ERROR in CONTOLLER for reques {} and error is {}", request.getIdNumber(), e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(kycResponse, HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<KycResponse> KycCreate(@RequestBody KycDetail request) {
        KycResponse kycResponse;
        log.info("Request Received :: {}", request);
        try {
            kycResponse = kycService.saveKycDetailInd(request);
        } catch (Exception e) {
            log.error("ERROR in CONTOLLER for reques {} and error is {}", request.getMobileNumber(), e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(kycResponse, HttpStatus.OK);
    }


}
