package com.kozja.filter;

import com.kozja.filter.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class Starter implements CommandLineRunner {
    @Autowired
    ClientRepository clientRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        clientRepository.createClient("Adam Malysz", 36,172, 76);
    }
}
