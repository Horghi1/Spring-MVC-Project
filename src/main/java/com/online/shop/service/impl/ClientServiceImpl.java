package com.online.shop.service.impl;

import com.online.shop.domain.Client;
import com.online.shop.domain.repository.ClientRepository;
import com.online.shop.service.ClientService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients() {
        return clientRepository.getAllClients();
    }

    @Override
    public Client getClientById(String clientId) {
        return clientRepository.getClientById(clientId);
    }

    @Override
    public void addClient(Client client) {
        client.setProducts(new ArrayList());
        clientRepository.addClient(client);
    }

    @Override
    public void updateClient(String clientId, Client newClient) {
        clientRepository.updateClient(clientId, newClient);
    }

    @Override
    public void deleteClient(String clientId) {
        clientRepository.deleteClient(clientId);
    }
}
