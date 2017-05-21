package controllers;


import model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.CommonService;

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
}
