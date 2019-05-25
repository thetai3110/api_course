package com.course.api.controller;

import com.course.api.entity.InvoiceDetail;
import com.course.api.entity.StudentClass;
import com.course.api.service.InvoiceDetailService;
import com.course.api.service.StudentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/invoice-detail")
public class InvoiceDetailController {

    @Autowired
    private InvoiceDetailService invoiceDetailService;

    @Autowired
    private StudentClassService studentClassService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<InvoiceDetail>> getAllInvoiceDetail() {
        try {
            List<InvoiceDetail> invoiceDetails = invoiceDetailService.getAll();
            if (invoiceDetails.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<InvoiceDetail>>(invoiceDetails, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<InvoiceDetail> getInvoiceDetailById(@PathVariable(name = "id") Integer id) {
        try {
            InvoiceDetail invoiceDetail = invoiceDetailService.getInvoiceDetailById(id);
            if (invoiceDetail == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<InvoiceDetail>(invoiceDetail, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<InvoiceDetail> addInvoiceDetail(@RequestBody InvoiceDetail invoiceDetail) {
        try {
            if (invoiceDetail == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            StudentClass studentClass = studentClassService.getStudentClassByStudentAndClass(invoiceDetail.getIdStudent(), invoiceDetail.getIdClass());
            studentClass.setIsFee(1);
            studentClassService.updateStudentClass(studentClass);
            return new ResponseEntity<InvoiceDetail>(invoiceDetailService.addInvoice(invoiceDetail), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<InvoiceDetail> updateInvoice(@PathVariable(name = "id") Integer idInvoice, @RequestBody InvoiceDetail invoiceDetail) {
        try {
            InvoiceDetail curInvoice = invoiceDetailService.getInvoiceDetailById(idInvoice);
            if (curInvoice == null) return new ResponseEntity(HttpStatus.NOT_FOUND);
            invoiceDetail.setIdInvoiceDetail(idInvoice);
            invoiceDetail.setCreatedDate(curInvoice.getCreatedDate());
            return new ResponseEntity<InvoiceDetail>(invoiceDetailService.updateInvoice(invoiceDetail), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public boolean deleteInvocie(@PathVariable(name = "id") Integer id) {
        try {
            InvoiceDetail invoice = invoiceDetailService.getInvoiceDetailById(id);
            if (invoice == null) return false;
            invoiceDetailService.removeInvoice(invoice);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
