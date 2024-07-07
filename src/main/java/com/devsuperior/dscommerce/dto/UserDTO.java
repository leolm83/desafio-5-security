package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Role;
import com.devsuperior.dscommerce.entities.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class UserDTO {
    private String name;
    private String email;
    private String phone;
    private LocalDate birthDate;
    private final Set<String> roles = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public UserDTO(String name, String email, String phone, LocalDate birthDate, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
    }

    public UserDTO(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.birthDate = user.getBirthDate();
        for(GrantedAuthority role : user.getAuthorities()){
            this.roles.add(role.getAuthority());
        }
    }
}
