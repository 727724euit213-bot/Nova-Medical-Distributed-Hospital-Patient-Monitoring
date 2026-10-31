package com.hospital.monitoring.service;

import com.hospital.monitoring.model.*;
import com.hospital.monitoring.repository.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class MonitoringService {
    private final PatientRepository patients;
    private final VitalReadingRepository readings;
    private final AlertRepository alerts;
    private final SimpMessagingTemplate messaging;

    public MonitoringService(PatientRepository patients,VitalReadingRepository readings,AlertRepository alerts,SimpMessagingTemplate messaging){
        this.patients=patients;this.readings=readings;this.alerts=alerts;this.messaging=messaging;
    }
    public List<Patient> patients(){return patients.findAll();}
    public List<Alert> alerts(){return alerts.findTop10ByOrderByCreatedAtDesc();}
    public List<VitalReading> history(Long id){return readings.findTop20ByPatientIdOrderByRecordedAtDesc(id);}
    public VitalReading ingest(VitalReading v){
        String status=(v.getHeartRate()>120||v.getHeartRate()<50||v.getSpo2()<90||v.getTemperature()>39)?"CRITICAL":
                (v.getHeartRate()>100||v.getSpo2()<94||v.getTemperature()>38)?"OBSERVE":"STABLE";
        VitalReading saved=new VitalReading(v.getPatientId(),v.getHeartRate(),v.getSpo2(),v.getTemperature(),v.getRespiratoryRate(),v.getBloodPressure(),status,LocalDateTime.now());
        readings.save(saved);
        patients.findById(v.getPatientId()).ifPresent(p->{p.setConditionStatus(status);patients.save(p);});
        if(status.equals("CRITICAL")){
            Alert a=alerts.save(new Alert(v.getPatientId(),"CRITICAL","Abnormal vital signs detected",LocalDateTime.now()));
            messaging.convertAndSend("/topic/alerts",a);
        }
        messaging.convertAndSend("/topic/vitals",saved);
        return saved;
    }
    public void seed(){
        if(patients.count()>0)return;
        patients.saveAll(List.of(
            new Patient("PT-1001","Arjun Menon",42,"Male","ICU-01","STABLE"),
            new Patient("PT-1002","Meera Krishnan",35,"Female","ICU-02","STABLE"),
            new Patient("PT-1003","Rahul Varma",58,"Male","ICU-04","CRITICAL"),
            new Patient("PT-1004","Ananya Rao",29,"Female","WARD-12","OBSERVE")
        ));
        for(Patient p:patients.findAll()){
            int hr=p.getPatientCode().equals("PT-1003")?132:82;
            double sp=p.getPatientCode().equals("PT-1003")?85:97;
            ingest(new VitalReading(p.getId(),hr,sp,37.0,18,"120/80","",LocalDateTime.now()));
        }
    }
}