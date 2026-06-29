package com.itgi.service;

import com.itgi.dto.KycDetail;
import com.itgi.entity.*;

import java.util.List;

public interface KycService {
    Result fetchKycData(KycRequest request);

    List<KycDetailInd> findAllOwners();

    List<KycDetailLe> findAllOwnersLe();

    KycResponse saveKycDetailInd(KycDetail kycDetailInd);

    KycResponse findByKycDetailReqInd(String fname, String dateOfBirth);

     KycResponse findByKycRequestInd(KycRequest request) ;
    KycResponse findByKycDetailLe(KycRequest request);
}
