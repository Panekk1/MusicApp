package com.example.demo.authors;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public void addNewAuthor(Author author) {
        Optional<Author> authorsOptional = authorRepository.findBySocialMedia(author.getSocial_media_links());
        if (authorsOptional.isPresent()) {
            throw new IllegalArgumentException("Author already exists");
        }
        authorRepository.save(author);
    }

    public void deleteAuthor(Long authorId) {
        boolean exists = authorRepository.existsById(authorId);
        if (!exists) {
            throw new IllegalArgumentException("Author with id" + authorId + "does not exist");
        }
        authorRepository.deleteById(authorId);
    }

    @Transactional
    public void updateAuthor(Long authorId, String name, String social_media_links) {
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new IllegalArgumentException("Author with id" + authorId + "does not exist"));

        if (name != null && name.length() > 0 && !Objects.equals(author.getName(), name)) {
            author.setName(name);
        }

        if (social_media_links != null && social_media_links.length() > 0 && !Objects.equals(author.getSocial_media_links(), social_media_links)) {
            Optional<Author> authorsOptional = authorRepository.findBySocialMedia(social_media_links);
            if (authorsOptional.isPresent()) {
                throw new IllegalArgumentException("Author already exists");
            }
            author.setSocial_media_links(social_media_links);
        }
    }
}
