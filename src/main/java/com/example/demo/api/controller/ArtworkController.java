package com.example.demo.api.controller;
import com.example.demo.api.model.Artwork;
import com.example.demo.api.service.ArtworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/artwork")

public class ArtworkController {
    @Autowired
    public ArtworkService artworkService;
    @GetMapping
    public List<Artwork> getAllArtworks() {
        return artworkService.getAllArtworks();
    }

    @GetMapping("/id")
    public ResponseEntity<Artwork> getArtworkById(@PathVariable Long id){
        Optional<Artwork> artwork = artworkService.getArtworkById(id);
        return artwork.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Artwork createArtwork(@RequestBody Artwork newArtwork) {
        artworkService.createArtwork(newArtwork);
        return newArtwork;
    }

    @PutMapping("/id")
    public ResponseEntity<Artwork> updateArtwork(@RequestBody Artwork artworkDetails, @PathVariable Long id) {
        Artwork updatedArtist = artworkService.updateArtwork(id, artworkDetails);
        return ResponseEntity.ok(updatedArtist);
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deleteArtwork(@PathVariable Long id) {
        artworkService.deleteArtwork(id);
        return ResponseEntity.noContent().build();
    }
}