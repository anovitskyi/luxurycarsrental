package dao;


import model.Rent;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RentDaoImpl extends DaoImpl<Rent>
{
    @Override
    public List<Rent> getAll()
    {
        return sessionFactory.getCurrentSession().createQuery("from model.Rent").list();
    }

    @Override
    public Rent get(int id)
    {
        return (Rent)sessionFactory.getCurrentSession().get(Rent.class, id);
    }
}
