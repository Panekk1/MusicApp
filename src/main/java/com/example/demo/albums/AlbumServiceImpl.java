package com.example.demo.albums;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class AlbumServiceImpl {

    private final AlbumRepository albumRepository;

    @Autowired
    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }
    public List<Album> getAlbums() {
        return albumRepository.findAll();
    }

    public void addAlbum(Album album) {
        Optional<Album> albumsOptional = albumRepository.findByTitle(album.getTitle());
        if (albumsOptional.isPresent()) {
            throw new IllegalArgumentException("Album already exists");
        }
        albumRepository.save(album);
    }

    public void deleteAlbum(Long id) {
        boolean exists = albumRepository.existsById(id);
        if (!exists) {
            throw new IllegalArgumentException("Album does not exist");
        }
        albumRepository.deleteById(id);
    }

    @Transactional
    public void updateAlbum(Long id, String title, String description) {
        Album album = albumRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Album does not exist"));

        if (description !=null && description.length()> 0 && !Objects.equals(album.getDescription(), description)) {
            album.setDescription(description);
        }

        if (title !=null && title.length() > 0 && !Objects.equals(album.getTitle(), title)) {
            Optional<Album> albumsOptional = albumRepository.findByTitle(title);
            if (albumsOptional.isPresent()) {
                throw new IllegalArgumentException("Album already exists");
            }
            album.setTitle(title);
        }
    }
}
