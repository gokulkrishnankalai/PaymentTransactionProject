package org.example.paymenttransactionproject.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="GK_PAYMENT")
public class Payment {
    @Id
    private String acctnum;
    private Double acctbalance;

    public String getAcctnum() {
        return acctnum;
    }

    public void setAcctnum(String acctnum) {
        this.acctnum = acctnum;
    }

    public Double getAcctbalance() {
        return acctbalance;
    }

    public void setAcctbalance(Double acctbalance) {
        this.acctbalance = acctbalance;
    }

    public Payment(){

    }

    @Override
    public String toString() {
        return "Payment{" +
                "acctnum='" + acctnum + '\'' +
                ", acctbalance=" + acctbalance +
                '}';
    }

    public Payment(String acctnum, Double acctbalance ){
        this.acctnum=acctnum;
        this.acctbalance=acctbalance;
    }
}
