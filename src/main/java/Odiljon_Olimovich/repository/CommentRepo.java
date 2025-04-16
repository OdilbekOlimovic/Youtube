package Odiljon_Olimovich.repository;

import Odiljon_Olimovich.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
    boolean existsById(Integer id);
}
