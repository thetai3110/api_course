package com.course.api.service.serviceimpl;

import com.course.api.entity.Sales;
import com.course.api.repository.SalesRepository;
import com.course.api.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("salesService")
public class SalesServiceImpl implements SalesService {

    @Autowired
    private SalesRepository salesRepository;

    @Override
    public List<Sales> getAll() {
        return salesRepository.findAll();
    }

    @Override
    public Sales getSalesById(Integer idSales) {
        return salesRepository.findSalesByIdSales(idSales);
    }

    @Override
    public Sales getSalesByCode(String code) {
        return salesRepository.findSalesByCodeAndStatus(code,1);
    }

    @Override
    public Sales addSales(Sales sales) {
        salesRepository.save(sales);
        return sales;
    }

    @Override
    public Sales updateSales(Sales sales) {
        salesRepository.save(sales);
        return sales;
    }

    @Override
    public void removeSales(Sales sales) {
        salesRepository.delete(sales);
    }
}
