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

}