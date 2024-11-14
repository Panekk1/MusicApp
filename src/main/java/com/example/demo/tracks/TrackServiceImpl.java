package com.example.demo.tracks;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class TrackServiceImpl implements TrackService {

    private final TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public List<Track> getTracks() {
        return StreamSupport.stream(trackRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public void addTrack(Track track) {
        Optional<Track> tracksOptional = trackRepository.findByTitle(track.getTitle());
        if (tracksOptional.isPresent()) {
            throw new IllegalArgumentException("Track already exists");
        }
        trackRepository.save(track);
    }

    public void deleteTrack(Long id) {
        boolean exists = trackRepository.existsById(id);
        if (!exists) {
            throw new IllegalArgumentException("Track does not exist");
        }
        trackRepository.deleteById(id);
    }

    @Transactional
    public Track updateTrack(Long id, Track trackUpdates) {
        Track track = trackRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Track not found"));

        if (!Objects.equals(trackUpdates.getAlbum(), track.getAlbum())) {
            track.setAlbum(trackUpdates.getAlbum());
        }

        if (!Objects.equals(trackUpdates.getAuthor(), track.getAuthor())) {
            track.setAuthor(trackUpdates.getAuthor());
        }

        if (!Objects.equals(trackUpdates.getTrack_number(), track.getTrack_number())) {
            track.setTrack_number(trackUpdates.getTrack_number());
        }

        if (!Objects.equals(trackUpdates.getTitle(), track.getTitle())) {
            track.setTitle(trackUpdates.getTitle());
        }

        if (!Objects.equals(trackUpdates.getGenre(), track.getGenre())) {
            track.setGenre(trackUpdates.getGenre());
        }

        if (!Objects.equals(trackUpdates.getRelease_date(), track.getRelease_date())) {
            track.setRelease_date(trackUpdates.getRelease_date());
        }

        if (!Objects.equals(trackUpdates.getDuration(), track.getDuration())) {
            track.setDuration(trackUpdates.getDuration());
        }

        if (!Objects.equals(trackUpdates.getViews(), track.getViews())) {
            track.setViews(trackUpdates.getViews());
        }

        return trackRepository.save(track);
    }

    @Transactional
    public void updateTrackViews(Long id, int views) {
        Track track = trackRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Track not found"));

        if (views >= 0) {
            track.setViews(views);
        }
    }
}
