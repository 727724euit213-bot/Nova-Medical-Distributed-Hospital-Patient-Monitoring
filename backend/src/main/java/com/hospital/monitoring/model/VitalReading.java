package com.hospital.monitoring.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class VitalReading {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long patientId;
    private int heartRate;
    private double spo2;
    private double temperature;
    private int respiratoryRate;
    private String bloodPressure;
    private String status;
    private LocalDateTime recordedAt;

    public VitalReading(){}
    public VitalReading(Long patientId,int heartRate,double spo2,double temperature,int respiratoryRate,String bloodPressure,String status,LocalDateTime recordedAt){
        this.patientId=patientId;this.heartRate=heartRate;this.spo2=spo2;this.temperature=temperature;this.respiratoryRate=respiratoryRate;this.bloodPressure=bloodPressure;this.status=status;this.recordedAt=recordedAt;
    }
    public Long getId(){return id;}
    public Long getPatientId(){return patientId;}
    public int getHeartRate(){return heartRate;}
    public double getSpo2(){return spo2;}
    public double getTemperature(){return temperature;}
    public int getRespiratoryRate(){return respiratoryRate;}
    public String getBloodPressure(){return bloodPressure;}
    public String getStatus(){return status;}
    public LocalDateTime getRecordedAt(){return recordedAt;}
}