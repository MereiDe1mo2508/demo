package com.example.demo.api.service;

import com.example.demo.api.Repository.ArtworkRepository;
import com.example.demo.api.model.Artwork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtworkService {
    @Autowired
    private ArtworkRepository artworkRepository;

    public void createArtwork(Artwork artwork) {
        artworkRepository.save(artwork);
    }
    public List<Artwork> getAllArtworks() {
        return artworkRepository.findAll();
    }
    public Optional<Artwork> getArtworkById(Long id) {
        return artworkRepository.findById(id);
    }
    public Artwork updateArtwork(Long id, Artwork artworkDetails) {
        Artwork artwork = artworkRepository.findById(id).orElseThrow(() -> new RuntimeException("Artwork not found"));
        artwork.setTitle(artworkDetails.getTitle());
        artwork.setArtist(artworkDetails.getArtist());
        artwork.setDate(artworkDetails.getDate());
        artwork.setCopyrighted(artworkDetails.getCopyrighted());
        artwork.setPrice(artworkDetails.getPrice());
        return artworkRepository.save(artwork);
    }
    public void deleteArtwork(Long id) {
        artworkRepository.deleteById(id);
    }
}
