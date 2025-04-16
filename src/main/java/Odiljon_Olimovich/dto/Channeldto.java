package Odiljon_Olimovich.dto;


import Odiljon_Olimovich.model.Profile;
import Odiljon_Olimovich.model.entity.Status;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Channeldto {
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
    private Integer profiles;
}
