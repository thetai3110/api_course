package com.course.api.controller;

import com.course.api.dto.PaymentDTO;
import com.course.api.model.ResponseModel;
import com.course.api.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public int payment(@RequestBody PaymentDTO paymentDTO){
        if(paymentDTO == null) return 0;
        try {
            ResponseModel model = paymentService.payment(paymentDTO);
            if(model.getMessage().equals("success")) return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
