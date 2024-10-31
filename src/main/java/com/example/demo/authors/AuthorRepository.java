package com.example.demo.authors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository
        extends JpaRepository<Author, Long> {

    @Query ("SELECT s FROM Author s WHERE s.social_media_links = ?1")
    Optional<Author> findBySocialMedia(String socialMedia);
}
