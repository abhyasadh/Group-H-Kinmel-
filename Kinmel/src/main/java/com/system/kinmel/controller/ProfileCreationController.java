package com.system.kinmel.controller;

import com.system.kinmel.pojo.ProfileCreationPojo;
import com.system.kinmel.services.ProfileCreationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/profile")

public class ProfileCreationController {
    private final ProfileCreationService profileCreationService;

    @GetMapping("/profileCreation")
    public String createUser(Model model){
        model.addAttribute("profile", new ProfileCreationPojo());
        return "ProfileCreation";
    }
    @PostMapping("/save")
    public String saveUser(@Valid ProfileCreationPojo userPojo){
        profileCreationService.save(userPojo);
        return "redirect:";
    }
}
