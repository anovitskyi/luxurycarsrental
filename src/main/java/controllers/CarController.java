package controllers;


import model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.CommonService;

import javax.validation.Valid;
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
    public List<Car> getList()
    {
        return service.getAll();
    }

    @RequestMapping(value = {"/add", "/update"}, method = RequestMethod.GET)
    public Car add()
    {
        return new Car("", "", 0, 0);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void add(@Valid Car car, BindingResult result)
    {
        if (result.hasErrors())
        {

        }
        else
            service.add(car);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable int id, @Valid Car car, BindingResult result)
    {
        if (result.hasErrors())
        {

        }
        else
            service.update(car);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id)
    {
        service.delete(id);
    }
}
