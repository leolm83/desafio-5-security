package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Order;
import com.devsuperior.dscommerce.entities.OrderItem;
import com.devsuperior.dscommerce.entities.OrderStatus;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class OrderDTO {
    private final Long id;
    private final Instant moment;
    private final OrderStatus status;
    private final ClientDTO client;
    private final PaymentDTO payment;

    private final Set<OrderItemDTO> items = new HashSet<>();

    public OrderDTO(Long id, Instant moment, OrderStatus status, ClientDTO client, PaymentDTO payment) {
        this.id = id;
        this.moment = moment;
        this.status = status;
        this.client = client;
        this.payment = payment;
    }
    public OrderDTO(Order order) {
        this.id = order.getId();
        this.moment = order.getMoment();
        this.status = order.getStatus();
        this.client = new ClientDTO(order.getClient());
        this.payment = (order.getPayment() == null)? null :new PaymentDTO(order.getPayment());
        for(OrderItem item : order.getItems()){
            this.items.add(new OrderItemDTO(item));
        }
    }

    public Long getId() {
        return id;
    }

    public Instant getMoment() {
        return moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public ClientDTO getClient() {
        return client;
    }

    public PaymentDTO getPayment() {
        return payment;
    }

    public Set<OrderItemDTO> getItems() {
        return items;
    }
    public Double getTotal(){
        double sum = 0.0;
        for(OrderItemDTO item : items){
            sum += item.getSubTotal();
        }
        return sum;
    }
}
