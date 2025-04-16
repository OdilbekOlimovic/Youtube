package Odiljon_Olimovich.model;


import Odiljon_Olimovich.model.entity.Permisionrole;
import Odiljon_Olimovich.model.entity.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
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
