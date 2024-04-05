package com.example.gorygo.service.impl;

import com.example.gorygo.info.StaticValues;
import com.example.gorygo.model.Image;
import com.example.gorygo.model.MeasurementValue;
import com.example.gorygo.repository.ImageRepository;
import com.example.gorygo.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.NoSuchFileException;
import java.time.LocalDateTime;
import java.util.List;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;

    @Override
    public Image save(MultipartFile file) throws IOException {
//        System.out.println(file.getOriginalFilename());
//        System.out.println(file.getName());
//        System.out.println(file.getContentType());
//        System.out.println(file.getResource());
        Path fileNameAndPath = Paths.get(StaticValues.UPLOAD_IMG_DIRECTORY, file.getOriginalFilename());
        Files.write(fileNameAndPath, file.getBytes());
        Image image = new Image();
//        image.setCreatedAt(LocalDateTime.now());
        image.setNaming(file.getOriginalFilename());
        return imageRepository.save(image);

    }

    @Override
    public Image findById(Long id) {
        return imageRepository.findById(id).orElseThrow();
    }

    @Override
    public Image findByName(String name) {
        return imageRepository.findByNaming(name);
    }

    @Override
    public byte[] getImageBytesByName(String name) throws IOException {
        InputStream imgAsStream = getClass().getResourceAsStream("/img/" + name);
        return imgAsStream.readAllBytes();
    }

    @Override
    public List<Image> findAll(Pageable pageable) {
        return imageRepository.findAll(pageable).stream().toList();
    }

    @Override
    public Image updateById(Long id, Image image) {
        image.setId(id);
        return imageRepository.save(image);
    }

    @Override
    public void deleteById(Long id) {
        imageRepository.deleteById(id);
    }

    @Override
    public List<Image> getAllImagesByIds(List<Long> list) {
        return imageRepository.findAllById(list);
    }
}
