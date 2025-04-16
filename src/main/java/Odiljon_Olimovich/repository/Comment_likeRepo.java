package Odiljon_Olimovich.repository;

import Odiljon_Olimovich.model.Comment_like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Comment_likeRepo extends JpaRepository<Comment_like, Integer> {
    boolean existsById(Integer id);
}
