package com.course.api.service;

import com.course.api.entity.InvoiceDetail;

import java.util.List;

public interface InvoiceDetailService {
    List<InvoiceDetail> getAll() throws Exception;
    InvoiceDetail getInvoiceDetailById(Integer idInvoice) throws Exception;
    List<InvoiceDetail> getInvoiceDetailByInvoice(Integer id) throws Exception;
    InvoiceDetail getInvoiceDetailByStudent(Integer id) throws Exception;
    InvoiceDetail addInvoice(InvoiceDetail invoiceDetail) throws Exception;
    InvoiceDetail updateInvoice(InvoiceDetail invoiceDetail) throws Exception;
    void removeInvoice(InvoiceDetail invoiceDetail) throws Exception;
}
