package com.dtsnk.gvg;

import com.dtsnk.gvg.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class GvgApplication {

    @Autowired
    InvoiceRepository invoiceRepository;

    public static void main(String[] args) {
        SpringApplication.run(GvgApplication.class, args);
    }

}
