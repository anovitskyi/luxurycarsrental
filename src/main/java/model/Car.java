package model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "cars")
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
}
