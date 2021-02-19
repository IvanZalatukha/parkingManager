package com.example.parkingManager.service;

import com.example.parkingManager.dao.ParkingDao;
import com.example.parkingManager.model.Parking;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ParkingServiceImpl implements ParkingService {
    private ParkingDao parkingDao;

    public void setParkingDao(ParkingDao parkingDao) {
        this.parkingDao = parkingDao;
    }

    @Override
    @Transactional
    public void addParking(Parking parking) {
        this.parkingDao.addParking(parking);
    }

    @Override
    @Transactional
    public void updateParking(Parking parking) {
        this.parkingDao.updateParking(parking);
    }

    @Override
    @Transactional
    public void removeParking(int id) {
        this.parkingDao.removeParking(id);
    }

    @Override
    @Transactional
    public Parking getParkingById(int id) {
        return this.parkingDao.getParkingById(id);
    }

    @Override
    @Transactional
    public List<Parking> getAllParkings() {
        return this.parkingDao.getAllParkings();
    }
}
