/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwery.enums;

/**
 *
 * @author engcarvalho
 */
public enum EnumRole implements Enum {
    
    USER("USER", "User"),
    ALLOWS_TO_DELETE_USER("ALLOWS_TO_DELETE_USER", "Allows to delete user"),
    ADMIN("ADMIN", "Allows to delete user");
    
    private final String key, value;

    private EnumRole(String key, String value) {
        this.key = key;
        this.value = value;        
    }        
    
    
    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
