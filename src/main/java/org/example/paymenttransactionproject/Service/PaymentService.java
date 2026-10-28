package org.example.paymenttransactionproject.Service;


import jakarta.transaction.Transactional;
import org.example.paymenttransactionproject.DTO.Paymentdto;
import org.example.paymenttransactionproject.Entity.Payment;
import org.example.paymenttransactionproject.Repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentService{

/*
    Paymentdto d1=new Paymentdto("12345678",2300.00);
    Paymentdto d2=new Paymentdto("12345678",2300.00);
    Paymentdto d3=new Paymentdto("12345678",2300.00);
    Paymentdto d4=new Paymentdto("12345678",2300.00);
*/
    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository){
        this.paymentRepository=paymentRepository;
    }

    /*List<Paymentdto> accounts=new ArrayList<>();

    public PaymentService(){
        accounts.add(new Paymentdto("123456789",4000.00));
        accounts.add(new Paymentdto("365634636",6000.00));
        accounts.add(new Paymentdto("432634545",8000.00));
        accounts.add(new Paymentdto("532667534",2000.00));
    }*/

 /* @Transactional
  public String transfer(String fromAcct, String toAcct, Double amount) {

        Paymentdto fromAccount=null;
        Paymentdto toAccount=null;

        for(Paymentdto user:accounts) {

            if (user.getAcctnum().equals(fromAcct)) {
                fromAccount = user;
            }
            if (user.getAcctnum().equals(toAcct)) {
                toAccount = user;
            }
        }

            // Validate accounts
            if (fromAccount == null || toAccount == null) { return "Accounts are Invalid"; }

            if(amount<=0)
            {
                return "Insuficent Balance";
            }

            if(fromAccount.equals(toAccount)){
                return "Account Both Same";
            }
            fromAccount.setAcctbalance(fromAccount.getAcctbalance()-amount);
            toAccount.setAcctbalance(toAccount.getAcctbalance()+amount);




        String response="Transaction Succesfull \n \n"+ " From Account " +fromAccount.getAcctnum()+"\n"+
                "Debited Amount" +amount +"\n"+
                "Remaining Balance "+fromAccount.getAcctbalance()+"\n\n"+

                "ToAccount "+toAccount.getAcctnum()+"\n"+
                "Credited Amount "+amount+"\n"+
                "Remaining Balance "+toAccount.getAcctbalance();

return response;
    }*/
@Transactional
public String transfer(String fromAcct, String toAcct, Double amount) {

    Payment fromAccount=paymentRepository.findById(fromAcct).orElse(null);
    Payment toAccount=paymentRepository.findById(toAcct).orElse(null);

    /*for(Paymentdto user:accounts) {

        if (user.getAcctnum().equals(fromAcct)) {
            fromAccount = user;
        }
        if (user.getAcctnum().equals(toAcct)) {
            toAccount = user;
        }
    }*/


    // Validate accounts
    if (fromAccount == null || toAccount == null) { return "Accounts are Invalid"; }

    if(amount<=0)
    {
        return "Insuficent Balance";
    }

    if(fromAccount.equals(toAccount)){
        return "Account Both Same";
    }
    fromAccount.setAcctbalance(fromAccount.getAcctbalance()-amount);
    toAccount.setAcctbalance(toAccount.getAcctbalance()+amount);
    paymentRepository.save(fromAccount);
    paymentRepository.save(toAccount);



    String response="Transaction Succesfull \n \n"+ " From Account " +fromAccount.getAcctnum()+"\n"+
            "Debited Amount" +amount +"\n"+
            "Remaining Balance "+fromAccount.getAcctbalance()+"\n\n"+

            "ToAccount "+toAccount.getAcctnum()+"\n"+
            "Credited Amount "+amount+"\n"+
            "Remaining Balance "+toAccount.getAcctbalance();

    return response;
}

    public List<Payment> getall() {
        return paymentRepository.findAll() ;
    }
}