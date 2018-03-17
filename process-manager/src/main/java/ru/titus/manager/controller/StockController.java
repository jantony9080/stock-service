package ru.titus.manager.controller;

import model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.titus.manager.service.StockUtils;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StockController {

    @Autowired
    @Qualifier("stocks")
    private List<Stock> stocks;
    @Autowired
    @Qualifier("newStock")
    private Stock newStock;
    @Autowired
    private StockUtils stockUtils;

    @RequestMapping(value="/api/stocks", method= RequestMethod.GET)
    public ModelAndView getStocks() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject( "stocks", stocks);
        modelAndView.addObject( "newStock", newStock);
        modelAndView.setViewName("main.html");
        return modelAndView;
    }

    @RequestMapping(value = "api/stocks", method = RequestMethod.POST, params = {"action=save"})
    public ModelAndView addStock(@ModelAttribute("newStock") Stock newStock){
        ModelAndView modelAndView = new ModelAndView();
        if (stockUtils.isNew(stocks,newStock))
            stocks.add(newStock);
        modelAndView.addObject( "stocks", stocks);
        modelAndView.setViewName("main.html");
        return modelAndView;
    }

    @RequestMapping(value = "api/stocks", method = RequestMethod.POST, params = {"action=update"})
    public ModelAndView updateStock(@ModelAttribute("newStock") Stock newStock){
        ModelAndView modelAndView = new ModelAndView();
        if (stockUtils.isNotNew(stocks,newStock))
            stocks.set(stockUtils.getPosition(stocks,newStock),newStock);
        modelAndView.addObject( "stocks", stocks);
        modelAndView.setViewName("main.html");
        return modelAndView;
    }

    @RequestMapping(value="/api/stocks/{id}", method= RequestMethod.GET)
    public ModelAndView getStock(@PathVariable Number id) {
        List<Stock> filterStocks = new ArrayList<Stock>();
        for(Stock stock:stocks){
            if (stock.getId().intValue()==id.intValue())
                filterStocks.add(stock);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject( "stocks", filterStocks);
        modelAndView.addObject( "newStock", newStock);
        modelAndView.setViewName("main.html");
        return modelAndView;
    }

    @RequestMapping(value = "api/stocks/{id}", method = RequestMethod.PUT)
    public @ResponseBody String updateUser(@PathVariable Number id, @RequestBody Stock inputStock){
        String status = "No element";
        if (stockUtils.isNotNew(stocks,inputStock)) {
            stocks.set( stockUtils.getPosition( stocks, inputStock ), inputStock );
            status = "Successfull update";
        }
        return status;
    }
}
