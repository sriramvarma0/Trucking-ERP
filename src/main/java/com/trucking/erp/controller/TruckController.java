package com.trucking.erp.controller;

import com.trucking.erp.model.Truck;
import com.trucking.erp.repository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/trucks")
public class TruckController {

    @Autowired
    private TruckRepository truckRepository;

    // ✅ Get all trucks
    @GetMapping
    public List<Truck> getAllTrucks() {
        return truckRepository.findAll();
    }

    // ✅ Get truck by ID
    @GetMapping("/{id}")
    public Optional<Truck> getTruckById(@PathVariable Long id) {
        return truckRepository.findById(id);
    }

    // ✅ Add new truck
    @PostMapping
    public Truck createTruck(@RequestBody Truck truck) {
        return truckRepository.save(truck);
    }

    // ✅ Update truck
    @PutMapping("/{id}")
    public Truck updateTruck(@PathVariable Long id, @RequestBody Truck updatedTruck) {
        return truckRepository.findById(id)
                .map(truck -> {
                    truck.setName(updatedTruck.getName());
                    truck.setRegistrationNumber(updatedTruck.getRegistrationNumber());
                    truck.setCapacity(updatedTruck.getCapacity());
                    return truckRepository.save(truck);
                })
                .orElseThrow(() -> new RuntimeException("Truck not found with id " + id));
    }

    // ✅ Delete truck
    @DeleteMapping("/{id}")
    public String deleteTruck(@PathVariable Long id) {
        truckRepository.deleteById(id);
        return "Truck deleted with id " + id;
    }
}
