package com.itgi.repository;

import com.itgi.entity.KycDetailInd;
import com.itgi.entity.KycDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KycDocumentRepository extends JpaRepository<KycDocument, Long> {
    KycDocument findByIdNumber(String idNumber);

}
