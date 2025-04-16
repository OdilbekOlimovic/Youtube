package Odiljon_Olimovich.repository;

import Odiljon_Olimovich.model.Attach;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AttachRepo extends JpaRepository<Attach, UUID> {
}
