package com.stock.controller;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stock.model.Stock;
import com.stock.service.StockService;

@RestController
public class StockController {

	@Autowired
	private StockService stockService;

	@CrossOrigin
	@RequestMapping(value = "/stocks", method = RequestMethod.GET)
	List<Stock> getAllStocks() {
		Double askPrice = ThreadLocalRandom.current().nextDouble(41, 43);
		Double bidPrice = ThreadLocalRandom.current().nextDouble(38, 40);

		List<Stock> stocks = stockService.findAll();
		stocks.stream().forEach(stock -> {
			stock.setBidPrice(bidPrice);
			stock.setAskPrice(askPrice);
			stock.setEventTime(new Date());
		});
		return stocks;
	}
}
