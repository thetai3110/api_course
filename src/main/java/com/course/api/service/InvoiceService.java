package com.course.api.service;

import com.course.api.entity.Invoice;
import com.course.api.entity.Student;

import java.util.List;

public interface InvoiceService {
    List<Invoice> getAll() throws Exception;
    Invoice getInvoiceById(Integer idInvoice) throws Exception;
    List<Invoice> getInvoiceByStudent(Student student) throws Exception;
    Invoice addInvoice(Invoice invoice) throws Exception;
    Invoice updateInVoice(Invoice invoice) throws Exception;
    void removeInvoice(Invoice invoice) throws Exception;
}
