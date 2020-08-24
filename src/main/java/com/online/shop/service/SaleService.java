package com.online.shop.service;

import com.online.shop.domain.Sale;

import java.util.List;

public interface SaleService {
    List<Sale> getAllSales();
    Sale getSaleById(String saleId);

    void addSale(Sale sale);
    void update(String saleId, Sale sale);
    void deleteSale(String saleId);
}
