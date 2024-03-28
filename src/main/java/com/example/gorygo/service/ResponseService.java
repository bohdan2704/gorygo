package com.example.gorygo.service;

import com.example.gorygo.model.Response;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ResponseService {
    Response save(Response response);

    Response findById(Long id);

    List<Response> findAll(Pageable pageable);

    Response updateById(Long id, Response response);

    void deleteById(Long id);
}
