package com.hospital.monitoring.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Alert {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long patientId;
    private String severity;
    private String message;
    private LocalDateTime createdAt;
    private boolean acknowledged;

    public Alert(){}
    public Alert(Long patientId,String severity,String message,LocalDateTime createdAt){
        this.patientId=patientId;this.severity=severity;this.message=message;this.createdAt=createdAt;this.acknowledged=false;
    }
    public Long getId(){return id;}
    public Long getPatientId(){return patientId;}
    public String getSeverity(){return severity;}
    public String getMessage(){return message;}
    public LocalDateTime getCreatedAt(){return createdAt;}
    public boolean isAcknowledged(){return acknowledged;}
    public void setAcknowledged(boolean v){acknowledged=v;}
}