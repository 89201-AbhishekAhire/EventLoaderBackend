package com.ksap.controller;

import com.ksap.entity.StatusCode;
import com.ksap.service.StatusCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/status-codes")
@CrossOrigin(origins = "*") 
public class StatusCodeController {
    @Autowired
    private StatusCodeService statusCodeService;

    @GetMapping
    public List<StatusCode> getAllStatusCodes() {
        return statusCodeService.getAllStatusCodes();
    }
}
