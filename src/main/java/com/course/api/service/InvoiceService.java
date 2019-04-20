package com.course.api.service;

import com.course.api.dto.InvoiceDTO;
import com.course.api.entity.Employee;
import com.course.api.entity.Invoice;
import com.course.api.entity.Student;

import java.util.List;

public interface InvoiceService {
    List<Invoice> getAll() throws Exception;
    Invoice getInvoiceById(Integer idInvoice) throws Exception;
    List<Invoice> getInvoiceByEmployee(Employee employee) throws Exception;
    Invoice addInvoice(InvoiceDTO invoiceDTO) throws Exception;
    Invoice updateInvoice(Invoice invoice) throws Exception;
    Invoice updateInvoice(InvoiceDTO invoiceDTO, Integer idInvoice) throws Exception;
    void removeInvoice(Invoice invoice) throws Exception;
}
