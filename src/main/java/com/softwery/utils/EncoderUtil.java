/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwery.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author engcarvalho
 */
public class EncoderUtil {
    
    public static void main(String[] args) {
        BCryptPasswordEncoder password = new BCryptPasswordEncoder();
        
        System.out.println(password.encode(""));
    }
    
}
