package controllers;


import model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import service.CommonService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController
{
    @Autowired
    CommonService<Client> service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Client>> getList()
    {
        List<Client> list = service.getAll();
        if (list.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Client> getById(@PathVariable int id)
    {
        Client client = service.get(id);
        System.out.println(client);
        if (client == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Client getEmptyForm()
    {
        return new Client("","", 18, true);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Void> add(@RequestBody @Valid Client client, BindingResult result)
    {
        if (result.hasErrors())
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        else
        {
            service.add(client);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@PathVariable int id, @RequestBody @Valid Client client, BindingResult result)
    {
        if (result.hasErrors())
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        else
        {
            Client cl = service.get(id);
            if (cl == null)
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            cl.setFirstName(client.getFirstName());
            cl.setLastName(client.getLastName());
            cl.setAge(client.getAge());
            cl.setMale(client.isMale());
            cl.setCar(client.getCar());
            service.update(cl);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable int id)
    {
        Client client = service.get(id);
        System.out.println("\n\n\n" + client + " \n\n\n");
        if (client == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
        {
            service.delete(client);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
