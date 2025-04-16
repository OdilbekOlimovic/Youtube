package Odiljon_Olimovich.repository;

import Odiljon_Olimovich.model.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ChannelRepo extends JpaRepository<Channel, Integer> {
   boolean existsById(Integer id);
}
