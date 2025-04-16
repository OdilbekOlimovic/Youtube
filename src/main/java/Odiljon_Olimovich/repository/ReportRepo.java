package Odiljon_Olimovich.repository;

import Odiljon_Olimovich.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepo extends JpaRepository<Report, Integer> {
    boolean existsById(Integer id);
}
