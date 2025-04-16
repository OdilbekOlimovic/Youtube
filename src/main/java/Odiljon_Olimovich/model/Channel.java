package Odiljon_Olimovich.model;


import Odiljon_Olimovich.model.entity.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Channel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String photo;
    @Column(nullable = false)
    private String description;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(nullable = false)
    private String banner;
    @ManyToMany
    private List<Profile> profiles;
}
