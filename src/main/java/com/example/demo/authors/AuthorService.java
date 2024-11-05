package com.example.demo.authors;

import java.util.List;

public interface AuthorService {
    List<Author> getAuthors(); // Metoda do pobierania listy autorów
    void addNewAuthor(Author author); // Metoda do dodawania nowego autora
    void deleteAuthor(Long authorId); // Metoda do usuwania autora na podstawie ID
    Author updateAuthor(Long authorId, Author updatedAuthor); // Metoda do aktualizacji danych autora
}
