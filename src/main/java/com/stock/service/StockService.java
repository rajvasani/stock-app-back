package com.stock.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stock.model.Stock;

public interface StockService extends JpaRepository<Stock, Integer>{
}
