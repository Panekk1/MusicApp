package com.example.demo.tracks;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
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

    public Track(int id, int id_author, int id_album, int track_number, String title, String genre, LocalDate release_date, int duration, int views) {
        this.id = id;
        this.id_author = id_author;
        this.id_album = id_album;
        this.track_number = track_number;
        this.title = title;
        this.genre = genre;
        this.release_date = release_date;
        this.duration = duration;
        this.views = views;
    }

    public Track(int id_author, int id_album, int track_number, String title, String genre, LocalDate release_date, int duration, int views) {
        this.id_author = id_author;
        this.id_album = id_album;
        this.track_number = track_number;
        this.title = title;
        this.genre = genre;
        this.release_date = release_date;
        this.duration = duration;
        this.views = views;
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

    public int getId_album() {
        return id_album;
    }

    public void setId_album(int id_album) {
        this.id_album = id_album;
    }

    public int getTrack_number() {
        return track_number;
    }

    public void setTrack_number(int track_number) {
        this.track_number = track_number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getRelease_date() {
        return release_date;
    }

    public void setRelease_date(LocalDate release_date) {
        this.release_date = release_date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    @Override
    public String toString() {
        return "Tracks{" +
                "id=" + id +
                ", id_author=" + id_author +
                ", id_album=" + id_album +
                ", track_number=" + track_number +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", release_date=" + release_date +
                ", duration=" + duration +
                ", views=" + views +
                '}';
    }
}
