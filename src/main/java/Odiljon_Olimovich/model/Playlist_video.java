package Odiljon_Olimovich.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Playlist_video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToMany
    private List<Playlist> playlists;
    @ManyToMany
    private List<Video> videos;
    @Column(nullable = false)
    private LocalDateTime created_Date;
    @Column(nullable = false)
    private LocalDateTime order_num;
}
