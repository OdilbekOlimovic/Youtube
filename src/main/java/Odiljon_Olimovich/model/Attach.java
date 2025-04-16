package Odiljon_Olimovich.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Attach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @Column(nullable = false)
    private String origin_name;
    @Column(nullable = false)
    private String size;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String path;
    @Column(nullable = false)
    private String duration;
}