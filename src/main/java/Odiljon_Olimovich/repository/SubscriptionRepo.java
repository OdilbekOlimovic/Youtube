package Odiljon_Olimovich.repository;

import Odiljon_Olimovich.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepo extends JpaRepository<Subscription, Integer> {
    boolean existsById(Integer id);
}
