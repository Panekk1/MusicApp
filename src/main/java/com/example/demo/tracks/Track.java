package com.example.demo.tracks;

import com.example.demo.albums.Album;
import com.example.demo.authors.Author;
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
    @JoinColumn(name = "album_id", nullable = false)  // Foreign key column for Album
    private Album album;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)  // Foreign key column for Author
    private Author author;

    private int track_number;
    private String title;
    private String genre;
    private LocalDate release_date;
    private int duration;
    private int views;

    public Track() {
    }

    @Override
    public String toString() {
        return "Track{" +
                "id=" + id +
                ", album=" + (album != null ? album.getId() : null) +
                ", author=" + (author != null ? author.getId() : null) +
                ", track_number=" + track_number +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", release_date=" + release_date +
                ", duration=" + duration +
                ", views=" + views +
                '}';
    }
}
