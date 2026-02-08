package com.example.demo.api.controller;
import com.example.demo.api.model.Artist;
import com.example.demo.api.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/artist")

public class ArtistController {
    @Autowired
    public ArtistService artistService;
    @GetMapping
    public List<Artist> getAllArtists(){
        return artistService.getAllArtists();
    }

    @GetMapping("/id")
    public ResponseEntity<Artist> getArtistById(@PathVariable Long id){
        Optional<Artist> artist = artistService.getArtistById(id);
        return artist.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public Artist createArtist(@RequestBody Artist newArtist) {
        artistService.createArtist(newArtist);
        return newArtist;
    }
    @PutMapping("/id")
    public ResponseEntity<Artist> updateArtist(@RequestBody Artist artistDetails, @PathVariable Long id) {
        Artist updatedArtist = artistService.updateArtist(id, artistDetails);
        return ResponseEntity.ok(updatedArtist);
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deleteArtist(@PathVariable Long id) {
        artistService.deleteArtist(id);
        return ResponseEntity.noContent().build();
    }
}
