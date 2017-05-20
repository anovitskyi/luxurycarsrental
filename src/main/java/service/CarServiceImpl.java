package service;

import dao.CommonDao;
import model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CarServiceImpl implements CommonService<Car>
{
    @Autowired
    @Qualifier("carDaoImpl")
    CommonDao dao;

    @Override
    public List<Car> getAll()
    {
        List<Car> list = dao.getAll();
        List<Car> result = new ArrayList<>();

        for (Car car : list)
            if (car.isEnabled())
                result.add(car);
        return result;
    }

    @Override
    public Car get(int id)
    {
        return (Car)dao.get(id);
    }

    @Override
    public void add(Car param)
    {
        dao.add(param);
    }

    @Override
    public void update(Car param)
    {
        dao.update(param);
    }

    @Override
    public void delete(int id)
    {
        dao.delete(id);
    }
}
