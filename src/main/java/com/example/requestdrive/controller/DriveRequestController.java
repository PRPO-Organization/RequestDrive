package com.example.requestdrive.controller;

import com.example.requestdrive.model.*;
import com.example.requestdrive.service.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/requests")
public class DriveRequestController {

    private final DriveRequestService service;

    public DriveRequestController(DriveRequestService service) {
        this.service = service;
    }

    @PostMapping
    public DriveRequest create(@RequestParam int passengerId,
                               @RequestParam int driverId,
                               @RequestParam double pickupLat,
                               @RequestParam double pickupLng,
                               @RequestParam double dropoffLat,
                               @RequestParam double dropoffLng) {
        return service.create(passengerId, driverId,pickupLat, pickupLng,
                              dropoffLat, dropoffLng);
    }

    @GetMapping("/{id}")
    public Optional<DriveRequest> get(@PathVariable int id) {
        return service.get(id);
    }

    // ========================
    // Get all requests by passenger
    // ========================
    @GetMapping("/passenger/{passengerId}")
    public List<DriveRequest> getByPassenger(@PathVariable int passengerId) {
        return service.getByPassenger(passengerId);
    }

    // ========================
    // Get all requests by driver
    // ========================
    @GetMapping("/driver/{driverId}")
    public List<DriveRequest> getByDriver(@PathVariable int driverId) {
        return service.getByDriver(driverId);
    }

    // ========================
    // Get all requests by status
    // ========================
    @GetMapping("/status/{status}")
    public List<DriveRequest> getByStatus(@PathVariable RequestStatus status) {
        return service.getByStatus(status);
    }

    @PatchMapping("/{id}/status")
    public DriveRequest updateStatus(@PathVariable int id, @RequestParam RequestStatus status) {
    return service.updateStatus(id, status);
    }
}
