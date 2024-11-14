package com.example.demo.albums;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.example.demo.tracks.Track;
import com.fasterxml.jackson.annotation.JsonIgnore;  // Import dla @JsonIgnore

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "album")
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

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore  // Ignorowanie tego pola przy serializacji
    private List<Track> tracks;

    private int id_author;
    private Boolean is_single;
    private String title;
    private String description;
    private String genre;
    private LocalDate releaseYear;

    public Album() {
        // Default constructor
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", id_author=" + id_author +
                ", is_single=" + is_single +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", genre='" + genre + '\'' +
                ", releaseYear=" + releaseYear +
                '}';
    }
}
