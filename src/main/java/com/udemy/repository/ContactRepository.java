package com.udemy.repository;


import com.udemy.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("ContactRepository")
public interface ContactRepository extends JpaRepository<Contact,Serializable>{

    public abstract Contact findById(int id);
}
