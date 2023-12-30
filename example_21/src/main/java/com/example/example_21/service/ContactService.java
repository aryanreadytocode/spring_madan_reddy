package com.example.example_21.service;

import com.example.example_21.model.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private static final Logger log = LoggerFactory.getLogger(ContactService.class);
    /*
    * Save contact Details into Ddb
    * @Param contact
    * @return boolean
    * */
    public boolean saveMessageDetails(Contact contact) {
        boolean isSaved = true;
        // Todo - Need to persist the data into the DB table
        log.info(contact.toString());
        return isSaved;
    }
}
