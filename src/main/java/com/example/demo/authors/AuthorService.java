package com.example.demo.authors;

import java.util.List;

public interface AuthorService {
    List<Author> getAuthors();
    void addNewAuthor(Author author);
    void deleteAuthor(Long authorId);
    void updateAuthor(Long authorId, String name, String social_media_links);
}