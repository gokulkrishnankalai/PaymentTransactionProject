package org.example.paymenttransactionproject.Controller;

import org.example.paymenttransactionproject.DTO.Paymentdto;
import org.example.paymenttransactionproject.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController{


    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this.paymentService=paymentService;
    }

    @PostMapping("/transfer")
    public String transfer(@RequestParam("fromAcct") String fromAcct,@RequestParam("toAcct") String toAcct,@RequestParam("amount") Double amount){
        return paymentService.transfer(fromAcct,toAcct,amount);
    }

    @GetMapping("/allaccount")
    public List<Paymentdto> getall(){
        return paymentService.getall();
    }

}