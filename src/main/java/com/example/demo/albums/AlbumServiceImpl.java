package com.example.demo.albums;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class AlbumServiceImpl implements AlbumService {

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
    public Album updateAlbum(Long id, Album albumUpdates) {
        Album album = albumRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Album does not exist"));

        if (!Objects.equals(albumUpdates.getId_author(), album.getId_author())) {
            album.setId_author(albumUpdates.getId_author());
        }

        if (albumUpdates.getIs_single() != null) {
            album.setIs_single(albumUpdates.getIs_single());
        }

        if (!Objects.equals(albumUpdates.getTitle(), album.getTitle())) {
            album.setTitle(albumUpdates.getTitle());
        }

        if (!Objects.equals(albumUpdates.getDescription(), album.getDescription())) {
            album.setDescription(albumUpdates.getDescription());
        }

        if (!Objects.equals(albumUpdates.getGenre(), album.getGenre())) {
            album.setGenre(albumUpdates.getGenre());
        }

        if (!Objects.equals(albumUpdates.getYear(), album.getYear())) {
            album.setYear(albumUpdates.getYear());
        }

        return albumRepository.save(album);
    }
}
