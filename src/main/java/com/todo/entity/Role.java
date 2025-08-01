package com.todo.entity;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter@Setter@NoArgsConstructor@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
