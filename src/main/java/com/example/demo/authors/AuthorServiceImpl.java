package com.example.demo.authors;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public void addNewAuthor(Author author) {
        Optional<Author> authorsOptional = authorRepository.findByName(author.getName());
        if (authorsOptional.isPresent()) {
            throw new IllegalArgumentException("Author already exists");
        }
        authorRepository.save(author);
    }

    public void deleteAuthor(Long id) {
        boolean exists = authorRepository.existsById(id);
        if (!exists) {
            throw new IllegalArgumentException("Author with id " + id + " does not exist");
        }
        authorRepository.deleteById(id);
    }

    @Transactional
    public Author updateAuthor(Long id, Author authorUpdates) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Author does not exist"));

        if (!Objects.equals(authorUpdates.getName(), author.getName())) {
            author.setName(authorUpdates.getName());
        }

        if (!Objects.equals(authorUpdates.getHometown(), author.getHometown())) {
            author.setHometown(authorUpdates.getHometown());
        }

        if (!Objects.equals(authorUpdates.getBorn(), author.getBorn())) {
            author.setBorn(authorUpdates.getBorn());
        }

        if (!Objects.equals(authorUpdates.getGenre(), author.getGenre())) {
            author.setGenre(authorUpdates.getGenre());
        }

        if (!Objects.equals(authorUpdates.getBio(), author.getBio())) {
            author.setBio(authorUpdates.getBio());
        }

        if (!Objects.equals(authorUpdates.getFacebookLink(), author.getFacebookLink())) {
            author.setFacebookLink(authorUpdates.getFacebookLink());
        }

        if (!Objects.equals(authorUpdates.getTwitterLink(), author.getTwitterLink())) {
            author.setTwitterLink(authorUpdates.getTwitterLink());
        }

        if (!Objects.equals(authorUpdates.getInstagramLink(), author.getInstagramLink())) {
            author.setInstagramLink(authorUpdates.getInstagramLink());
        }

        if (!Objects.equals(authorUpdates.getLinkedInLink(), author.getLinkedInLink())) {
            author.setLinkedInLink(authorUpdates.getLinkedInLink());
        }

        if (!Objects.equals(authorUpdates.getYoutubeLink(), author.getYoutubeLink())) {
            author.setYoutubeLink(authorUpdates.getYoutubeLink());
        }

        return authorRepository.save(author);
    }
}
