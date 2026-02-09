package com.example.demo.api.controller;
import com.example.demo.api.Repository.GalleryRepository;
import com.example.demo.api.model.GalleryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/gallery")

public class GalleryController {
    @Autowired
    private final GalleryRepository galleryRepository;

    public GalleryController(GalleryRepository galleryRepository) {
        this.galleryRepository = galleryRepository;
    }

    @GetMapping
    public List<GalleryDto> getAllGalleries() throws SQLException {
        return galleryRepository.findAll();
    }

    @PostMapping
    public String createGallery(@RequestBody GalleryDto newGallery) throws SQLException{
        galleryRepository.save(newGallery);
        return "New gallery added";
    }

    @PutMapping("/id")
    public String updateGallery(@PathVariable Long id, @RequestBody GalleryDto galleryDetails) throws SQLException {
        int rows = galleryRepository.updateById(id, galleryDetails);
        return (rows > 0) ? "Gallery updated" : "Gallery not found";
    }

    @DeleteMapping("/id")
    public String deleteGallery(@PathVariable Long id) throws SQLException{
        int rows = galleryRepository.deleteById(id);
        return (rows > 0) ? "Gallery deleted" : "Gallery not found";
    }
}