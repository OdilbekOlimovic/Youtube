package Odiljon_Olimovich.dto;


import Odiljon_Olimovich.model.Profile;
import Odiljon_Olimovich.model.Video;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Commentdto {
    @ManyToMany
    private Integer profiles;
    @ManyToMany
    private Integer videos;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private String reply_id;
    @Column(nullable = false)
    private Integer like_count;
    @Column(nullable = false)
    private Integer dislike_count;
}
