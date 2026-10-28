package org.example.paymenttransactionproject.DTO;

public class Paymentdto{
    public String getAcctnum() {
        return acctnum;
    }

    public Paymentdto(String acctnum, double balance) {
        this.acctnum = acctnum;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Paymentdto{" +
                "acctnum='" + acctnum + '\'' +
                ", balance=" + balance +
                '}';
    }

    public void setAcctnum(String acctnum) {
        this.acctnum = acctnum;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private String acctnum;
    private double balance;
}