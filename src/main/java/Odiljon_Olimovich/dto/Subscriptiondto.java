package Odiljon_Olimovich.dto;

import Odiljon_Olimovich.model.Channel;
import Odiljon_Olimovich.model.Profile;
import Odiljon_Olimovich.model.entity.Status;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subscriptiondto {
    @ManyToMany
    private Integer profiles;
    @ManyToMany
    private Integer channels;
    @CreatedDate
    private LocalDateTime created_date;
    @CreatedDate
    private LocalDateTime unsubscribe_date;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(nullable = false)
    private String notification_type;
}
