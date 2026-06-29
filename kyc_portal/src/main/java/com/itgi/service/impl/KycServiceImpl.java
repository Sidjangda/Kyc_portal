package com.itgi.service.impl;

import com.itgi.dto.KycDetail;
import com.itgi.entity.*;
import com.itgi.repository.KycDetailIndRepository;
import com.itgi.repository.KycDetailLeRepository;
import com.itgi.repository.KycDocumentRepository;
import com.itgi.service.KycService;
import com.itgi.service.UniqueCodeGenerator;
import com.itgi.service.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KycServiceImpl implements KycService {

    @Autowired
    private Validator validator;

    @Autowired
    private KycDetailIndRepository kycDetailIndRepository;

    @Autowired
    private KycDetailLeRepository kycDetailLeRepository;
    @Autowired
    private KycDocumentRepository kycDocumentRepository;

    @Override
    public Result fetchKycData(KycRequest request) {
        // Result result = new Result();
      /*  List<String> errorList = validator.validate(request);

        if (errorList == null && errorList.size() == 0) {
            //  kycDao.fetchKycData();
        }

       */
        return null;
    }


    public List<KycDetailInd> findAllOwners() {
        return kycDetailIndRepository.findAll();

        //    return kycRepositoryImpl.findAllOwners();
    }

    public List<KycDetailLe> findAllOwnersLe() {
        return kycDetailLeRepository.findAll();

    }

    public KycDetailInd fetchViaIdNumber(Long id) {

        return kycDetailIndRepository.findByIdNumber(id);

    }

    public KycResponse findByKycDetailReqInd(String fname, String dateOfBirth) {
        KycResponse kycResponse = new KycResponse();
        KycDetailInd kycDetailInd;
        Result result = new Result();
        kycDetailInd = kycDetailIndRepository.finByKycDetailReqInd(fname, dateOfBirth);
        kycResponse.setStatus("200");
        if (kycDetailInd != null) {
            result.setClientType(kycDetailInd.getClientType());
            result.setFirstName(kycDetailInd.getFirstName());
            result.setMiddleName(kycDetailInd.getMiddleName());
            result.setLastName(kycDetailInd.getLastName());
            result.setPrefix(kycDetailInd.getPrefix());
            result.setGender(kycDetailInd.getGender());
            result.setDateofBirth(kycDetailInd.getDateofBirth());
            result.setRelatedPersonPrefix(kycDetailInd.getRelatedPersonPrefix());
            result.setRelatedPersonFirstName(kycDetailInd.getRelatedPersonFirstName());
            result.setRelatedPersonMiddleName(kycDetailInd.getRelatedPersonMiddleName());
            result.setRelatedPersonLastName(kycDetailInd.getRelatedPersonLastName());
            result.setRelationshipType(kycDetailInd.getRelationshipType());
            result.setMobileNumber(kycDetailInd.getMobileNumber());
            result.setEmailAddress(kycDetailInd.getEmailAddress());
            result.setAddressLine1(kycDetailInd.getAddressLine1());
            result.setCity(kycDetailInd.getCity());
            result.setDistrict(kycDetailInd.getDistrict());
            result.setState(kycDetailInd.getState());
            result.setCountry(kycDetailInd.getCountry());
            result.setPinCode(kycDetailInd.getPinCode());
            result.setCorrespondenceAddressLine1(kycDetailInd.getCorrespondenceAddressLine1());
            result.setCorrespondenceCity(kycDetailInd.getCorrespondenceCity());
            result.setCorrespondenceDistrict(kycDetailInd.getCorrespondenceDistrict());
            result.setCorrespondenceState(kycDetailInd.getCorrespondenceState());
            result.setCorrespondenceCountry(kycDetailInd.getCorrespondenceCountry());
            result.setCorrespondencePinCode(kycDetailInd.getCorrespondencePinCode());
            result.setKycDocuments(kycDetailInd.getKycDocuments());

        } else {
            result.setStatus("No Record Found");
        }
        kycResponse.setResult(result);
        return kycResponse;
    }


    public KycResponse findByKycRequestInd(KycRequest request) {
        KycResponse kycResponse = new KycResponse();
        KycDetailInd kycDetailInd;
        Result result = new Result();
        kycDetailInd = kycDetailIndRepository.findByCriteria(request.getFirstName(), request.getDateofBirth(), request.getIdNumber(), request.getIdType(), request.getClientType());
        kycResponse.setStatus("200");
        if (kycDetailInd != null) {
            result.setClientType(kycDetailInd.getClientType());
            result.setFirstName(kycDetailInd.getFirstName());
            result.setMiddleName(kycDetailInd.getMiddleName());
            result.setLastName(kycDetailInd.getLastName());
            result.setPrefix(kycDetailInd.getPrefix());
            result.setGender(kycDetailInd.getGender());
            result.setDateofBirth(kycDetailInd.getDateofBirth());
            result.setRelatedPersonPrefix(kycDetailInd.getRelatedPersonPrefix());
            result.setRelatedPersonFirstName(kycDetailInd.getRelatedPersonFirstName());
            result.setRelatedPersonMiddleName(kycDetailInd.getRelatedPersonMiddleName());
            result.setRelatedPersonLastName(kycDetailInd.getRelatedPersonLastName());
            result.setRelationshipType(kycDetailInd.getRelationshipType());
            result.setMobileNumber(kycDetailInd.getMobileNumber());
            result.setEmailAddress(kycDetailInd.getEmailAddress());
            result.setAddressLine1(kycDetailInd.getAddressLine1());
            result.setCity(kycDetailInd.getCity());
            result.setDistrict(kycDetailInd.getDistrict());
            result.setState(kycDetailInd.getState());
            result.setCountry(kycDetailInd.getCountry());
            result.setPinCode(kycDetailInd.getPinCode());
            result.setCorrespondenceAddressLine1(kycDetailInd.getCorrespondenceAddressLine1());
            result.setCorrespondenceCity(kycDetailInd.getCorrespondenceCity());
            result.setCorrespondenceDistrict(kycDetailInd.getCorrespondenceDistrict());
            result.setCorrespondenceState(kycDetailInd.getCorrespondenceState());
            result.setCorrespondenceCountry(kycDetailInd.getCorrespondenceCountry());
            result.setCorrespondencePinCode(kycDetailInd.getCorrespondencePinCode());
            result.setKycDocuments(kycDetailInd.getKycDocuments());

        } else {
            result.setStatus("No Record Found");
        }
        kycResponse.setResult(result);
        return kycResponse;
    }

    public KycResponse findByKycDetailLe(KycRequest request) {

        KycResponse kycResponse = new KycResponse();
        KycDetailLe kycDetailLe;
        Result result = new Result();
        kycDetailLe = kycDetailLeRepository.findByCriteria(request.getFirstName(), request.getDateofBirth(), request.getIdNumber(), request.getIdType(), request.getClientType());
        kycResponse.setStatus("200");
        if (kycDetailLe != null) {
            result.setClientType(kycDetailLe.getClientType());
            result.setFirstName(kycDetailLe.getFirstName());
            result.setDateofBirth(kycDetailLe.getDateofBirth());
            result.setMobileNumber(kycDetailLe.getMobileNumber());
            result.setEmailAddress(kycDetailLe.getEmailAddress());
            result.setAddressLine1(kycDetailLe.getAddressLine1());
            result.setCity(kycDetailLe.getCity());
            result.setDistrict(kycDetailLe.getDistrict());
            result.setState(kycDetailLe.getState());
            result.setCountry(kycDetailLe.getCountry());
            result.setPinCode(kycDetailLe.getPinCode());
            result.setCorrespondenceAddressLine1(kycDetailLe.getCorrespondenceAddressLine1());
            result.setCorrespondenceCity(kycDetailLe.getCorrespondenceCity());
            result.setCorrespondenceDistrict(kycDetailLe.getCorrespondenceDistrict());
            result.setCorrespondenceState(kycDetailLe.getCorrespondenceState());
            result.setCorrespondenceCountry(kycDetailLe.getCorrespondenceCountry());
            result.setCorrespondencePinCode(kycDetailLe.getCorrespondencePinCode());
            result.setKycDocuments(kycDetailLe.getKycDocuments());

        } else {
            result.setStatus("No Record Found");
        }
        kycResponse.setResult(result);
        return kycResponse;

    }

    public KycDetailLe findViaIdNumber(Long id) {

        return kycDetailLeRepository.findByIdNumber(id);

    }

    public KycDocument findViaIdNumber(String idNumber) {

        return kycDocumentRepository.findByIdNumber(idNumber);

    }


    public KycResponse saveKycDetailInd(KycDetail kycDetail) {
        KycResponse kycResponse = new KycResponse();
        Result result = new Result();
        List<KycDocument> kycDocumentList = kycDetail.getKycDocuments();
        for (int i = 0; i < kycDocumentList.size(); i++) {
            String idNumber = kycDocumentList.get(i).getIdNumber();

            KycDocument kycDocument = findViaIdNumber(idNumber);
            if (kycDocument != null) {
                kycResponse.setStatus("200");
                result.setRecordCreated("N");
                result.setDocumentStored("N");
                result.setItgiUniqueReferenceId(kycDocument.getItgiRefNumber());
                kycResponse.setResult(result);
                return kycResponse;
            }
        }

        String itgiNumber = UniqueCodeGenerator.generateUniqueCode();
        for (int i = 0; i < kycDocumentList.size(); i++) {
            KycDocument document = kycDocumentList.get(i);
            document.setItgiRefNumber(itgiNumber);
        }


        if (kycDetail.getClientType().equalsIgnoreCase("IND")) {
            KycDetailInd kycDetailInd = new KycDetailInd();
            kycDetailInd.setClientType("IND");
            kycDetailInd.setFirstName(kycDetail.getFirstName());
            kycDetailInd.setMiddleName(kycDetail.getMiddleName());
            kycDetailInd.setLastName(kycDetail.getLastName());
            kycDetailInd.setPrefix(kycDetail.getPrefix());
            kycDetailInd.setGender(kycDetail.getGender());
            kycDetailInd.setDateofBirth(kycDetail.getDateofBirth());
            kycDetailInd.setRelatedPersonPrefix(kycDetail.getRelatedPersonPrefix());
            kycDetailInd.setRelatedPersonFirstName(kycDetail.getRelatedPersonFirstName());
            kycDetailInd.setRelatedPersonMiddleName(kycDetail.getRelatedPersonMiddleName());
            kycDetailInd.setRelatedPersonLastName(kycDetail.getRelatedPersonLastName());
            kycDetailInd.setRelationshipType(kycDetail.getRelationshipType());
            kycDetailInd.setMobileNumber(kycDetail.getMobileNumber());
            kycDetailInd.setEmailAddress(kycDetail.getEmailAddress());
            kycDetailInd.setAddressLine1(kycDetail.getAddressLine1());
            kycDetailInd.setCity(kycDetail.getCity());
            kycDetailInd.setDistrict(kycDetail.getDistrict());
            kycDetailInd.setState(kycDetail.getState());
            kycDetailInd.setCountry(kycDetail.getCountry());
            kycDetailInd.setPinCode(kycDetail.getPinCode());
            kycDetailInd.setCorrespondenceAddressLine1(kycDetail.getCorrespondenceAddressLine1());
            kycDetailInd.setCorrespondenceCity(kycDetail.getCorrespondenceCity());
            kycDetailInd.setCorrespondenceDistrict(kycDetail.getCorrespondenceDistrict());
            kycDetailInd.setCorrespondenceState(kycDetail.getCorrespondenceState());
            kycDetailInd.setCorrespondenceCountry(kycDetail.getCorrespondenceCountry());
            kycDetailInd.setCorrespondencePinCode(kycDetail.getCorrespondencePinCode());
            kycDetailInd.setKycDocuments(kycDocumentList);

            kycDetailIndRepository.save(kycDetailInd);
        } else {
            KycDetailLe kycDetailLe = new KycDetailLe();
            kycDetailLe.setClientType("LE");
            kycDetailLe.setFirstName(kycDetail.getFirstName());
            kycDetailLe.setDateofBirth(kycDetail.getDateofBirth());
            kycDetailLe.setMobileNumber(kycDetail.getMobileNumber());
            kycDetailLe.setEmailAddress(kycDetail.getEmailAddress());
            kycDetailLe.setAddressLine1(kycDetail.getAddressLine1());
            kycDetailLe.setCity(kycDetail.getCity());
            kycDetailLe.setDistrict(kycDetail.getDistrict());
            kycDetailLe.setState(kycDetail.getState());
            kycDetailLe.setCountry(kycDetail.getCountry());
            kycDetailLe.setPinCode(kycDetail.getPinCode());
            kycDetailLe.setCorrespondenceAddressLine1(kycDetail.getCorrespondenceAddressLine1());
            kycDetailLe.setCorrespondenceCity(kycDetail.getCorrespondenceCity());
            kycDetailLe.setCorrespondenceDistrict(kycDetail.getCorrespondenceDistrict());
            kycDetailLe.setCorrespondenceState(kycDetail.getCorrespondenceState());
            kycDetailLe.setCorrespondenceCountry(kycDetail.getCorrespondenceCountry());
            kycDetailLe.setCorrespondencePinCode(kycDetail.getCorrespondencePinCode());
            kycDetailLe.setKycDocuments(kycDocumentList);
            kycDetailLeRepository.save(kycDetailLe);
        }
        kycResponse.setStatus("200");
        result.setRecordCreated("Y");
        result.setDocumentStored("Y");
        kycResponse.setResult(result);
        return kycResponse;

    }


}