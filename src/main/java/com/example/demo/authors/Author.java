package com.example.demo.authors;

import com.example.demo.tracks.Track;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "author")
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

    private String facebookLink;
    private String twitterLink;
    private String instagramLink;
    private String linkedInLink;
    private String youtubeLink;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Track> tracks;

    public Author() {
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hometown='" + hometown + '\'' +
                ", born=" + born +
                ", genre='" + genre + '\'' +
                ", bio='" + bio + '\'' +
                ", facebookLink='" + facebookLink + '\'' +
                ", twitterLink='" + twitterLink + '\'' +
                ", instagramLink='" + instagramLink + '\'' +
                ", linkedInLink='" + linkedInLink + '\'' +
                ", youtubeLink='" + youtubeLink + '\'' +
                '}';
    }
}
