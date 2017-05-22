package controllers;

import model.Car;
import model.Client;
import model.Rent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<List<Rent>> getAll()
    {
        List<Rent> list = service.getAll();
        if (list.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Rent> getById(@PathVariable int id)
    {
        Rent rent = service.get(id);
        if (rent == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(rent, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Void> add(@RequestBody @Valid Client client, BindingResult result, @RequestBody @Valid Car car, BindingResult result1, Date returningDate)
    {
        if (result.hasErrors() || result1.hasErrors() || returningDate == null || returningDate.before(new Date()))
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        else
        {
            // Set car unable
            car.setEnabled(false);
            car.setReturningDate(returningDate);
            serviceCar.update(car);

            // Client rented car
            client.setCar(car);
            serviceClient.update(client);

            // Saving
            service.add(new Rent(client, car, new Date()));

            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@PathVariable int id, @RequestBody @Valid Client client, BindingResult result, @RequestBody @Valid Car car, BindingResult result1, Date returningDate)
    {
        Rent r = service.get(id);
        if (r == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else if (result.hasErrors() || result1.hasErrors() || returningDate == null || returningDate.before(new Date()))
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        else
        {
            r.setCar(car);
            r.setClient(client);
            r.setDate(new Date());

            // Set car unable
            car.setEnabled(false);
            car.setReturningDate(returningDate);
            serviceCar.update(car);

            // Client rented car
            client.setCar(car);
            serviceClient.update(client);

            service.update(r);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable int id)
    {
        Rent rent = service.get(id);
        if (rent == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
        {
            Client client = rent.getClient();
            client.setCar(null);
            serviceClient.update(client);

            Car car = rent.getCar();
            car.setEnabled(true);
            car.setReturningDate(null);
            serviceCar.update(car);

            service.delete(rent);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
