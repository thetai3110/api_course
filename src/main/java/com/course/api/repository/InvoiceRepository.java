package com.course.api.repository;

import com.course.api.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
    Invoice findInvoiceByIdInvoice(Integer idInvoice);
    List<Invoice> findInvoiceByEmployee(Employee employee);
    List<Invoice> findInvoiceByClazz(Clazz clazz);
}
