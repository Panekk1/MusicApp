package com.example.demo.authors;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Author {
    @Id
    @SequenceGenerator(
            name = "author_sequence",
            sequenceName = "author_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "author_sequence"
    )
    private Integer id;
    private String name;
    private String hometown;
    private LocalDate born;
    private String genre;
    private String bio;
    private String social_media_links;

    public Author() {
    }

    public Author(Integer id, String name, String hometown, LocalDate born, String genre, String bio, String social_media_links) {
        this.id = id;
        this.name = name;
        this.hometown = hometown;
        this.born = born;
        this.genre = genre;
        this.bio = bio;
        this.social_media_links = social_media_links;
    }

    public Author(String name, String hometown, LocalDate born, String genre, String bio, String social_media_links) {
        this.name = name;
        this.hometown = hometown;
        this.born = born;
        this.genre = genre;
        this.bio = bio;
        this.social_media_links = social_media_links;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public LocalDate getBorn() {
        return born;
    }

    public void setBorn(LocalDate born) {
        this.born = born;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getSocial_media_links() {
        return social_media_links;
    }

    public void setSocial_media_links(String social_media_links) {
        this.social_media_links = social_media_links;
    }

    @Override
    public String toString() {
        return "Authors{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hometown='" + hometown + '\'' +
                ", born=" + born +
                ", genre='" + genre + '\'' +
                ", bio='" + bio + '\'' +
                ", social_media_links='" + social_media_links + '\'' +
                '}';
    }
}
