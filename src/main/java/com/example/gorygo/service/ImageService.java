package com.example.gorygo.service;

import com.example.gorygo.model.Image;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImageService {
    public Image save(MultipartFile file) throws IOException;

    Image findByName(String name)
            ;
    byte[] getImageBytesByName(String name) throws IOException;

    List<Image> findAll(Pageable pageable);

    Image updateById(Long id, Image image);

    void deleteById(Long id);
}
