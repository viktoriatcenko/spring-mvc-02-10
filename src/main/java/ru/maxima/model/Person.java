package ru.maxima.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "Person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name should not to be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    @Column(name = "name")
    private String name;

    @Min(value = 0, message = "Age should be more than 0")
    @Column(name = "age")
    private Integer age;

    @NotEmpty(message = "Email should not to be empty")
    @Email(message = "Email is not valid")
    @Column(name = "email")
    private String email;

    @Column(name = "admin")
    private boolean isAdmin;

    @OneToMany(mappedBy = "owner")
    private List<Order> orders;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
