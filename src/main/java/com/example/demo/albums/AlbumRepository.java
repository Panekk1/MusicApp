package com.example.demo.albums;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlbumRepository
        extends JpaRepository<Album, Long> {

    @Query ("SELECT s FROM Album s WHERE s.title = ?1")
    Optional<Album> findByTitle(String title);
}