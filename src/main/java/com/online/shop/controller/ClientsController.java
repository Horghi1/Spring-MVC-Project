package com.online.shop.controller;

import com.online.shop.domain.Client;
import com.online.shop.exception.InvalidClientException;
import com.online.shop.service.ClientService;
import com.online.shop.utils.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@RequestMapping("/clients")
public class ClientsController {

    @Autowired
    private ClientService clientService;

    @RequestMapping
    public String getAllClients(Model model) {
        model.addAttribute("clients", clientService.getAllClients());
        return "client/clients";
    }

    @RequestMapping("/client")
    public String getClientById(@RequestParam("id") String clientId, Model model) {
        Client c = clientService.getClientById(clientId);
        if(c == null) {
            return "redirect:/clients";
        }
        model.addAttribute("client", c);
        return "client/viewClient";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewClientForm(Model model){
        Client newClient = new Client();
        model.addAttribute("newClient", newClient);
        return "client/addClient";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewProductForm(@ModelAttribute("newClient") Client newClient,
            Model model){
        try {
            Validator.validateClient(newClient);
        } catch(InvalidClientException e) {
            model.addAttribute("error", e.getMessage());
            
            return "client/addClient";
        }
        newClient.setClientId(UUID.randomUUID().toString());
        clientService.addClient(newClient);
        return "redirect:/clients";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateClientById(@RequestParam("id") String clientId, Model model) {
        Client updateClient = clientService.getClientById(clientId);
        model.addAttribute("updateClient", updateClient);
        return "client/updateClient";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateClientById(@RequestParam("id") String clientId, Client updatedClient,
            Model model) {
         try {
            Validator.validateClient(updatedClient);
        } catch(InvalidClientException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("updateClient", updatedClient);
            
            return "client/updateClient";
        }
        clientService.updateClient(clientId, updatedClient);
        return "redirect:/clients/client?id=" + clientId;
    }

    @RequestMapping("/delete")
    public String deleteClientById(@RequestParam("id") String clientId) {
        clientService.deleteClient(clientId);
        return "redirect:/clients";
    }
}
