package Odiljon_Olimovich.repository;

import Odiljon_Olimovich.model.Video_watched;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface Video_watchedRepo extends JpaRepository<Video_watched, Integer> {
    boolean existsById(Integer id);
}
