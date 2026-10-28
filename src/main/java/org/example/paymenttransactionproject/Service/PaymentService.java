package org.example.paymenttransactionproject.Service;


import org.example.paymenttransactionproject.DTO.Paymentdto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentService{
List<Paymentdto> accounts=new ArrayList<>();

    public PaymentService() {
        accounts.add(new Paymentdto( "840092501685",1000.00));
        accounts.add(new Paymentdto( "840092124323",2000.00));
        accounts.add(new Paymentdto( "840087785634",5000.00));
        accounts.add(new Paymentdto( "840043678612",8000.00));
    }

    public String transfer(String fromacct, String toAcct, Double amt) {

        Paymentdto fromAccount=null;
        Paymentdto toAccount=null;

        for(Paymentdto account:accounts){
            // 1. Find From Account
            if(account.getAcctnum().equals(fromacct)){
                fromAccount=account;
            }
            if(account.getAcctnum().equals(toAcct)){
                toAccount=account;
            }
            // 2. Validate accounts
            if(fromAccount==null || toAccount==null){
                return "Account Not Found";
            }
            // 3. Validate amount
            if(amt<=0){
                return "Invalid Transfer Amount";
            }
            // 4. Validate same account
            if(fromAccount.equals(toAccount)){
                return "From Account and to Account Are Equall";
            }

            // 5. Check balance from Account
            if(fromAccount.getBalance()<amt){
                return "Insufficient Balance";
            }

            // 6. Debit From Account
            fromAccount.setBalance(fromAccount.getBalance()-amt);
            // 7. Credit To Account
            toAccount.setBalance(toAccount.getBalance()+amt);



        }
        String response =
                "Payment Successful!\n\n" +

                        "From Account: " + fromacct + "\n" +
                        "Debited Amount: ₹" + amt + "\n" +
                        "Remaining Balance: ₹" +
                        fromAccount.getBalance() + "\n\n" +

                        "To Account: " + toAcct + "\n" +
                        "Credited Amount: ₹" + amt + "\n" +
                        "Available Balance: ₹" +
                        toAccount.getBalance();
        return response;
    }

    public List<Paymentdto> getAccounts() {
        return accounts;
    }
}