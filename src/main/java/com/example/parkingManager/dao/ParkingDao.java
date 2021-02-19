package com.example.parkingManager.dao;

import com.example.parkingManager.model.Parking;

import java.util.List;

public interface ParkingDao {
    void addParking(Parking parking);

    void updateParking(Parking parking);

    void removeParking(int id);

    Parking getParkingById(int id);

    List<Parking> getAllParkings();
}
