package com.course.api.repository;

import com.course.api.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<Sales, Integer> {
    Sales findSalesByIdSales(Integer idSales);
    Sales findSalesByCode(String code);
}
