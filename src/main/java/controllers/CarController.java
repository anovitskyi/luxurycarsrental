package controllers;


import dao.CarDaoImpl;
import model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import service.CommonService;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController
{
    @Autowired
    @Qualifier("carServiceImpl")
    CommonService<Car> service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Car getById(@PathVariable int id)
    {
        return service.get(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public List<Car> getList()
    {
        return service.getAll();
    }
}
