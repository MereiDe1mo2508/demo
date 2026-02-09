package com.example.demo.api.controller;
import com.example.demo.api.Repository.ArtworkRepository;
import com.example.demo.api.model.ArtworkDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/artwork")

public class ArtworkController {
    @Autowired
    private final ArtworkRepository artworkRepository;

    public ArtworkController(ArtworkRepository artworkRepository) {
        this.artworkRepository = artworkRepository;
    }

    @GetMapping
    public List<ArtworkDto> getAllArtworks() throws SQLException {
        return artworkRepository.findAll();
    }

    @PostMapping
    public String createArtwork(@RequestBody ArtworkDto newArtwork) throws SQLException{
        artworkRepository.save(newArtwork);
        return "New artwork added";
    }

    @PutMapping("/id")
    public String updateArtwork(@PathVariable Long id, @RequestBody ArtworkDto artworkDetails) throws SQLException {
        int rows = artworkRepository.updateById(id, artworkDetails);
        return (rows > 0) ? "Artwork updated" : "Artwork not found";
    }

    @DeleteMapping("/id")
    public String deleteArtwork(@PathVariable Long id) throws SQLException{
        int rows = artworkRepository.deleteById(id);
        return (rows > 0) ? "Artwork deleted" : "Artwork not found";
    }
}