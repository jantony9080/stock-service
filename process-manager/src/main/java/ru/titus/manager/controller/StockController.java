package ru.titus.manager.controller;

import model.Amount;
import model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.titus.manager.service.DataCollector;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StockController {

    @ModelAttribute("newStock")
    public Stock newStock(){
        Stock newStock = new Stock(0,"ferguson", new Amount(0));
        return newStock;
    }

    @ModelAttribute("stocks")
    public List<Stock> createStocksList() {
        List<Stock> stocks = new ArrayList<Stock>();
        stocks.add(new Stock(1,"titus", new Amount(4 )));
        stocks.add(new Stock(2,"ivey",new Amount(5 )));
        stocks.add(new Stock(3,"branson",new Amount(6 )));
        return stocks;
    }

    @Autowired
    private List<Stock> stocks;

    @RequestMapping(value="/api/stocks", method= RequestMethod.GET)
    public ModelAndView getStocks(@ModelAttribute("newStock") Stock newStock) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main.html");
        modelAndView.addObject( "stocks", stocks);
        modelAndView.addObject( "newStock", newStock);
        return modelAndView;
    }

    @RequestMapping("/api/stocks/{id}")
    public ModelAndView getStock(@PathVariable Number id) {
        List<Stock> filterStocks = new ArrayList<Stock>();
        for(Stock stock:stocks){
            if (stock.getId().intValue()==id.intValue())
                filterStocks.add(stock);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main.html");
        modelAndView.addObject( "stocks", filterStocks);
        return modelAndView;
    }

    @RequestMapping(value = "api/stocks", method = RequestMethod.POST)
    public ModelAndView addStock(@ModelAttribute("newStock") Stock newStock){
        ModelAndView modelAndView = new ModelAndView();
        stocks.add(newStock);
        modelAndView.addObject( "stocks", stocks);
        modelAndView.setViewName("main.html");
        return modelAndView;
    }

}
