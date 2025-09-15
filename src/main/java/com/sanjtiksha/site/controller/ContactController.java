package com.sanjtiksha.site.controller;

import com.sanjtiksha.site.entity.ContactMessage;
import com.sanjtiksha.site.repository.ContactMessageRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactController {

    private final ContactMessageRepository contactMessageRepository;

    public ContactController(ContactMessageRepository contactMessageRepository) {
        this.contactMessageRepository = contactMessageRepository;
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @PostMapping("/contact")
    public String saveMessage(@RequestParam String name,
                              @RequestParam String email,
                              @RequestParam String subject,
                              @RequestParam String message,
                              Model model) {
        ContactMessage contact = ContactMessage.builder()
                .name(name)
                .email(email)
                .subject(subject)  // ✅ save subject
                .message(message)
                .build();
        contactMessageRepository.save(contact);

        model.addAttribute("success", "Thank you! We will get back to you soon.");
        return "contact";
    }
}
