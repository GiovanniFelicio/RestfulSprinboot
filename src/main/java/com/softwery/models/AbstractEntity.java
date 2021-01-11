/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwery.models;

import java.io.Serializable;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author engcarvalho
 */
@MappedSuperclass
public class AbstractEntity implements Serializable {
    
    private static final long serialVersionUID = -558553967080513790L;
    
}
