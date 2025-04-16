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
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToMany
    private List<Profile> profiles;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private Integer entity_id;
    @ManyToMany
    private List<Channel> channels;
    @Column(nullable = false)
    private String type;
}
