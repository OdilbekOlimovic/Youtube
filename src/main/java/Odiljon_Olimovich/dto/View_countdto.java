package Odiljon_Olimovich.dto;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class View_countdto {
    @Column(nullable = false)
    private String count;
}
