package com.udemy.converter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestCrypt {

    public static void main(String args[]){
        BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
        System.out.print(pe);
        System.out.print("\n Prueba");
    }
}
