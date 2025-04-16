package Odiljon_Olimovich.repository;

import Odiljon_Olimovich.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlaylistRepo extends JpaRepository<Playlist, Integer> {
    boolean existsById(Integer id);
}
