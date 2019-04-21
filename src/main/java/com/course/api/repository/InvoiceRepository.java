package com.course.api.repository;

import com.course.api.entity.Employee;
import com.course.api.entity.Invoice;
import com.course.api.entity.Register;
import com.course.api.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
    Invoice findInvoiceByIdInvoice(Integer idInvoice);
    List<Invoice> findInvoiceByEmployee(Employee employee);
}
