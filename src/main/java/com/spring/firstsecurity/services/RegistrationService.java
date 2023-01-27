package com.spring.firstsecurity.services;

import com.spring.firstsecurity.model.Person;
import com.spring.firstsecurity.repositories.PeopleRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final PasswordEncoder passwordEncoder;
    private final PeopleRepository peopleRepository;

    @Transactional
    public void register(Person person) {
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        person.setRole("ROLE_USER");
        peopleRepository.save(person);
    }
}
