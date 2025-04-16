package Odiljon_Olimovich.repository;

import Odiljon_Olimovich.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepo extends JpaRepository<Video, Integer> {
    boolean existsById(Integer id);
}
