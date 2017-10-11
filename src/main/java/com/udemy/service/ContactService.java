package com.udemy.service;

import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;

import java.util.List;

public interface ContactService {

    public abstract ContactModel addContact(ContactModel contactModel);

    public abstract List<ContactModel> listAll();

    public abstract Contact findById(int id);

    public abstract void deleteContact(int id);

    public abstract ContactModel findByIdModel(int id);
}
