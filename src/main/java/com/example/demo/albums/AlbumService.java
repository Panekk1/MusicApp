package com.example.demo.albums;

import java.util.List;

public interface AlbumService {
    List<Album> getAlbums();
    void addNewUser(Album album);
    void deleteAlbum(Long id);
    void updateAlbum(Long id, String title, String description);
}