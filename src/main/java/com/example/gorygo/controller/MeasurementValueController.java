package com.example.gorygo.controller;

import com.example.gorygo.model.MeasurementValue;
import com.example.gorygo.model.User;
import com.example.gorygo.service.MeasurementValueService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sizes")
public class MeasurementValueController {
    private final MeasurementValueService measurementValueService;

    @GetMapping
    public List<MeasurementValue> getAllUsers(Pageable pageable) {
        return measurementValueService.findAll(pageable);
    }

    @GetMapping(path = "/{id}")
    public MeasurementValue getUserById(@PathVariable Long id) {
        return measurementValueService.findById(id);
    }

    @GetMapping(path = "/list/{ids}")
    public List<MeasurementValue> getAllSizesByIds(@PathVariable Long[] ids) {
        return measurementValueService.getAllMeasurementValuesByIds(Arrays.stream(ids).toList());
    }

    @PostMapping
    public MeasurementValue createUser(@RequestBody MeasurementValue measurementValue) {
        return measurementValueService.save(measurementValue);
    }

    @PutMapping(path = "/{id}")
    public MeasurementValue updateUser(@PathVariable Long id, @RequestBody MeasurementValue measurementValue) {
        return measurementValueService.updateById(id, measurementValue);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteUser(@PathVariable Long id) {
        measurementValueService.deleteById(id);
    }
}
