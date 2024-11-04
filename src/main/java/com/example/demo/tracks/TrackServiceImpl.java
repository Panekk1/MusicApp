package com.example.demo.tracks;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class TrackServiceImpl implements TrackService {

    public final TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }
    public List<Track> getTracks() {
        return (List<Track>) trackRepository.findAll();
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
    public void updateTrack(Long id, String title) {
        Track track = trackRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Track not found"));

        if (title != null && title.length() > 0 && !Objects.equals(track.getTitle(), title)) {
            track.setTitle(title);
        }
    }
}
