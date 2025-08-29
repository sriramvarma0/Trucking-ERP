package com.trucking.erp.controller;

import com.trucking.erp.model.Truck;
import com.trucking.erp.repository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private TruckRepository truckRepository;

    // Login page
    @GetMapping("/login")
    public String loginPage() {
        return "login"; // templates/login.html
    }

    // Dashboard page
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<Truck> trucks = truckRepository.findAll();
        model.addAttribute("trucks", trucks);
        return "dashboard"; // templates/dashboard.html
    }

    // Show trucks page
    @GetMapping("/trucks")
    public String trucksPage(Model model) {
        List<Truck> trucks = truckRepository.findAll();
        model.addAttribute("trucks", trucks);
        return "trucks"; // templates/trucks.html
    }

    // Add truck
    @PostMapping("/trucks")
    public String addTruck(@ModelAttribute Truck truck) {
        truckRepository.save(truck);
        return "redirect:/admin/trucks";
    }

    // Delete truck
    @GetMapping("/trucks/delete/{id}")
    public String deleteTruck(@PathVariable Long id) {
        truckRepository.deleteById(id);
        return "redirect:/admin/trucks";
    }
}
