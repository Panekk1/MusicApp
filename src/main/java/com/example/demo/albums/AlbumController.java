package com.example.demo.albums;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/album")
public class AlbumController {

    private final AlbumService albumService;

    @Autowired public AlbumController(AlbumService albumService) {
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

    @DeleteMapping
    public void deleteAlbum(@PathVariable("id") Long id) {
        albumService.deleteAlbum(id);
    }

    @PutMapping(path = "{id}")
    public void updateAlbum(@PathVariable("id") Long id, @RequestParam(required = false) String title, @RequestParam(required = false) String description) {
        albumService.updateAlbum(id, title, description);
    }

}
