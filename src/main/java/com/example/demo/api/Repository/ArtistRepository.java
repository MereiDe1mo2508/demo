package com.example.demo.api.Repository;

import com.example.demo.api.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
    List<Artist> findFirstById(Long id);
}
