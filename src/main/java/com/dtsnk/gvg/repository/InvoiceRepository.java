package com.dtsnk.gvg.repository;

import com.dtsnk.gvg.entities.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InvoiceRepository extends MongoRepository<Invoice, String> {

}