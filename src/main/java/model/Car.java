package model;


import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "cars")
public class Car
{
    @Id
    @Column(name = "car_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    @NotNull
    @Length(min = 3, max = 15)
    private String company;

    @Column
    @NotNull
    @Length(min = 1, max = 15)
    private String model;

    @Column
    @Min(1995)
    private int year;

    @Column
    @Min(0)
    private double price;

    @Column(name = "is_enabled")
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

    public int getId()
    {
        return id;
    }

    public String getCompany()
    {
        return company;
    }

    public void setCompany(String company)
    {
        this.company = company;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public boolean isEnabled()
    {
        return isEnabled;
    }

    public void setEnabled(boolean enabled)
    {
        isEnabled = enabled;
    }

    public Date getReturningDate()
    {
        return returningDate;
    }

    public void setReturningDate(Date returningDate)
    {
        this.returningDate = returningDate;
    }

    @Override
    public String toString()
    {
        return "Car{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", isEnabled=" + isEnabled +
                ", returningDate=" + returningDate +
                '}';
    }
}
