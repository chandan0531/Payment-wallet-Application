package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

<<<<<<<< HEAD:Project unit-6/PaymentWalletApplication/src/main/java/com/masai/repository/BillPaymentDao.java
import com.masai.entities.BillPayment;

@Repository
public interface BillPaymentDao extends JpaRepository<BillPayment, Integer> {

========
import com.masai.entities.Customer;

@Repository
public interface CustomerDao extends JpaRepository<CustomerDao, String> {

	public Optional<Customer> findByMobileNumber(String mobileNo);
	
>>>>>>>> b65ea6ddd3dac65b1e0fd5bdb11c3d540807626b:Project unit-6/PaymentWalletApplication/src/main/java/com/masai/repository/CustomerDao.java
}
