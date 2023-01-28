package com.spring.firstsecurity.controllers;

import com.spring.firstsecurity.config.util.PersonValidation;
import com.spring.firstsecurity.model.Person;
import com.spring.firstsecurity.services.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
    private final PersonValidation personValidation;
    private final RegistrationService registrationService;

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("person") Person person) {
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("person") @Valid Person person,
                               BindingResult bindingResult) {
        personValidation.validate(person, bindingResult);

        if (bindingResult.hasErrors())
            return "/auth/registration";

            registrationService.register(person);
        return "redirect:/auth/login";
    }
}
