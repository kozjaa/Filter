package com.kozja.filter.domain.repository;

import com.kozja.filter.domain.Client;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;


@Repository
public class ClientRepository {

    @PersistenceContext
    private EntityManager em;


    public ClientRepository() {

    }

    @Transactional
    public void createClient(String name, int age, int height, int weight) {
        Client newClient = new Client(name, age, height, weight);
        em.persist(newClient);

    }


    public Collection<Client> getAllClients() {
        return em.createQuery("from Client", Client.class).getResultList();
    }

    @Transactional
    public void deleteClient(Integer id
    ) {
        Client client = new Client();
        client.setId(id);
        em.remove(em.contains(client) ? client : em.merge(client));
    }

    public Client getClient(Integer id) {
        return em.find(Client.class, id);
    }

    @Transactional
    public void createClient(Client client) {
        em.persist(client);
    }

    public Collection<Client> getClientsByAge(Integer age) {
        return em.createQuery("from Client c where c.age=:age", Client.class).setParameter("age", age).getResultList();
    }

    public Collection<Client> getClientsByHeight(Integer height) {
        return em.createQuery("from Client c where c.height=:height", Client.class).setParameter("height", height).getResultList();
    }

    public Collection<Client> getClientsByweight(Integer weight) {
        return em.createQuery("from Client c where c.weight=:weight", Client.class).setParameter("weight", weight).getResultList();
    }

    public Collection<Client> getClientsByName(String name) {
        return em.createQuery("from Client c where c.name=:name", Client.class).setParameter("name", name).getResultList();
    }

}
