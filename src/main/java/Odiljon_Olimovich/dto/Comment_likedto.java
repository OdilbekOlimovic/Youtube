package Odiljon_Olimovich.dto;


import Odiljon_Olimovich.model.Comment;
import Odiljon_Olimovich.model.Profile;
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
public class Comment_likedto {
    @ManyToMany
    private Integer profiles;
    @ManyToMany
    private Integer comments;
    @Column(nullable = false)
    private LocalDateTime created_date;
    @Column(nullable = false)
    private String type;
}
