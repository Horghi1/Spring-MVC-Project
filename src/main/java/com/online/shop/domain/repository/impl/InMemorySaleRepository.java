package com.online.shop.domain.repository.impl;

import com.online.shop.domain.Sale;
import com.online.shop.domain.repository.SaleRepository;
import com.online.shop.utils.InMemoryData;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InMemorySaleRepository implements SaleRepository {

    private List<Sale> listOfSales;

    public InMemorySaleRepository() {
        listOfSales = new ArrayList<>(InMemoryData.listOfSales);
    }

    @Override
    public List<Sale> getAllSales() {

        return listOfSales.stream()
                .sorted(Comparator.comparing(Sale::getState))
                .collect(Collectors.toList());
    }

    @Override
    public Sale getSaleById(String saleId) {
        for(Sale sale: listOfSales) {
            if(sale != null && sale.getSaleId() != null && sale.getSaleId().equals(saleId)) {
                return sale;
            }
        }
        return null;
    }

    @Override
    public void addSale(Sale sale) {
        listOfSales.add(sale);
    }

    @Override
    public void update(String saleId, Sale sale) {
        for(int i = 0; i < listOfSales.size(); i++) {
            if(listOfSales.get(i).getSaleId().equals(saleId)) {
                listOfSales.get(i).setClient(sale.getClient());
                listOfSales.get(i).setProduct(sale.getProduct());
                listOfSales.get(i).setNumberOfUnits(sale.getNumberOfUnits());
                listOfSales.get(i).setState(sale.getState());
                break;
            }
        }
    }

    @Override
    public void deleteSale(String saleId) {
        for(int i = 0; i < listOfSales.size(); i++) {
            if(listOfSales.get(i) != null && listOfSales.get(i).getSaleId() != null &&
                    listOfSales.get(i).getSaleId().equals(saleId)) {
                listOfSales.remove(i);
                break;
            }
        }
    }
}
