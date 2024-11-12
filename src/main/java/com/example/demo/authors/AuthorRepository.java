package com.example.demo.authors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findByName(String name);

    Optional<Author> findByFacebookLink(String facebookLink);

    Optional<Author> findByTwitterLink(String twitterLink);

    Optional<Author> findByInstagramLink(String instagramLink);

    Optional<Author> findByLinkedInLink(String linkedInLink);

    Optional<Author> findByYoutubeLink(String youtubeLink);
}
