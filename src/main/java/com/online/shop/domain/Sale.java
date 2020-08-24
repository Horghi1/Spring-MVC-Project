package com.online.shop.domain;

import com.online.shop.utils.SaleState;

public class Sale {

    private String saleId;
    private Client client;
    private Product product;
    private int numberOfUnits;
    private SaleState state;

    public Sale() {
    }

    public Sale(String saleId, Client client, Product product, int numberOfUnits, SaleState state) {
        this.saleId = saleId;
        this.client = client;
        this.product = product;
        this.numberOfUnits = numberOfUnits;
        this.state = state;
    }

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getNumberOfUnits() {
        return numberOfUnits;
    }

    public void setNumberOfUnits(int numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }

    public SaleState getState() {
        return state;
    }

    public void setState(SaleState state) {
        this.state = state;
    }
}
