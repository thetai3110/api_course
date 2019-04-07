package com.course.api.service.serviceimpl;

import com.course.api.dto.EmployeeDTO;
import com.course.api.entity.Employee;
import com.course.api.entity.Invoice;
import com.course.api.repository.AccountRepositoty;
import com.course.api.repository.EmployeeRepository;
import com.course.api.service.EmployeeService;
import com.course.api.service.InvoiceService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AccountRepositoty accountRepositoty;

    @Autowired
    private InvoiceService invoiceService;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Integer idEmp) {
        return employeeRepository.findEmployeeByIdEmployee(idEmp);
    }

    @Override
    public Employee getEmployeeAccount(Integer idAccount) {
        try {
            String query = "SELECT * FROM EMPLOYEE WHERE id_account =:idAccount";
            Employee employee = (Employee) entityManager.createNativeQuery(query, Employee.class).setParameter("idAccount", idAccount).getSingleResult();
            return employee;
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public Employee addEmployee(EmployeeDTO employeeDTO){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<EmployeeDTO, Employee>() {
            @Override
            protected void configure() {
                skip().setIdEmployee(null);
            }
        });
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        employee.setAccountEmp(accountRepositoty.findAccountByIdAccount(employeeDTO.getIdAccount()));
        employee.setCreatedDate(new Date());
        employee.setModifyDate(new Date());
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(EmployeeDTO employeeDTO, Integer idEmployee){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<EmployeeDTO, Employee>() {
            @Override
            protected void configure() {
                skip().setIdEmployee(null);
            }
        });
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        employee.setIdEmployee(idEmployee);
        employee.setAccountEmp(accountRepositoty.findAccountByIdAccount(employeeDTO.getIdAccount()));
        employee.setModifyDate(new Date());
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) throws Exception {
        employee.setModifyDate(new Date());
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public void removeEmployee(Employee employee) throws Exception {
        if(!invoiceService.getInvoiceByEmployee(employee).isEmpty()){
            for (Invoice invoice:
                    invoiceService.getInvoiceByEmployee(employee)) {
                invoice.setEmployee(null);
                invoiceService.updateInvoice(invoice);
            }
        }
        employeeRepository.delete(employee);
    }
}
