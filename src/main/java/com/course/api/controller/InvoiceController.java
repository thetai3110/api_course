package com.course.api.controller;

import com.course.api.entity.Invoice;
import com.course.api.service.InvoiceService;
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

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Invoice> addInvoice(@RequestBody Invoice invoice) {
        try {
            if (invoice == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<Invoice>(invoiceService.addInvoice(invoice), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Invoice> updateInvoice(@PathVariable(name = "idInvoice") Integer idInvoice, @RequestBody Invoice invoice) {
        try {
            Invoice curInvoice = invoiceService.getInvoiceById(idInvoice);
            if (curInvoice == null) return new ResponseEntity(HttpStatus.NOT_FOUND);
            invoice.setIdInvoice(idInvoice);
            return new ResponseEntity<Invoice>(invoiceService.updateInVoice(invoice), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
