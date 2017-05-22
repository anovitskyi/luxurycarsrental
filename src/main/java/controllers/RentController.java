package controllers;

import model.Car;
import model.Client;
import model.Rent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.CommonService;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/rents")
public class RentController
{
    @Autowired
    CommonService<Rent> service;
    @Autowired
    CommonService<Client> serviceClient;
    @Autowired
    CommonService<Car> serviceCar;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Rent> getAll()
    {
        return service.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Rent getById(@PathVariable int id)
    {
        return service.get(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void add(@Valid Client client, BindingResult result, @Valid Car car, BindingResult result1, Date returningDate)
    {
        if (!result.hasErrors() && !result1.hasErrors())
        {
            car.setEnabled(false);
            car.setReturningDate(returningDate);
            serviceCar.update(car);

            client.setCar(car);
            serviceClient.update(client);

            service.add(new Rent(client, car, new Date()));
        }
    }

   /* @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update()*/
}
