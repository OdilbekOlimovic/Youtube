package Odiljon_Olimovich.dto;


import Odiljon_Olimovich.model.Channel;
import Odiljon_Olimovich.model.Profile;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reportdto {
    @ManyToMany
    private Integer profiles;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private Integer entity_id;
    @ManyToMany
    private Integer channels;
    @Column(nullable = false)
    private String type;
}
