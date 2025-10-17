package com.ksap.repository;

import com.ksap.entity.StatusCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusCodeRepository extends JpaRepository<StatusCode, String> {
    boolean existsByCode(String code);
}
