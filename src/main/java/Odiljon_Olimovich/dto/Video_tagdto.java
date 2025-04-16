package Odiljon_Olimovich.dto;

import Odiljon_Olimovich.model.Tag;
import Odiljon_Olimovich.model.Video;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Video_tagdto {
    @ManyToMany
    private Integer videos;
    @ManyToMany
    private Integer tags;
    @Column(nullable = false)
    private LocalDateTime created_Date;
}
