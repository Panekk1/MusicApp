package com.example.demo.authors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/author")
public class AuthorController {

    private final AuthorServiceImpl authorService;

    @Autowired
    public AuthorController(AuthorServiceImpl authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }

    @PostMapping
    public void registerAuthor(@RequestBody Author author) {
        authorService.addNewAuthor(author);
    }

    @DeleteMapping(path = "{id}")
    public void deleteAuthor(@PathVariable("id") Long id) {
        authorService.deleteAuthor(id);
    }

    @PutMapping(path = "{id}")
    public void updateAuthor(@PathVariable("id") Long id, @RequestParam(required = false) String name, @RequestParam(required = false) String social_media_links) {
        authorService.updateAuthor(id, name, social_media_links);
    }
}
