package com.spring.firstsecurity.repositories;

import com.spring.firstsecurity.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<Person,Long> {

    Optional<Person> findByUsername(String username);

}
