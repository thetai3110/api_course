package com.course.api.repository;

import com.course.api.entity.InvoiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail, Integer> {
    List<InvoiceDetail> findInvoiceDetailsByIdInvoice(Integer id);
    InvoiceDetail findInvoiceDetailByIdInvoiceDetail(Integer id);
    InvoiceDetail findInvoiceDetailByIdStudent(Integer id);
}
