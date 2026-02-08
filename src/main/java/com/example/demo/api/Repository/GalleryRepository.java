package com.example.demo.api.Repository;

import com.example.demo.api.model.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GalleryRepository extends JpaRepository<Gallery, Long> {
    List<Gallery> findFirstById(Long id);
}
