package com.hospital.monitoring.repository;
import com.hospital.monitoring.model.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface AlertRepository extends JpaRepository<Alert,Long> {
    List<Alert> findTop10ByOrderByCreatedAtDesc();
}