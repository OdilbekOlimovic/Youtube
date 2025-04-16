package Odiljon_Olimovich.model;

import Odiljon_Olimovich.model.entity.Status;
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
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private Integer preview_attach_id;
    @Column(nullable = false)
    private String title;
    @ManyToMany
    private List<Category> categories;
    @ManyToMany
    private List<Attach> attachs;
    @Column(nullable = false)
    private LocalDateTime created_date;
    @Column(nullable = false)
    private LocalDateTime published_date;
    @Column(nullable = false)
    private Status status;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String view_count;
    @Column(nullable = false)
    private String shared_count;
    @Column(nullable = false)
    private String description;
    @ManyToMany
    private List<Channel> channels;
    @Column(nullable = false)
    private String likes_count;
    @Column(nullable = false)
    private String dislikes_count;
}
