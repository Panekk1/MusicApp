package com.example.demo.albums;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Album {
    @Id
    @SequenceGenerator(
            name = "album_sequence",
            sequenceName = "album_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "album_sequence"
    )

    private int id;
    private int id_author;
    private boolean is_single;
    private String title;
    private String description;
    private String genre;
    private LocalDate year;

    public Album() {
    }

    public Album(int id, int id_author, boolean is_single, String title, String description, String genre, LocalDate year) {
        this.id = id;
        this.id_author = id_author;
        this.is_single = is_single;
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.year = year;
    }

    public Album(int id_author, boolean is_single, String title, String description, String genre, LocalDate year) {
        this.id_author = id_author;
        this.is_single = is_single;
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_author() {
        return id_author;
    }

    public void setId_author(int id_author) {
        this.id_author = id_author;
    }

    public boolean isIs_single() {
        return is_single;
    }

    public void setIs_single(boolean is_single) {
        this.is_single = is_single;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Albums{" +
                "id=" + id +
                ", id_author=" + id_author +
                ", is_single=" + is_single +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", genre='" + genre + '\'' +
                ", year=" + year +
                '}';
    }
}
