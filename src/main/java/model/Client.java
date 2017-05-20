package model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "clients")
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

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public boolean isMale()
    {
        return male;
    }

    public void setMale(boolean male)
    {
        this.male = male;
    }

    public Car getCar()
    {
        return car;
    }

    public void setCar(Car car)
    {
        this.car = car;
    }
}
