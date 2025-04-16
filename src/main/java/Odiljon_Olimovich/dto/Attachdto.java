package Odiljon_Olimovich.dto;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attachdto {
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
