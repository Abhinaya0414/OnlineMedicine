package com.OnlineMedicalShop.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OnlineMedicalShop.model.Payment;
import com.OnlineMedicalShop.repository.PaymentRepository;

@Service
public class PaymentServiceImpl {

	@Autowired
	PaymentRepository paymentRepository;

	public Payment addPayment(Payment p) {
		return paymentRepository.save(p);
	}

	public List<Payment> getAllPayments() {
		return paymentRepository.findAll();
	}

	public Payment getPaymentById(int id) {
		return paymentRepository.findById(id).orElse(null);
	}

	public boolean updatePayment(Payment p, int id) {
		Payment existingPayment = paymentRepository.findById(id).orElse(null);
		if (existingPayment != null) {
			existingPayment.setName(p.getName());
			existingPayment.setAddress(p.getAddress());
			existingPayment.setMobilenumber(p.getMobilenumber());
			existingPayment.setAmount(p.getAmount());
			paymentRepository.save(existingPayment);
			return true;
		}
		return false;
	}

	public boolean deletePayment(int id) {
		paymentRepository.deleteById(id);
		return true;
	}

}
