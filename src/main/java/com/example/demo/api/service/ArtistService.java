package com.example.demo.api.service;

import com.example.demo.api.Repository.ArtistRepository;
import com.example.demo.api.model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {
    @Autowired
    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public void createArtist(Artist artist) {
        artistRepository.save(artist);
    }
    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }
    public Optional<Artist> getArtistById(Long id) {
        return artistRepository.findById(id);
    }
    public Artist updateArtist(Long id, Artist artistDetails) {
        Artist artist = artistRepository.findById(id).orElseThrow(() -> new RuntimeException("Artist not found"));
        artist.setName(artistDetails.getName());
        artist.setAge(artistDetails.getAge());
        artist.setIsAlive(artistDetails.getIsAlive());
        return artistRepository.save(artist);
    }
    public void deleteArtist(Long id) {
        artistRepository.deleteById(id);
    }
}
