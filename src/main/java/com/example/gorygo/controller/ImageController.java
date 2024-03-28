package com.example.gorygo.controller;

import com.example.gorygo.model.Image;
import com.example.gorygo.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/images")
public class ImageController {
    private final ImageService imageService;

    @GetMapping(path = "/{name}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<?> getImageByName(@PathVariable String name) {
        try {
            if (imageService.findByName(name) == null) {
                return ResponseEntity.notFound().build();
            }
            byte[] imageInBytes = imageService.getImageBytesByName(name);
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageInBytes);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Error when reading image from filesystem" + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file) {
        try {
            Image savedImage = imageService.save(file);
            URI uri = URI.create(savedImage.getNaming());
            return ResponseEntity.created(uri).body(savedImage);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Error when saving image to filesystem" + e.getMessage());
        }
    }
}
