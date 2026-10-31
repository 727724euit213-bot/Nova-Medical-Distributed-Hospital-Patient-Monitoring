package com.hospital.monitoring.model;

import jakarta.persistence.*;

@Entity
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patientCode;
    private String name;
    private int age;
    private String gender;
    private String room;
    private String conditionStatus;

    public Patient() {}
    public Patient(String patientCode, String name, int age, String gender, String room, String conditionStatus) {
        this.patientCode=patientCode; this.name=name; this.age=age; this.gender=gender; this.room=room; this.conditionStatus=conditionStatus;
    }
    public Long getId(){return id;}
    public String getPatientCode(){return patientCode;}
    public void setPatientCode(String v){patientCode=v;}
    public String getName(){return name;}
    public void setName(String v){name=v;}
    public int getAge(){return age;}
    public void setAge(int v){age=v;}
    public String getGender(){return gender;}
    public void setGender(String v){gender=v;}
    public String getRoom(){return room;}
    public void setRoom(String v){room=v;}
    public String getConditionStatus(){return conditionStatus;}
    public void setConditionStatus(String v){conditionStatus=v;}
}