package org.example.paymenttransactionproject.Controller;

import org.example.paymenttransactionproject.DTO.Paymentdto;
import org.example.paymenttransactionproject.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController{

    @Autowired
    private final PaymentService payment;


    public PaymentController(PaymentService payment) {
        this.payment = payment;
    }

    @PostMapping("/transfer")
    public String transfer(@RequestParam("fromAcct") String fromAcct,
    @RequestParam("toAcct") String toAcct,
    @RequestParam("amt") Double amt){
        return payment.transfer(fromAcct,toAcct,amt);
    }

    @GetMapping("/getdetails")
    public List<Paymentdto> getdetails(){
        return payment.getAccounts();
    }
}