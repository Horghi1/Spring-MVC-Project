package com.online.shop.controller;

import com.online.shop.domain.Client;
import com.online.shop.domain.Product;
import com.online.shop.domain.Sale;
import com.online.shop.utils.SaleState;
import com.online.shop.service.ClientService;
import com.online.shop.service.ProductService;
import com.online.shop.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Controller
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ClientService clientService;

    @RequestMapping
    public String getAllSales(Model model) {
        model.addAttribute("sales", saleService.getAllSales());
        return "sale/sales";
    }

    @RequestMapping("/sale")
    public String getProductById(@RequestParam("id") String saleId, Model model){
        Sale s = saleService.getSaleById(saleId);
        model.addAttribute("sale", s);

        return "sale/sale";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addNewSale(@ModelAttribute("newSale") Sale newSale, Model model,
                             BindingResult result, HttpServletRequest request){
        Client client = clientService.getClientById(newSale.getClient().getClientId());
        Product product = productService.getProductById(newSale.getProduct().getProductId());

        if(product.getUnitsInStock() < newSale.getNumberOfUnits()) {
            model.addAttribute("error", "Insufficient stock");
            return "redirect:/products/product?id=" + product.getProductId();
        }
        
        if(newSale.getNumberOfUnits() == 0) {
            model.addAttribute("error", "Units should be minimum 1");
            return "redirect:/products/product?id=" + product.getProductId();
        }

        newSale.setSaleId(UUID.randomUUID().toString());
        newSale.setClient(client);
        newSale.setProduct(product);
        saleService.addSale(newSale);

        return "redirect:/sales";
    }

    @RequestMapping(value = "/sell", method = RequestMethod.GET)
    public String updateSaleState(@RequestParam("id") String saleId, Model model) {
        Sale updatedSell = saleService.getSaleById(saleId);

        if(updatedSell != null) {
            Product product = productService.getProductById(updatedSell.getProduct().getProductId());
            Client client = clientService.getClientById(updatedSell.getClient().getClientId());
             
            if(client == null || product == null) {
                return "redirect:/sales/decline?id=" + saleId;
            }
            
            updatedSell.setState(SaleState.SOLD);
            saleService.update(saleId, updatedSell);
           
            product.setUnitsInStock(product.getUnitsInStock() - updatedSell.getNumberOfUnits());
            client.getProducts().add(product);

        }

        return "redirect:/sales";
    }

    @RequestMapping(value = "/decline", method = RequestMethod.GET)
    public String declineSell(@RequestParam("id") String saleId, Model model) {
        Sale declinedSell = saleService.getSaleById(saleId);

        if(declinedSell != null) {
            declinedSell.setState(SaleState.DECLINED);
            saleService.update(saleId, declinedSell);
        }

        return "redirect:/sales";
    }

}
