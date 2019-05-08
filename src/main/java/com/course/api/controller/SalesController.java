package com.course.api.controller;

import com.course.api.entity.Sales;
import com.course.api.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SalesController {

    @Autowired
    private SalesService salesService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Sales>> getAllSales() {
        try {
            List<Sales> sales = salesService.getAll();
            if (sales.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<Sales>>(sales, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Sales> getSalesById(@PathVariable(name = "id") Integer id) {
        try {
            Sales sales = salesService.getSalesById(id);
            if (sales == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<Sales>(sales, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/code/{code}", method = RequestMethod.GET)
    public ResponseEntity<Sales> getSalesByCode(@PathVariable(name = "code") String code) {
        try {
            Sales sales = salesService.getSalesByCode(code);
            if (sales == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<Sales>(sales, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Sales> addSales(@RequestBody Sales sales) {
        try {
            if (sales == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<Sales>(salesService.addSales(sales), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<Sales> updateSales(@PathVariable(name = "id") Integer id, @RequestBody Sales sales) {
        try {
            Sales curSales = salesService.getSalesById(id);
            if (curSales == null) return new ResponseEntity(HttpStatus.NOT_FOUND);
            sales.setIdSales(id);
            return new ResponseEntity<Sales>(salesService.updateSales(sales), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public boolean deleteRoles(@PathVariable(name = "id") Integer id) {
        try {
            Sales sales = salesService.getSalesById(id);
            if (sales == null) return false;
            salesService.removeSales(sales);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
