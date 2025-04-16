package Odiljon_Olimovich.dto;

import Odiljon_Olimovich.model.Profile;
import Odiljon_Olimovich.model.Video;
import jakarta.persistence.Column;
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
public class Video_likedto {
    @ManyToMany
    private Integer profiles;
    @ManyToMany
    private Integer videos;
    @CreatedDate
    private LocalDateTime created_date;
    @Column(nullable = false)
    private String type;
}
