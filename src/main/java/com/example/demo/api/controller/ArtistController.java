package com.example.demo.api.controller;
import com.example.demo.api.Repository.ArtistRepository;
import com.example.demo.api.model.ArtistDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/artist")

public class ArtistController {
    @Autowired
    private final ArtistRepository artistRepository;

    public ArtistController(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @GetMapping
    public List<ArtistDto> getAllArtists() throws SQLException {
        return artistRepository.findAll();
    }

    @PostMapping
    public String createArtist(@RequestBody ArtistDto newArtist) throws SQLException{
        artistRepository.save(newArtist);
        return "New artist added";
    }

    @PutMapping("/id")
    public String updateArtist(@PathVariable Long id, @RequestBody ArtistDto artistDetails) throws SQLException {
        int rows = artistRepository.updateById(id, artistDetails);
        return (rows > 0) ? "Artwork updated" : "Artwork not found";
    }

    @DeleteMapping("/id")
    public String deleteArtist(@PathVariable Long id) throws SQLException{
        int rows = artistRepository.deleteById(id);
        return (rows > 0) ? "Artwork deleted" : "Artwork not found";
    }
}