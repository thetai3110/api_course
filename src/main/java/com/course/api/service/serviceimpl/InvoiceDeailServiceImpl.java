package com.course.api.service.serviceimpl;

import com.course.api.entity.InvoiceDetail;
import com.course.api.repository.InvoiceDetailRepository;
import com.course.api.service.InvoiceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("invoiceDetailService")
public class InvoiceDeailServiceImpl implements InvoiceDetailService {

    @Autowired
    private InvoiceDetailRepository invoiceDetailRepository;

    @Override
    public List<InvoiceDetail> getAll() {
        return invoiceDetailRepository.findAll();
    }

    @Override
    public InvoiceDetail getInvoiceDetailById(Integer idInvoice) {
        return invoiceDetailRepository.findInvoiceDetailByIdInvoiceDetail(idInvoice);
    }

    @Override
    public List<InvoiceDetail> getInvoiceDetailByInvoice(Integer id) {
        return invoiceDetailRepository.findInvoiceDetailsByIdInvoice(id);
    }

    @Override
    public InvoiceDetail getInvoiceDetailByStudent(Integer id) {
        return invoiceDetailRepository.findInvoiceDetailByIdStudent(id);
    }

    @Override
    public InvoiceDetail addInvoice(InvoiceDetail invoiceDetail) {
        invoiceDetail.setCreatedDate(new Date());
        invoiceDetail.setModifyDate(new Date());
        invoiceDetailRepository.save(invoiceDetail);
        return invoiceDetail;
    }

    @Override
    public InvoiceDetail updateInvoice(InvoiceDetail invoiceDetail) {
        invoiceDetail.setModifyDate(new Date());
        invoiceDetailRepository.save(invoiceDetail);
        return invoiceDetail;
    }

    @Override
    public void removeInvoice(InvoiceDetail invoiceDetail) {
        invoiceDetailRepository.delete(invoiceDetail);
    }
}
