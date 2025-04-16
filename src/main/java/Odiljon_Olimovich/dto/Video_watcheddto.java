package Odiljon_Olimovich.dto;


import Odiljon_Olimovich.model.Profile;
import Odiljon_Olimovich.model.Video;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Video_watcheddto {
    @ManyToMany
    private Integer profiles;
    @ManyToMany
    private Integer videos;
    @Column(nullable = false)
    private LocalDateTime created_Date;
}
