package Odiljon_Olimovich.dto;

import Odiljon_Olimovich.model.Attach;
import Odiljon_Olimovich.model.Category;
import Odiljon_Olimovich.model.Channel;
import Odiljon_Olimovich.model.entity.Status;
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
public class Videodto {
    private Integer preview_attach_id;
    @Column(nullable = false)
    private String title;
    @ManyToMany
    private Integer categories;
    @ManyToMany
    private UUID attachs;
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
    private Integer channels;
    @Column(nullable = false)
    private String likes_count;
    @Column(nullable = false)
    private String dislikes_count;
}
