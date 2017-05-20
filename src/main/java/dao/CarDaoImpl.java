package dao;

import model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CarDaoImpl implements CarDao
{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Car> getAll()
    {
        return sessionFactory.getCurrentSession().createQuery("from model.Car").list();
    }

    @Override
    public Car get(int id)
    {
        return (Car)sessionFactory.getCurrentSession().get(Car.class, id);
    }

    @Override
    public void add(Car car)
    {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    public void update(Car car)
    {
        sessionFactory.getCurrentSession().update(car);
    }

    @Override
    public void delete(int id)
    {
        sessionFactory.getCurrentSession().delete(id);
    }
}
