package com.example.demo.tracks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/track")
public class TrackController {

    private final TrackServiceImpl trackService;

    @Autowired
    public TrackController(TrackServiceImpl trackService) {
        this.trackService = trackService;
    }

    @GetMapping
    public List<Track> getTracks() {
        return trackService.getTracks();
    }

    @PostMapping
    public void addTrack(@RequestBody Track track) {
        trackService.addTrack(track);
    }

    @DeleteMapping(path = "{id}")
    public void deleteTrack(@PathVariable("id") Long id) {
        trackService.deleteTrack(id);
    }

    @PutMapping(path = "{id}")
    public void updateTrack(@PathVariable("id") Long id, @RequestParam(required = false) String title) {
        trackService.updateTrack(id, title);
    }
}
