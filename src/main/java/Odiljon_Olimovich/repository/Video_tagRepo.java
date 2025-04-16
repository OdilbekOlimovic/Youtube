package Odiljon_Olimovich.repository;

import Odiljon_Olimovich.model.Video_tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Video_tagRepo extends JpaRepository<Video_tag, Integer> {
    boolean existsById(Integer id);
}
