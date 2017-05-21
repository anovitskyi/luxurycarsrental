package service;


import dao.CommonDao;
import dao.DaoImpl;
import model.Rent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentServiceImpl implements CommonService<Rent>
{
    @Autowired
    @Qualifier("rentDaoImpl")
    CommonDao<Rent> dao;

    @Override
    public List<Rent> getAll()
    {
        return dao.getAll();
    }

    @Override
    public Rent get(int id)
    {
        return dao.get(id);
    }

    @Override
    public void add(Rent param)
    {
        dao.add(param);
    }

    @Override
    public void update(Rent param)
    {
        dao.update(param);
    }

    @Override
    public void delete(int id)
    {
        dao.delete(id);
    }
}
