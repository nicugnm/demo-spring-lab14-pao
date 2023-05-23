package net.pao.laboratorpao.model;

import jakarta.persistence.*;
import lombok.*;
import net.pao.laboratorpao.model.enums.PersonType;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "people")
public class Person {

    @Id
    @Column(name = "person_id")
    private UUID personId;

    // first_name
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private Long phoneNumber;

    @Column(name = "person_type")
    @Enumerated(value = EnumType.STRING)
    private PersonType personType;

    @OneToMany
    @JoinColumn(name = "account_id")
    private List<Account> accountId;
}
