package com.example.gorygo.service.impl;

import com.example.gorygo.model.MeasurementValue;
import com.example.gorygo.repository.MeasurementValueRepository;
import com.example.gorygo.service.MeasurementValueService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MeasurementValueServiceImpl implements MeasurementValueService {
    private final MeasurementValueRepository measurementValueRepository;

    @Override
    public MeasurementValue save(MeasurementValue measurementValue) {
        return measurementValueRepository.save(measurementValue);
    }

    @Override
    public MeasurementValue findById(Long id) {
        return measurementValueRepository.findById(id).orElseThrow();
    }

    @Override
    public List<MeasurementValue> findAll(Pageable pageable) {
        return measurementValueRepository.findAll(pageable).stream().toList();
    }

    @Override
    public List<MeasurementValue> getAllMeasurementValuesByIds(List<Long> ids) {
        return measurementValueRepository.findAllById(ids);
    }

    @Override
    public MeasurementValue updateById(Long id, MeasurementValue measurementValue) {
        measurementValue.setId(id);
        return measurementValueRepository.save(measurementValue);
    }

    @Override
    public void deleteById(Long id) {
        measurementValueRepository.deleteById(id);
    }
}
