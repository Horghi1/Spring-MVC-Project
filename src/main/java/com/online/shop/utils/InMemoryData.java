package com.online.shop.utils;

import com.online.shop.domain.Client;
import com.online.shop.domain.Product;
import com.online.shop.domain.Sale;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InMemoryData {

    public static final List<Client> listOfClients = new ArrayList<>();
    public static final List<Product> listOfProducts = new ArrayList<>();
    public static final List<Sale> listOfSales = new ArrayList<>();

    static {
        Product Samsung_Smart_Watch = new Product("P1234", "Galaxy Watch Active2", new BigDecimal(150));
        Samsung_Smart_Watch.setDescription("The Samsung Galaxy Watch Active2 is designed to help you learn more so you can achieve more."
                + " It goes beyond tracking steps and calories to offer actionable insights on everything from your running style to your heart rate.");
        Samsung_Smart_Watch.setCategory("Smart-Watch");
        Samsung_Smart_Watch.setManufacturer("Samsung");
        Samsung_Smart_Watch.setUnitsInStock(1000);
        Samsung_Smart_Watch.setImageSource("P1234.jpg");
        Samsung_Smart_Watch.setCondition("New");

        Product Samsung_Galaxy_S20 = new Product("P1235","Galaxy S20 Ultra 5G 128GB (Sprint)", new  BigDecimal(900));
        Samsung_Galaxy_S20.setDescription("Discover the perfect shot with 100X Zoom ");
        Samsung_Galaxy_S20.setCategory("SmartPhone");
        Samsung_Galaxy_S20.setManufacturer("Samsung");
        Samsung_Galaxy_S20.setUnitsInStock(1000);
        Samsung_Galaxy_S20.setImageSource("P1235.jpg");
        Samsung_Galaxy_S20.setCondition("New");

        Product Chromebook = new Product("P1236","Galaxy Chromebook (256GB Storage, 8GB RAM), Fiesta Red ", new BigDecimal(349));
        Chromebook.setDescription("Beautiful performance, even better looks. With its 4K AMOLED touchscreen, powerful processor,"
                + " 360° convertible design and built-in pen, the new Chromebook's ready to knock any project out of the park.");
        Chromebook.setCategory("Chromebook");
        Chromebook.setManufacturer("Samsung");
        Chromebook.setUnitsInStock(1000);
        Chromebook.setImageSource("P1236.jpg");
        Chromebook.setCondition("New");

        listOfProducts.add(Samsung_Smart_Watch);
        listOfProducts.add(Samsung_Galaxy_S20);
        listOfProducts.add(Chromebook);


        Client client1 = new Client("C1234", "Florin", "Horghidan", "florin@gmail.com", new ArrayList<>(Arrays.asList(Samsung_Smart_Watch, Samsung_Galaxy_S20)));
        Client client2 = new Client("C1235", "Daniel", "Oana", "daniel@gmail.com", new ArrayList<>(Arrays.asList(Chromebook)));

        listOfClients.add(client1);
        listOfClients.add(client2);

        Sale sale1 = new Sale("S1234", client2, Samsung_Smart_Watch, 2, SaleState.PENDING);
        Sale sale2 = new Sale("S1235", client1, Samsung_Galaxy_S20, 1, SaleState.PENDING);
        Sale sale3 = new Sale("S1235", client2, Chromebook, 1, SaleState.SOLD);

        listOfSales.add(sale1);
        listOfSales.add(sale2);
        listOfSales.add(sale3);
    }
}
