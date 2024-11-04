package com.example.demo.tracks;

import java.util.List;

public interface TrackService {
    List<Track> getTracks();
    void addTrack(Track track);
    void deleteTrack(Long id);
    void updateTrack(Long id, String title);
}