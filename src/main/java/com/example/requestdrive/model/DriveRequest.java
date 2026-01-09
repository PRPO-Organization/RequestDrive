package com.example.requestdrive.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class DriveRequest {

    @Id
    @GeneratedValue
    private int requestId;

    private int passengerId;
    private Integer driverId;

    private double pickupLat;
    private double pickupLng;
    private double dropoffLat;
    private double dropoffLng;

    @Enumerated(EnumType.STRING)
    private RequestStatus status;

    private Instant createdAt;

    public int getRequestId() { return requestId; }
    public int getPassengerId() { return passengerId; }
    public void setPassengerId(int passengerId) { this.passengerId = passengerId; }
    public void setDriverId(Integer driverId) { this.driverId = driverId; }
    public void setPickupLat(double pickupLat) { this.pickupLat = pickupLat; }
    public void setPickupLng(double pickupLng) { this.pickupLng = pickupLng; }
    public void setDropoffLat(double dropoffLat) { this.dropoffLat = dropoffLat; }
    public void setDropoffLng(double dropoffLng) { this.dropoffLng = dropoffLng; }
    public void setStatus(RequestStatus status) { this.status = status; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }

    public Integer getDriverId() { return driverId; }
    public double getPickupLat() { return pickupLat; }
    public double getPickupLng() { return pickupLng; }
    public double getDropoffLat() { return dropoffLat; }
    public double getDropoffLng() { return dropoffLng; }
    public RequestStatus getStatus() { return status; }
    public Instant getCreatedAt() { return createdAt; }

}
