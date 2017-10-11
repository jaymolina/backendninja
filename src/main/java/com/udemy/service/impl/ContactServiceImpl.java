package com.udemy.service.impl;

import com.udemy.converter.ContactConverter;
import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;
import com.udemy.repository.ContactRepository;
import com.udemy.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service("ContactServiceImpl")
public class ContactServiceImpl implements ContactService {

    @Autowired
    @Qualifier("ContactRepository")
    private ContactRepository repository;

    @Autowired
    @Qualifier("ContactConverter")
    private ContactConverter converter;

    @Override
    public ContactModel addContact(ContactModel contactModel) {
        return converter.model2entity(repository.save(converter.entity2model(contactModel)));
    }

    @Override
    public List<ContactModel> listAll() {

        List<Contact> contactList = repository.findAll();
        Iterator iterator = contactList.iterator();
        List<ContactModel> contactModelList = new ArrayList<ContactModel>();

        while (iterator.hasNext()) {
            Contact contact = (Contact) iterator.next();
            contactModelList.add(converter.model2entity(contact));
        }
        return contactModelList;
    }

    public ContactModel findByIdModel(int id) {
        Contact contact = findById(id);
        return converter.model2entity(contact);
    }

    @Override
    public Contact findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void deleteContact(int id) {
        Contact contact = findById(id);
        if (contact != null) {
            repository.delete(id);
        }


    }
}


