package com.course.api.service.serviceimpl;

import com.course.api.entity.Invoice;
import com.course.api.entity.Student;
import com.course.api.repository.InvoiceRepository;
import com.course.api.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("invoiceService")
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public List<Invoice> getAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice getInvoiceById(Integer idInvoice) {
        return invoiceRepository.findInvoiceByIdInvoice(idInvoice);
    }

    @Override
    public List<Invoice> getInvoiceByStudent(Student student) {
        return invoiceRepository.findInvoiceByStudent(student);
    }

    @Override
    public Invoice addInvoice(Invoice invoice) {
        invoice.setCreatedDate(new Date());
        invoice.setModifyDate(new Date());
        invoiceRepository.save(invoice);
        return invoice;
    }

    @Override
    public Invoice updateInVoice(Invoice invoice) {
        invoice.setModifyDate(new Date());
        invoiceRepository.save(invoice);
        return invoice;
    }

    @Override
    public void removeInvoice(Invoice invoice) {
        invoiceRepository.delete(invoice);
    }
}
