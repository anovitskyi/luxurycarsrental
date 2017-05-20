package dao;

import model.Client;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientDaoImpl extends DaoImpl<Client>
{

    @Override
    public List<Client> getAll()
    {
        return sessionFactory.getCurrentSession().createQuery("from model.Client").list();
    }

    @Override
    public Client get(int id)
    {
        return (Client)sessionFactory.getCurrentSession().get(Client.class, id);
    }
}
