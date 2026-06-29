package com.itgi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KycPortalApplication {

    public static void main(String[] args) {


        SpringApplication.run(KycPortalApplication.class, args);


    }
/*
    public void run(String... args) {
        KycServiceImpl KycService = new KycServiceImpl();
        List<KycDetailInd> ownerDTOList = KycService.findAllOwners();
        System.out.println("There are " + ownerDTOList.size() + " owners.");
        ownerDTOList.forEach(System.out::println);


    }

 */
}