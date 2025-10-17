package com.ksap.dto;

import lombok.Data;

@Data
public class EventLoaderDTO 
{
    private String SHIPMENT_ID;
    private String EVENT_DATE;
    private String STOP_SEQ;
    private String STATUS_CODE;
    private String REMARKS;
    private String SERVPROV_ALIAS_VALUE;
    private boolean editing;
}