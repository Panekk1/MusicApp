package com.example.demo.tracks;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrackRepository
        extends CrudRepository<Track, Long> {

    @Query ("SELECT s FROM Track s WHERE s.title = ?1")
    Optional<Track> findByTitle(String title);
}
