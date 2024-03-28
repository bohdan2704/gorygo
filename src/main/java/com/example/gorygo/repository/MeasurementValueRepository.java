package com.example.gorygo.repository;

import com.example.gorygo.model.MeasurementValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementValueRepository extends JpaRepository<MeasurementValue, Long> {
}
