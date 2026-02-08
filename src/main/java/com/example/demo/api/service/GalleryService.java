package com.example.demo.api.service;

import com.example.demo.api.Repository.GalleryRepository;
import com.example.demo.api.model.Gallery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GalleryService {
    @Autowired
    private final GalleryRepository galleryRepository;

    public GalleryService(GalleryRepository galleryRepository) {
        this.galleryRepository = galleryRepository;
    }

    public void createGallery(Gallery gallery) {
        galleryRepository.save(gallery);
    }
    public List<Gallery> getAllGalleries() {
        return  galleryRepository.findAll();
    }
    public Optional<Gallery> getGalleryById(Long id) {
        return galleryRepository.findById(id);
    }
    public Gallery updateGallery(Long id, Gallery galleryDetails) {
        Gallery gallery = galleryRepository.findById(id).orElseThrow(() -> new RuntimeException("Gallery not found"));
        gallery.setName(galleryDetails.getName());
        gallery.setLocation(galleryDetails.getLocation());
        return galleryRepository.save(gallery);
    }
    public void deleteGallery(Long id) {
        galleryRepository.deleteById(id);
    }

}
