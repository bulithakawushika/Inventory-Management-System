package com.uok.oop.ims.controller;

import com.uok.oop.ims.dto.UserRegistrationDto;
import com.uok.oop.ims.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
    private UserService userService;

    // Inject the UserService into the controller via constructor injection.
    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    // Create a model attribute for UserRegistrationDto to be used in the registration form.
    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto(){
        return new UserRegistrationDto();
    }

    // Handle the GET request to display the registration form.
    @GetMapping
    public String showRegistrationForm()
    {
        // Return the "registration" view to display the registration form.
        return "registration";
    }

    // Handle the POST request to register a user account.
    @PostMapping
    public String registerUserAccount(@ModelAttribute("user")UserRegistrationDto registrationDto) {
        // Call the UserService's save method to register the user.
        userService.save(registrationDto);
        // Redirect to the registration page with a success message.
        return "redirect:/registration?success";
    }
}
