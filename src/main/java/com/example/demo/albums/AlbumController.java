package com.example.demo.albums;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/album")
public class AlbumController {

    private final AlbumServiceImpl albumService;

    @Autowired public AlbumController(AlbumServiceImpl albumService) {
        this.albumService = albumService;
    }

    @GetMapping
    public List<Album> getAlbums() {
        return albumService.getAlbums();
    }

    @PostMapping
    public void addAlbum(@RequestBody Album album) {
        albumService.addAlbum(album);
    }

    @DeleteMapping(path = "{id}")
    public void deleteAlbum(@PathVariable("id") Long id) {
        albumService.deleteAlbum(id);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Album> updateAlbum(@PathVariable("id") Long id, @RequestBody Album albumUpdates) {
        Album updatedAlbum = albumService.updateAlbum(id, albumUpdates);
        return ResponseEntity.ok(updatedAlbum);
    }

}
