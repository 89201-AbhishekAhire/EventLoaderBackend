package com.ksap.entity;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAlias;

@Entity
@Data
public class EventLoader {
    @Id
    @JsonProperty("SHIPMENT_ID")
    @Column(name = "SHIPMENT_ID")
    private String SHIPMENT_ID;

    @JsonProperty("EVENT_DATE")
    @Column(name = "EVENT_DATE")
    private String EVENT_DATE;

    @JsonProperty("STOP_SEQ")
    @Column(name = "STOP_SEQ")
    private String STOP_SEQ;

    @JsonAlias({"statusCode", "STATUS_CODE"})
    @JsonProperty("STATUS_CODE")
    @Column(name = "STATUS_CODE")
    private String statusCode;

    @JsonProperty("REMARKS")
    @Column(name = "REMARKS")
    private String REMARKS;

    @JsonProperty("SERVPROV_ALIAS_VALUE")
    @Column(name = "SERVPROV_ALIAS_VALUE")
    private String SERVPROV_ALIAS_VALUE;

    @JsonProperty("editing")
    @Column(name = "editing")
    private Boolean editing;
}