package com.udemy.converter;

import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;
import org.springframework.stereotype.Component;

@Component("ContactConverter")
public class ContactConverter {

    public Contact entity2model(ContactModel contactModel){
        Contact contact = new Contact(contactModel.getId(), contactModel.getFirstname(), contactModel.getLastname(), contactModel.getTelephone(), contactModel.getCity());
        return contact;
    }

    public ContactModel model2entity(Contact contact){
        ContactModel contactModel = new ContactModel(contact.getId(),contact.getFirstName(),contact.getLastName(),contact.getTelephone(),contact.getCity());
        return contactModel;
    }
}
