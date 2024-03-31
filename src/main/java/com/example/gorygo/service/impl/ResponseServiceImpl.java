package com.example.gorygo.service.impl;

import com.example.gorygo.model.Response;
import com.example.gorygo.repository.ResponseRepository;
import com.example.gorygo.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ResponseServiceImpl implements ResponseService {
    private final ResponseRepository responseRepository;

    @Override
    public Response save(Response response) {
        return responseRepository.save(response);
    }

    @Override
    public Response findById(Long id) {
        return responseRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Response> findAll(Pageable pageable) {
        return responseRepository.findAll(pageable).stream().toList();
    }

    @Override
    public Response updateById(Long id, Response response) {
        response.setId(id);
        return responseRepository.save(response);
    }

    @Override
    public void deleteById(Long id) {
        responseRepository.deleteById(id);
    }
}
