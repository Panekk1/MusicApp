package com.example.demo.albums;

import java.util.List;

public interface AlbumService {
    List<Album> getAlbums();
    Album addAlbum(Album album);
    void deleteAlbum(Long id);
    Album updateAlbum(Long id, Album albumUpdates);
}