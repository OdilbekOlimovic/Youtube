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
public class Email_historydto {
    @Column(nullable = false)
    private String to_email;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String message;
    @CreatedDate
    private LocalDateTime created_date;
}
