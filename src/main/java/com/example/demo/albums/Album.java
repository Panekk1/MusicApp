package com.example.demo.albums;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.sound.midi.Track;
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
    private int id_author;
    private Boolean is_single;
    private String title;
    private String description;
    private String genre;
    private LocalDate year;

    public Album() {
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
