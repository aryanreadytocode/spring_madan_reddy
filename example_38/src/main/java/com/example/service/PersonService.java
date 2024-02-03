package com.example.service;

import com.example.constants.AryanSchoolConstant;
import com.example.model.Person;
import com.example.model.Roles;
import com.example.repository.PersonRepository;
import com.example.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RolesRepository rolesRepository;

    public boolean createNewPerson(Person person) {
        boolean isSaved = false;
        Roles role = rolesRepository.getByRoleName(AryanSchoolConstant.STUDENT_ROLE);
        person.setRoles(role);
        person = personRepository.save(person);
        if (null != person && person.getPersonId() > 0) {
            isSaved = true;
        }
        return isSaved;
    }
}