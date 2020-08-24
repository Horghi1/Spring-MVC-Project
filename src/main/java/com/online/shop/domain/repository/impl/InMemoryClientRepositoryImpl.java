package com.online.shop.domain.repository.impl;

import com.online.shop.domain.Client;
import com.online.shop.domain.repository.ClientRepository;
import com.online.shop.utils.InMemoryData;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryClientRepositoryImpl implements ClientRepository {

    private List<Client> listOfClients;

    public InMemoryClientRepositoryImpl() {
        listOfClients = new ArrayList<>(InMemoryData.listOfClients);
    }

    @Override
    public List<Client> getAllClients() {
        return listOfClients;
    }

    @Override
    public Client getClientById(String clientId) {
        Client clientById = null;

        for(Client client: listOfClients) {
            if(client != null && client.getClientId() != null && client.getClientId().equals(clientId)) {
                clientById = client;
                break;
            }
        }

        return clientById;
    }

    @Override
    public void addClient(Client client) {
        listOfClients.add(client);
    }

    @Override
    public void updateClient(String clientId, Client newClient) {
        for(int i = 0; i < listOfClients.size(); i++) {
            if(listOfClients.get(i).getClientId().equals(clientId)) {
                listOfClients.get(i).setFirstName(newClient.getFirstName());
                listOfClients.get(i).setLastName(newClient.getLastName());
            }
        }
    }

    @Override
    public void deleteClient(String clientId) {
        for(int i = 0; i < listOfClients.size(); i++) {
            if(listOfClients.get(i).getClientId().equals(clientId)) {
                listOfClients.remove(i);
                break;
            }
        }
    }
}
