package com.course.api.service;

import com.course.api.dto.PaymentDTO;
import com.course.api.model.ResponseModel;

public interface PaymentService {
    ResponseModel payment(PaymentDTO paymentDTO) throws Exception;
}
