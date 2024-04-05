package com.example.gorygo.service;

import com.example.gorygo.model.MeasurementValue;
import com.example.gorygo.model.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MeasurementValueService {
    MeasurementValue save(MeasurementValue createBookDto);

    MeasurementValue findById(Long id);

    List<MeasurementValue> findAll(Pageable pageable);

    List<MeasurementValue> getAllMeasurementValuesByIds(List<Long> id);

    MeasurementValue updateById(Long id, MeasurementValue createBookDto);

    void deleteById(Long id);
}
