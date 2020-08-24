package com.online.shop.service;

import com.online.shop.domain.Client;

import java.util.List;

public interface ClientService {

    List<Client> getAllClients();
    Client getClientById(String clientId);

    void addClient(Client client);
    void updateClient(String clientId, Client newClient);
    void deleteClient(String clientId);
}
