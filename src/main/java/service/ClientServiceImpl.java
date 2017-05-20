package service;


import dao.CommonDao;
import model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements CommonService<Client>
{
    @Autowired
    @Qualifier("clientDaoImpl")
    CommonDao dao;

    @Override
    public List<Client> getAll()
    {
        return dao.getAll();
    }

    @Override
    public Client get(int id)
    {
        return (Client)dao.get(id);
    }

    @Override
    public void add(Client param)
    {
        dao.add(param);
    }

    @Override
    public void update(Client param)
    {
        dao.update(param);
    }

    @Override
    public void delete(int id)
    {
        dao.delete(id);
    }
}