package com.udemy.controller;

import com.udemy.constant.ViewConstant;

import com.udemy.model.ContactModel;
import com.udemy.service.ContactService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@PreAuthorize("permitAll()")
@RequestMapping("/contacts")
public class ContactController {

    private static final Log LOGGER = LogFactory.getLog(ContactController.class);

    @Autowired
    @Qualifier("ContactServiceImpl")
    private ContactService contactService;


    @GetMapping("/contactform")
    public String redirectContactForm(@RequestParam(name = "id", required = false) int id,
                                      Model model){
        ContactModel contactModel = new ContactModel();
        if(id != 0){
            contactModel = contactService.findByIdModel(id);
        }
        model.addAttribute("contactModel", contactModel);
        return ViewConstant.CONTACT_FORM;
    }



    @GetMapping("/cancel")
    public String cancel(Model model){

        return "redirect:/contacts/showcontacts";
    }

    @PostMapping("/addcontact")
    public String addContact(@ModelAttribute(name = "contactModel") ContactModel contactModel,
                             Model model){
        LOGGER.info("METHOD: addContact()" + "PARAMS :" + contactModel.toString());
        if(null != contactService.addContact(contactModel)){
            model.addAttribute("result", 1);
        }else{
            model.addAttribute("result", 0);
        }
        return "redirect:/contacts/showcontacts";
    }

    @GetMapping("/showcontacts")
    public ModelAndView showContacts(){
        ModelAndView mav = new ModelAndView(ViewConstant.CONTACT_LIST);
        mav.addObject("contacts", contactService.listAll());
        mav.addObject("contact", new ContactModel());
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        mav.addObject("username", user.getUsername());
        return mav;
    }

    @GetMapping("/deletecontact")
    public String deleteContact(@RequestParam(name = "id") int id){
        //LOGGER.info("METHOD: deletecontact()" + "PARAMS :" + contactModel.toString());
        contactService.deleteContact(id);
        return "redirect:/contacts/showcontacts";
    }
}
