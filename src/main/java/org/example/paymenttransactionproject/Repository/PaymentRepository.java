package org.example.paymenttransactionproject.Repository;

import org.example.paymenttransactionproject.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository  extends JpaRepository <Payment,String>
{
}
