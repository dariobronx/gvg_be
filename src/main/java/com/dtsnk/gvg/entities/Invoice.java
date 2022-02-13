package com.dtsnk.gvg.entities;

import com.dtsnk.gvg.enumerator.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Setter
@Getter
@Document("invoice")
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {
    @Id
    private String id;
    private int number;
    private int year;
    private User sellerUser;
    private User buyerUser;
    private LocalDateTime emissionDate;
    private Order order;
    private PaymentMethod paymentMethod;
    private boolean installments;
    private String iban;

}
