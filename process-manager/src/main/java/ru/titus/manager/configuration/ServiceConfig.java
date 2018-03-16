package ru.titus.manager.configuration;


import model.Amount;
import model.Stock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ServiceConfig {

    @Bean
    public List<Stock> createStocksList() {
        List<Stock> stocks = new ArrayList<Stock>();
        stocks.add(new Stock(1,"titus", new Amount(3 )));
        stocks.add(new Stock(2,"ivey",new Amount(5 )));
        stocks.add(new Stock(3,"branson",new Amount(6 )));
        stocks.add(new Stock(4,"titus", new Amount(4 )));
        stocks.add(new Stock(5,"ivey",new Amount(5 )));
        stocks.add(new Stock(6,"branson",new Amount(6 )));
        stocks.add(new Stock(7,"titus", new Amount(4 )));
        return stocks;
    }

}
