package ru.maxima.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "passport")
@NoArgsConstructor
@Getter
@Setter
public class Passport {

    @Id
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Citizen citizen;

    @Column(name = "passport_number")
    private int number;

    public Passport(Citizen citizen, int number) {
        this.citizen = citizen;
        this.number = number;
    }
}
