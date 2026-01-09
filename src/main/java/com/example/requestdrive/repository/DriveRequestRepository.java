package com.example.requestdrive.repository;

//import com.example.requestdrive.model.*;
import com.example.requestdrive.model.DriveRequest;
import com.example.requestdrive.model.RequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface DriveRequestRepository extends JpaRepository<DriveRequest, Integer> {
    List<DriveRequest> findByPassengerId(int passengerId);
    List<DriveRequest> findByDriverId(Integer driverId);
    List<DriveRequest> findByStatus(RequestStatus status);
}
