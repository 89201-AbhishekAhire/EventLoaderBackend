package com.ksap.service;

import com.ksap.entity.StatusCode;
import com.ksap.repository.StatusCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusCodeService {
    @Autowired
    private StatusCodeRepository statusCodeRepository;

    public List<StatusCode> getAllStatusCodes() {
        return statusCodeRepository.findAll();
    }
}
