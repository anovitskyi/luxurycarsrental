package controllers;


import model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import service.CommonService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController
{
    @Autowired
    CommonService<Car> service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Car>> getList()
    {
        List<Car> list = service.getAll();
        if (list.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Car> getById(@PathVariable int id)
    {
        Car car = service.get(id);
        if (car == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Void> add(@RequestBody @Valid Car car, BindingResult result)
    {
        if (result.hasErrors())
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        else
        {
            car.setEnabled(true);
            service.add(car);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@PathVariable int id, @RequestBody @Valid Car car, BindingResult result)
    {
        if (result.hasErrors())
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        else
        {
            Car c = service.get(id);
            if (c == null)
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            c.setCompany(car.getCompany());
            c.setModel(car.getModel());
            c.setYear(car.getYear());
            c.setPrice(car.getPrice());
            c.setEnabled(car.isEnabled());
            c.setReturningDate(car.getReturningDate());
            service.update(c);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable int id)
    {
        Car car = service.get(id);
        if (car == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
        {
            service.delete(car);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
