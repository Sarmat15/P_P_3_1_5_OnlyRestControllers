package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.services.RoleService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }
    @GetMapping()
    public String getAllUsersForm(Model model) {
        model.addAttribute("user", userService.getAllUsers());
        return "admin/admin";
    }

    @GetMapping("/{id}")
    public String getShowForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "admin/show";
    }

    @GetMapping("/new")
    public String getUserCreationForm(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("roles", roleService.getAllRoles());
        return "admin/new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/new";
        } else {
            userService.createNewUser(user);
            return "redirect:/admin";
        }
    }

    @GetMapping("/edit/{id}")
    public String getUserEditionForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        model.addAttribute("roles", roleService.getAllRoles());
        return "admin/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/edit";
        } else {
            userService.updateUser(user);
            return "redirect:/admin";
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}
