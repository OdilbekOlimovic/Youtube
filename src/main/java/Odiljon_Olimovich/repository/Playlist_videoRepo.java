package Odiljon_Olimovich.repository;

import Odiljon_Olimovich.model.Playlist_video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Playlist_videoRepo extends JpaRepository<Playlist_video, Integer> {
    boolean existsById(Integer id);
}
