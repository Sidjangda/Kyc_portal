package com.itgi.repository;

import com.itgi.entity.KycDetailInd;
import com.itgi.entity.KycDetailLe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface KycDetailLeRepository extends JpaRepository<KycDetailLe,Long> {
    KycDetailLe findByIdNumber(Long idNumber);
    @Query(value = "SELECT * FROM KycDetailLe WHERE firstName = ?1 and dateofBirth = ?2", nativeQuery = true)
    KycDetailLe finByKycDetailLe(String fname,String dateOfBirth);
    @Query("SELECT k FROM KycDetailLe k JOIN k.kycDocuments d WHERE " +
            "k.firstName = :firstName AND " +
            "k.dateofBirth = :dateofBirth AND " +
           "d.idNumber = :idNumber AND " +
            "d.idType = :idType AND " +
            "k.clientType = :clientType")
    KycDetailLe findByCriteria(@Param("firstName") String firstName,
                               @Param("dateofBirth") String dateofBirth,
                               @Param("idNumber") String idNumber,
                               @Param("idType") String idType,
                               @Param("clientType") String clientType);
}
