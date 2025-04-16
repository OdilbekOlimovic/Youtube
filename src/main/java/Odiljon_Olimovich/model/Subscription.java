package Odiljon_Olimovich.model;


import Odiljon_Olimovich.model.entity.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToMany
    private List<Profile> profiles;
    @ManyToMany
    private List<Channel> channels;
    @CreatedDate
    private LocalDateTime created_date;
    @CreatedDate
    private LocalDateTime unsubscribe_date;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(nullable = false)
    private String notification_type;
}
