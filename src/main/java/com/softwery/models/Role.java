/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwery.models;

import com.softwery.enums.EnumRole;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author engcarvalho
 */
@Entity
@Table(name = "SFT_ROLE")
public class Role extends AbstractEntity {

    @Id
    @SequenceGenerator(name="id_seq_sft_role", sequenceName = "seq_sft_role", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq_sft_role")
    private Long id;    
    
    @Enumerated(EnumType.STRING)
    private EnumRole role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EnumRole getRole() {
        return role;
    }

    public void setRole(EnumRole role) {
        this.role = role;
    }
}
