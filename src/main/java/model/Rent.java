package model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rents")
public class Rent
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;

    @Column
    private Date date;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Client client;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Car car;

    public Rent()
    {
    }

    public Rent(Client client, Car car, Date date)
    {
        this.client = client;
        this.car = car;
        this.date = date;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public Client getClient()
    {
        return client;
    }

    public void setClient(Client client)
    {
        this.client = client;
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
