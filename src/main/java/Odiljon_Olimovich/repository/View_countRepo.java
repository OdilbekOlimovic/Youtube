package Odiljon_Olimovich.repository;

import Odiljon_Olimovich.dto.View_countdto;
import Odiljon_Olimovich.model.View_count;
import org.springframework.data.jpa.repository.JpaRepository;

public interface View_countRepo extends JpaRepository<View_count, Integer> {
}
