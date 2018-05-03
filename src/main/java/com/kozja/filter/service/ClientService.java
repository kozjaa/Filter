package com.kozja.filter.service;

import com.kozja.filter.domain.Client;
import com.kozja.filter.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<Client> getAllClients()
    {
        return new ArrayList<>(clientRepository.getAllClients());
    }

    public void saveClient(Client client) {
        clientRepository.createClient(client);
    }

    public void deleteClient(Integer id) {
        clientRepository.deleteClient(id);
    }

    public List<Client> getClientsByAge(Integer age) {
        return (List<Client>) clientRepository.getClientsByAge(age);
    }

    public List<Client> getClientsByHeight(Integer height) {
        return (List<Client>) clientRepository.getClientsByHeight(height);
    }

    public List<Client> getClientsByWeight(Integer weight) {
        return (List<Client>) clientRepository.getClientsByweight(weight);
    }

    public List<Client> getClientsByName(String name) {
        return (List<Client>) clientRepository.getClientsByName(name);
    }
}
