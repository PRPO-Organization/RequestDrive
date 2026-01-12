package com.example.requestdrive.service;

import com.example.requestdrive.model.*;
import com.example.requestdrive.repository.*;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.*;

@Service
public class DriveRequestService {

    private final DriveRequestRepository repository;

    public DriveRequestService(DriveRequestRepository repository) {
        this.repository = repository;
    }

    public DriveRequest create(int passengerId, int driverId, double pLat, double pLng, double dLat, double dLng) {
        DriveRequest r = new DriveRequest();
        r.setPassengerId(passengerId);
        r.setDriverId(driverId);
        r.setPickupLat(pLat);
        r.setPickupLng(pLng);
        r.setDropoffLat(dLat);
        r.setDropoffLng(dLng);
        r.setStatus(RequestStatus.NEW);
        r.setCreatedAt(Instant.now());
        return repository.save(r);
    }

    public Optional<DriveRequest> get(int id) {
        return repository.findById(id);
    }

    public List<DriveRequest> getByPassenger(int passengerId) {
        return repository.findByPassengerId(passengerId);
    }

    public List<DriveRequest> getByDriver(int driverId) {
        return repository.findByDriverId(driverId);
    }

    public List<DriveRequest> getByStatus(RequestStatus status) {
        return repository.findByStatus(status);
    }

    public DriveRequest updateStatus(int requestId, RequestStatus status) {
    DriveRequest r = repository.findById(requestId)
            .orElseThrow(() -> new RuntimeException("Request not found"));
    r.setStatus(status);
    return repository.save(r);
    }
}
