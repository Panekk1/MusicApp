package com.example.demo.tracks;

import com.example.demo.albums.Album;
import com.example.demo.authors.Author;
import com.fasterxml.jackson.annotation.JsonIgnore; // Import dla @JsonIgnore
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "track")
public class Track {

    @Id
    @SequenceGenerator(
            name = "track_sequence",
            sequenceName = "track_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "track_sequence"
    )
    private int id;

    @ManyToOne
    @JoinColumn(name = "album_id", nullable = false)  // Foreign key for Album
    private Album album;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)  // Foreign key for Author
    private Author author;

    @Column(name = "track_number")
    private int trackNumber;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "genre", length = 50)
    private String genre;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "duration")
    private int duration; // Duration in seconds

    @Column(name = "views")
    private int views;

    public Track() {
        // Default constructor
    }

    @Override
    public String toString() {
        return "Track{" +
                "id=" + id +
                ", album=" + (album != null ? album.getId() : null) +
                ", author=" + (author != null ? author.getId() : null) +
                ", trackNumber=" + trackNumber +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", releaseDate=" + releaseDate +
                ", duration=" + duration +
                ", views=" + views +
                '}';
    }

    // Możemy dodać @JsonIgnore, aby zapobiec zapętleniu przy serializacji
    @JsonIgnore
    public Album getAlbum() {
        return album;
    }

    @JsonIgnore
    public Author getAuthor() {
        return author;
    }
}
