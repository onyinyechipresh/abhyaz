package com.example.abhyaz;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Feedback {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String emailAddress;
    @Column
    private String subject;
    @Column
    private String message;
}
