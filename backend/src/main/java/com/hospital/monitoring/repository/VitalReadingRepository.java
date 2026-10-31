package com.hospital.monitoring.repository;
import com.hospital.monitoring.model.VitalReading;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface VitalReadingRepository extends JpaRepository<VitalReading,Long> {
    List<VitalReading> findTop20ByPatientIdOrderByRecordedAtDesc(Long patientId);
}