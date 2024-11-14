package com.example.demo.tracks;

import java.util.List;

public interface TrackService {
    List<Track> getTracks();
    Track addTrack(Track track);
    void deleteTrack(Long id);
    Track updateTrack(Long id, Track trackUpdates);
    void updateTrackViews(Long id, int views);
}