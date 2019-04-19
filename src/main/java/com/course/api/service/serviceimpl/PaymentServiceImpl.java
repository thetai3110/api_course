package com.course.api.service.serviceimpl;

import com.course.api.dto.InvoiceDTO;
import com.course.api.dto.PaymentDTO;
import com.course.api.entity.StudentClass;
import com.course.api.model.ResponseModel;
import com.course.api.repository.InvoiceRepository;
import com.course.api.sendemail.Email;
import com.course.api.service.InvoiceService;
import com.course.api.service.PaymentService;
import com.course.api.service.StudentClassService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private StudentClassService studentClassService;

    @Transactional(rollbackOn = Exception.class)
    @Override
    public ResponseModel payment(PaymentDTO paymentDTO) {
        ResponseModel model = new ResponseModel();
        try{
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.addMappings(new PropertyMap<PaymentDTO, InvoiceDTO>() {
                @Override
                protected void configure() {
                    skip().setIdInvoice(null);
                }
            });
            InvoiceDTO invoiceDTO = modelMapper.map(paymentDTO, InvoiceDTO.class);
            invoiceService.addInvoice(invoiceDTO);
            ModelMapper modelMapper1 = new ModelMapper();
            StudentClass studentClass = modelMapper1.map(paymentDTO, StudentClass.class);
            studentClass.setIdStudentClass(paymentDTO.getIdStudentclass());
            studentClassService.updateStudentClass(studentClass);
            if(!invoiceDTO.getEmail().equals("") || invoiceDTO.getEmail() != null){
               // Email.send("Xác nhân thanh toán học phí", "Bạn đã đóng học phí thành công!!!", invoiceDTO.getEmail());
            }
            model.setMessage("success");
            model.setData(paymentDTO);
            return model;
        }catch (Exception e){
            e.printStackTrace();
            model.setMessage("fail");
            return model;
        }
    }
}
