package ru.titus.manager.service;

import model.Stock;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockUtils {

    public Boolean isNew(List<Stock> stocks, Stock searchStock){
        Boolean result = true;
        for (Stock stock:stocks){
            if (stock.getId().intValue()==searchStock.getId().intValue())
                result=false;
        }
        return result;
    }

    public Boolean isNotNew(List<Stock> stocks, Stock searchStock){
        Boolean result = false;
        for (Stock stock:stocks){
            if (stock.getId().intValue()==searchStock.getId().intValue())
                result=true;
        }
        return result;
    }

    public int getPosition(List<Stock> stocks, Stock searchStock){
        int position = -1;
        for (Stock stock:stocks){
            if (stock.getId().intValue()==searchStock.getId().intValue())
                position=stocks.indexOf(stock);
        }
        return position;
    }

}
