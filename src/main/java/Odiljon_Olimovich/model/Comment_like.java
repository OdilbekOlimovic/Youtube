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
public class Comment_like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToMany
    private List<Profile> profiles;
    @ManyToMany
    private List<Comment> comments;
    @Column(nullable = false)
    private LocalDateTime created_date;
    @Column(nullable = false)
    private String type;
}
