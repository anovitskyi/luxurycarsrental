package dao;

import model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CarDaoImpl extends DaoImpl<Car>
{

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
}
