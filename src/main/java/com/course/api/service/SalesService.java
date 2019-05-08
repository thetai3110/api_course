package com.course.api.service;

import com.course.api.entity.Sales;

import java.util.List;

public interface SalesService {
    List<Sales> getAll() throws Exception;
    Sales getSalesById(Integer idSales) throws Exception;
    Sales getSalesByCode(String code) throws Exception;
    Sales addSales(Sales sales) throws Exception;
    Sales updateSales(Sales sales) throws Exception;
    void removeSales(Sales sales) throws Exception;
}
