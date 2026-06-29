package com.itgi.repository;

import com.itgi.entity.KycDetailInd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface KycDetailIndRepository extends JpaRepository<KycDetailInd,Long> {

    KycDetailInd findByIdNumber(Long idNumber);
    @Query(value = "SELECT * FROM KYC_DETAIL_IND  WHERE FIRST_NAME = ?1 and DATEOF_BIRTH  = ?2", nativeQuery = true)
    KycDetailInd finByKycDetailReqInd(String fame,String dateOfBirth);


    @Query("SELECT k FROM KycDetailInd k JOIN k.kycDocuments d WHERE " +
            "k.firstName = :firstName AND " +
            "k.dateofBirth = :dateofBirth AND " +
            "d.idNumber = :idNumber AND " +
            "d.idType = :idType AND " +
            "k.clientType = :clientType")
    KycDetailInd findByCriteria(@Param("firstName") String firstName,
                                      @Param("dateofBirth") String dateofBirth,
                                      @Param("idNumber") String idNumber,
                                      @Param("idType") String idType,
                                      @Param("clientType") String clientType);




}
