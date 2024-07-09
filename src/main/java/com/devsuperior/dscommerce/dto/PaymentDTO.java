package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Payment;

import java.time.Instant;

public class PaymentDTO {
    private final Long id;
    private final Instant moment;

    public PaymentDTO(Long id, Instant moment) {
        this.id = id;
        this.moment = moment;
    }
    public PaymentDTO(Payment payment) {
        this.id = payment.getId();
        this.moment =  payment.getMoment();
    }
    public Long getId() {
        return id;
    }

    public Instant getMoment() {
        return moment;
    }
}
