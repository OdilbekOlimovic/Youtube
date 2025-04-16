package Odiljon_Olimovich.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToMany
    private List<Profile> profiles;
    @ManyToMany
    private List<Video> videos;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private String reply_id;
    @Column(nullable = false)
    private Integer like_count;
    @Column(nullable = false)
    private Integer dislike_count;
}
