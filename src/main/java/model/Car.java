package model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "cars")
@Getter
@Setter
public class Car
{
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NotNull
    private String company;

    @Column
    @NotNull
    private String model;

    @Column
    private int year;

    @Column
    private double price;

    @Column
    private boolean isEnabled;

    @Column(name = "returning_date")
    private Date returningDate;

    public Car()
    {
    }

    public Car(String company, String model, int year, double price)
    {
        this.company = company;
        this.model = model;
        this.year = year;
        this.price = price;
        this.isEnabled = true;
    }
}
