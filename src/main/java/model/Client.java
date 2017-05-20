package model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "clients")
@Getter
@Setter
public class Client
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column(name = "first_name")
    @NotNull
    private String  firstName;

    @Column(name = "last_name")
    @NotNull
    private String lastName;

    @Column
    private int age;

    @Column
    private boolean male;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Car car;

    public Client()
    {
    }

    public Client(String firstName, String lastName, int age, boolean male)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.male = male;
    }
}
