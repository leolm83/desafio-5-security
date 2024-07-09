package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.User;

public class ClientDTO {

    private final  Long id;
    private final String name;

    public ClientDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public ClientDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
