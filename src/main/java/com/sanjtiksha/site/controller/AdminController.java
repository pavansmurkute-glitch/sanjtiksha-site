package com.sanjtiksha.site.controller;

import com.sanjtiksha.site.entity.Product;
import com.sanjtiksha.site.entity.ServiceEntity;
import com.sanjtiksha.site.entity.TeamMember;
import com.sanjtiksha.site.repository.ContactMessageRepository;
import com.sanjtiksha.site.repository.ProductRepository;
import com.sanjtiksha.site.repository.ServiceEntityRepository;
import com.sanjtiksha.site.repository.TeamMemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final ServiceEntityRepository  serviceRepository;
    private final ProductRepository productRepository;
    private final TeamMemberRepository  teamRepository;
    private final ContactMessageRepository contactMessageRepository;

    public AdminController(ServiceEntityRepository serviceRepository,
                           ProductRepository productRepository,
                           TeamMemberRepository teamRepository,
                           ContactMessageRepository contactMessageRepository) {
        this.serviceRepository = serviceRepository;
        this.productRepository = productRepository;
        this.teamRepository = teamRepository;
        this.contactMessageRepository = contactMessageRepository;
    }

    @GetMapping("/login")
    public String login() {
        return "admin/login";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("services", serviceRepository.findAll());
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("team", teamRepository.findAll());
        model.addAttribute("messages", contactMessageRepository.findAll());
        return "admin/dashboard";
    }

    // --- Services CRUD ---
    @PostMapping("/services/add")
    public String addService(@RequestParam String name, @RequestParam String description) {
        serviceRepository.save(ServiceEntity.builder().name(name).description(description).build());
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/services/delete/{id}")
    public String deleteService(@PathVariable Long id) {
        serviceRepository.deleteById(id);
        return "redirect:/admin/dashboard";
    }

    // --- Products CRUD ---
    @PostMapping("/products/add")
    public String addProduct(@RequestParam String name,
                             @RequestParam String description,
                             @RequestParam Double price,
                             @RequestParam(required = false) String amazonLink,
                             @RequestParam(required = false) String flipkartLink,
                             @RequestParam(required = false) String meeshoLink) {
        productRepository.save(Product.builder()
                .name(name)
                .description(description)
                .price(price)
                .amazonLink(amazonLink)
                .flipkartLink(flipkartLink)
                .meeshoLink(meeshoLink)
                .build());
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return "redirect:/admin/dashboard";
    }

    // --- Team CRUD ---
    @PostMapping("/team/add")
    public String addTeam(@RequestParam String title,
                          @RequestParam String description,
                          @RequestParam(required = false) String photoUrl) {
        teamRepository.save(TeamMember.builder().title(title).description(description).photoUrl(photoUrl).build());
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/team/delete/{id}")
    public String deleteTeam(@PathVariable Long id) {
        teamRepository.deleteById(id);
        return "redirect:/admin/dashboard";
    }
}
