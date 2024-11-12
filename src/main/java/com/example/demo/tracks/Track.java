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
    @JoinColumn(name = "id", nullable = false)
    private Album album;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Author author;

    private int id_author;
    private int id_album;
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
                ", album=" + id_album +
                ", author=" + id_author +
                ", track_number=" + track_number +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", release_date=" + release_date +
                ", duration=" + duration +
                ", views=" + views +
                '}';
    }
}
