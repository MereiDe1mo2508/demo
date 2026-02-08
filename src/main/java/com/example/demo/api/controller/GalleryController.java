package com.example.demo.api.controller;
import com.example.demo.api.model.Gallery;
import com.example.demo.api.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/gallery")
public class GalleryController {
    @Autowired
    private GalleryService galleryService;
    @GetMapping
    public List<Gallery> getAllGalleries() {
        return galleryService.getAllGalleries();
    }
    @GetMapping("/id")
    public ResponseEntity<Gallery> getGalleryById(@PathVariable Long id) {
        Optional<Gallery> artist = galleryService.getGalleryById(id);
        return artist.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public Gallery createGallery(@RequestBody Gallery newGallery) {
        galleryService.createGallery(newGallery);
        return newGallery;
    }
    @PutMapping("/id")
    public ResponseEntity<Gallery> updateGallery(@RequestBody Gallery galleryDetails, @PathVariable Long id) {
        Gallery updatedGallery = galleryService.updateGallery(id, galleryDetails);
        return ResponseEntity.ok(updatedGallery);
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deleteGallery(@PathVariable Long id) {
        galleryService.deleteGallery(id);
        return ResponseEntity.noContent().build();
    }
}
