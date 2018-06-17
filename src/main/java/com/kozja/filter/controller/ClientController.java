package com.kozja.filter.controller;

import com.kozja.filter.domain.Client;
import com.kozja.filter.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ClientController {

    @Autowired
    ClientService clientService;

    @RequestMapping("/clients")
    public String getAllClients(Model model)
    {
        List<Client> allClients = clientService.getAllClients();
        model.addAttribute("clients", allClients);

        return "index";
    }

    @RequestMapping("/newclient")
    public String createClient(Model model)
    {
        model.addAttribute("client",new Client());

        return "clientform";
    }

    @RequestMapping(value = "/clients", method = RequestMethod.POST)
    public String saveClient(@Valid Client client, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            bindingResult.getAllErrors().forEach(error ->{
                System.out.println(error.getObjectName() + " " + error.getDefaultMessage());
            });
            return "clientform";
        }
        else {
        clientService.saveClient(client);

        return "redirect:/clients";}
    }

    @RequestMapping(value = "/client/delete/{id}")
    public String deleteClient(@PathVariable("id") Integer id)
    {
        clientService.deleteClient(id);
        return "redirect:/clients";
    }

    @RequestMapping(value = "/client/edit/{id}")
    public String updateClient(@PathVariable("id") Integer id, Model model)
    {
        model.addAttribute("client",clientService.getClientById(id));

        return "clientform";
    }

    @RequestMapping(value = "/client/{id}")
    public String getClient(@PathVariable("id") Integer id, Model model)
    {
        model.addAttribute("client",clientService.getClientById(id));

        return "client";
    }

    @RequestMapping(value = "/filteredbyage", method = RequestMethod.POST)
    public String GetClientsByAge(Client client, BindingResult bindingResult, Model model)
    {
        if(bindingResult.hasErrors())
        {
            bindingResult.getAllErrors().forEach(error ->{
                System.out.println(error.getObjectName() + " " + error.getDefaultMessage());
            });
            return "filteredform";
        }
        else {
            List<Client> allClients = clientService.getClientsByAge(client.getAge());
            model.addAttribute("clients", allClients);
            return "filtered";}
    }

    @RequestMapping(value = "/filteredbyheight", method = RequestMethod.POST)
    public String GetClientsByHeight(Client client, BindingResult bindingResult, Model model)
    {
        if(bindingResult.hasErrors())
        {
            bindingResult.getAllErrors().forEach(error ->{
                System.out.println(error.getObjectName() + " " + error.getDefaultMessage());
            });
            return "filteredform";
        }
        else {
            List<Client> allClients = clientService.getClientsByHeight(client.getHeight());
            model.addAttribute("clients", allClients);
            return "filtered";}
    }

    @RequestMapping(value = "/filteredbyweight", method = RequestMethod.POST)
    public String GetClientsByWeight(Client client, BindingResult bindingResult, Model model)
    {
        if(bindingResult.hasErrors())
        {
            bindingResult.getAllErrors().forEach(error ->{
                System.out.println(error.getObjectName() + " " + error.getDefaultMessage());
            });
            return "filteredform";
        }
        else {
            List<Client> allClients = clientService.getClientsByWeight(client.getWeight());

            model.addAttribute("clients", allClients);

            return "filtered";}
    }


    @RequestMapping("/newfilter")
    public String createClients(Model model)
    {
        model.addAttribute("client", new Client());
        return "filteredform";
    }

}

