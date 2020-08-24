package com.online.shop.service.impl;

import com.online.shop.domain.Sale;
import com.online.shop.domain.repository.SaleRepository;
import com.online.shop.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleRepository saleRepository;
    @Override
    public List<Sale> getAllSales() {
        return saleRepository.getAllSales();
    }

    @Override
    public Sale getSaleById(String saleId) {
        return saleRepository.getSaleById(saleId);
    }

    @Override
    public void addSale(Sale sale) {
        saleRepository.addSale(sale);
    }

    @Override
    public void update(String saleId, Sale sale) {
        saleRepository.update(saleId, sale);
    }

    @Override
    public void deleteSale(String saleId) {
        saleRepository.deleteSale(saleId);
    }
}
