package com.dtsnk.gvg.entities;

import com.dtsnk.gvg.enumerator.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import javax.validation.constraints.*;

@Setter
@Getter
@Document("invoice")
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {
    @Size(min = 6, max = 50)
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
//    @Pattern(regexp = "IT\\d{2}[ ][a-zA-Z]\\d{3}[ ]\\d{4}[ ]\\d{4}[ ]\\d{4}[ ]\\d{4}[ ]\\d{3}|IT\\d{2}[a-zA-Z]\\d{22}")
    private String iban;

}
