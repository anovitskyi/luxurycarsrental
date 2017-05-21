package controllers;


import model.Car;
import model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
    public List<Client> getList()
    {
        return service.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Client getById(@PathVariable int id)
    {
        return service.get(id);
    }

    @RequestMapping(value = {"/add", "/update"}, method = RequestMethod.GET)
    public Client add()
    {
        return new Client("", "", 0, false);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void add(@Valid Client client, BindingResult result)
    {
        if (result.hasErrors())
        {

        }
        else
            service.add(client);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable int id, @Valid Client client, BindingResult result)
    {
        if (result.hasErrors())
        {

        }
        else
            service.update(client);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id)
    {
        service.delete(id);
    }

}
