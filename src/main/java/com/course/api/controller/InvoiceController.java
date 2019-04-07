package com.course.api.controller;

import com.course.api.dto.InvoiceDTO;
import com.course.api.entity.Invoice;
import com.course.api.sendemail.Email;
import com.course.api.service.InvoiceService;
import com.course.api.service.StudentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Invoice>> getAllInvoice() {
        try {
            List<Invoice> invoices = invoiceService.getAll();
            if (invoices.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<Invoice>>(invoices, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable(name = "id") Integer id) {
        try {
            Invoice invoice = invoiceService.getInvoiceById(id);
            if (invoice == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<Invoice>(invoice, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Invoice> addInvoice(@RequestBody InvoiceDTO invoiceDTO) {
        try {
            if (invoiceDTO == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<Invoice>(invoiceService.addInvoice(invoiceDTO), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<Invoice> updateInvoice(@PathVariable(name = "id") Integer idInvoice, @RequestBody InvoiceDTO invoiceDTO) {
        try {
            Invoice curInvoice = invoiceService.getInvoiceById(idInvoice);
            if (curInvoice == null) return new ResponseEntity(HttpStatus.NOT_FOUND);
            return new ResponseEntity<Invoice>(invoiceService.updateInvoice(invoiceDTO, idInvoice), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public boolean deleteInvocie(@PathVariable(name = "id") Integer id) {
        try {
            Invoice invoice = invoiceService.getInvoiceById(id);
            if (invoice == null) return false;
            invoiceService.removeInvoice(invoice);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
