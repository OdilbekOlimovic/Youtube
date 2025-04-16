package Odiljon_Olimovich.dto;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tagdto {
    @Column(nullable = false)
    private String name;
    @CreatedDate
    private LocalDateTime created_Date;
}
