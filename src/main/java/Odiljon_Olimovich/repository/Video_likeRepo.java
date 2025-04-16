package Odiljon_Olimovich.repository;

import Odiljon_Olimovich.model.Video_like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Video_likeRepo extends JpaRepository<Video_like, Integer> {
    boolean existsById(Integer id);
}
