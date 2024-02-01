package ru.maxima.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "citizen")
@NoArgsConstructor
@Getter
@Setter
public class Citizen {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @OneToOne(mappedBy = "citizen")
    private Passport passport;

    public Citizen(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
