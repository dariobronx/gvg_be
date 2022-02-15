package com.dtsnk.gvg.controllers;

import com.dtsnk.gvg.entities.*;
import com.dtsnk.gvg.enumerator.PaymentMethod;
import com.dtsnk.gvg.repository.InvoiceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping(value = "/invoice")
public class InvoiceController {

	@Autowired
	private InvoiceRepository invoiceRepository;

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable String id) {
		log.debug("delete");
		invoiceRepository.deleteById(id);
	}

	@GetMapping("/all")
	public List<Invoice> all() {
		log.debug("get all invoice");
		return invoiceRepository.findAll();
	}

	@PostMapping("/add")
	public void add(@Validated @RequestBody Invoice invoice) throws HttpClientErrorException {
		log.debug("add invoice: {}", invoice.getId());
		String calculatedID = invoice.getNumber() + "-" + invoice.getYear();
		if (!calculatedID.equals(invoice.getId())) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Invalid invoice ID!");
		}
		invoiceRepository.save(invoice);
	}

	@GetMapping("/{id}")
	public Optional<Invoice> get(@PathVariable String id) {
		log.debug("get invoice: {}", id);
		return invoiceRepository.findById(id);
	}

	@GetMapping("/gen")
	public void gen() {
		Invoice invoice = new Invoice();
		User seller = new User("Angus Young", "pivaangusyoung123");
		User buyer = new User("Brian Johnson", "pivbrianjohnson123");
		invoice.setBuyerUser(buyer);
		invoice.setSellerUser(seller);
		invoice.setYear(2022);
		invoice.setNumber(12345);
		invoice.setEmissionDate(LocalDateTime.now());
		invoice.setPaymentMethod(PaymentMethod.CREDIT_CARD);
		Product product_01 = new Product("product_01", 11200, 22, false);
		Product product_02 = new Product("product_02", 50000, 10, true);
		Product product_03 = new Product("product_03", 15000, 22, false);
		int recordPieces = 3;
		int recordExpenses = product_01.getPrice() * recordPieces;
		int ivaExpense = recordExpenses * product_01.getIva() / 100;
		int totalExpense = recordExpenses + ivaExpense;
		OrderItem orderItem = new OrderItem(product_01, recordPieces, recordExpenses, ivaExpense, totalExpense);
		OrderItem orderItem2 = new OrderItem(product_02, recordPieces * 2, recordExpenses * 2, ivaExpense * 2, totalExpense * 3);
		OrderItem orderItem3 = new OrderItem(product_03, 1, recordExpenses, ivaExpense, totalExpense);
		Order order = new Order();
		order.addOrderItem(orderItem);
		order.addOrderItem(orderItem2);
		order.addOrderItem(orderItem3);
		order.setExpense(100000);
		order.setIva(22000);
		invoice.setOrder(order);
		invoiceRepository.save(invoice);
	}

}