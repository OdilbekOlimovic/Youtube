package Odiljon_Olimovich.dto;

import Odiljon_Olimovich.model.entity.Permisionrole;
import Odiljon_Olimovich.model.entity.Status;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profiledto {
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String photo;
    @Enumerated(EnumType.STRING)
    private Permisionrole permisionrole;
    @Enumerated(EnumType.STRING)
    private Status status;
}
