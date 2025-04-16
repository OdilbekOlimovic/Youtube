package Odiljon_Olimovich.dto;


import Odiljon_Olimovich.model.Playlist;
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
public class Playlist_videodto {
    @ManyToMany
    private Integer playlists;
    @ManyToMany
    private Integer videos;
    @Column(nullable = false)
    private LocalDateTime created_Date;
    @Column(nullable = false)
    private LocalDateTime order_num;
}
