package com.spring.firstsecurity.securities;

import com.spring.firstsecurity.model.Person;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class PersonDetails implements UserDetails {


    private final Person person;


    public PersonDetails(Person person) {
        this.person = person;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return Collections.singletonList(new SimpleGrantedAuthority(person.getRole()));
    }

    @Override
    public String getPassword() {
        return this.person.getPassword();
    }

    @Override
    public String getUsername() {
        return this.person.getUsername();
    }

    @Override
//    this is account really
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
//    not Locked(karaTizme)
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
//    password is really or right
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
//    this is account work
    public boolean isEnabled() {
        return true;
    }

    //   authentication users
    public Person getPerson() {
        return this.person;
    }
}
