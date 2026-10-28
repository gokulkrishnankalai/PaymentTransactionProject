package org.example.paymenttransactionproject.DTO;


public class Paymentdto{

   private String acctnum;
    private double acctbalance;

    public Paymentdto(String acctnum, double acctbalance)
    {
        this.acctnum=acctnum;
        this.acctbalance=acctbalance;
    }

    @Override
    public String toString() {
        return "Paymentdto{" +
                "acctnum='" + acctnum + '\'' +
                ", acctbalance=" + acctbalance +
                '}';
    }

    public String getAcctnum(){
        return acctnum;
    }

    public void setAcctnum(String acctnum){
        this.acctnum=acctnum;
    }

    public Double getAcctbalance(){
        return acctbalance;
    }

    public void setAcctbalance(Double acctbalance ){
        this.acctbalance=acctbalance;
    }

}