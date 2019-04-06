package com.course.api.service.serviceimpl;

import com.course.api.dto.InvoiceDTO;
import com.course.api.entity.Invoice;
import com.course.api.entity.Student;
import com.course.api.repository.CourseRepository;
import com.course.api.repository.EmployeeRepository;
import com.course.api.repository.InvoiceRepository;
import com.course.api.repository.StudentRepositoty;
import com.course.api.service.InvoiceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("invoiceService")
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private StudentRepositoty studentRepositoty;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CourseRepository courseRepository;

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
    public Invoice updateInvoice(Invoice invoice) {
        invoice.setModifyDate(new Date());
        invoiceRepository.save(invoice);
        return invoice;
    }

    @Override
    public Invoice updateInvoice(InvoiceDTO invoiceDTO, Integer idInvoice) {
        ModelMapper modelMapper = new ModelMapper();
        Invoice invoice = modelMapper.map(invoiceDTO, Invoice.class);
        invoice.setIdInvoice(idInvoice);
        invoice.setStudent(studentRepositoty.findStudentByIdStudent(invoiceDTO.getIdSudent()));
        invoice.setEmployee(employeeRepository.findEmployeeByIdEmployee(invoiceDTO.getIdEmployee()));
        invoice.setCourse(courseRepository.findCourseByIdCourse(invoiceDTO.getIdCourse()));
        invoice.setModifyDate(new Date());
        invoiceRepository.save(invoice);
        return invoice;
    }

    @Override
    public void removeInvoice(Invoice invoice) {
        invoiceRepository.delete(invoice);
    }
}
