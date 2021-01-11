/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwery.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author engcarvalho
 */
@Entity
@Table(name = "SFT_USER")
public class User extends AbstractEntity {

    @Id
    @SequenceGenerator(name="id_seq_sft_user", sequenceName = "seq_sft_user", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq_sft_user")
    private Long id;

    @NotEmpty(message = "Name is required")
    @Column(name = "NAME")
    private String name;

    @NotEmpty(message = "Login is required")
    @Column(name = "USERNAME", unique = true)
    private String username;

    @NotEmpty(message = "E-mail is required")
    @Column(name = "EMAIL")
    private String email;

    @NotEmpty(message = "Password is required")
    @JsonIgnore
    @Column(name = "PASSWORD")
    private String password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "SFT_USER_ROLE",
            joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")
            )
    private Set<Role> roles = new HashSet<>();
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
