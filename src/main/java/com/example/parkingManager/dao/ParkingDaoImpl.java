package com.example.parkingManager.dao;

import com.example.parkingManager.model.Parking;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ParkingDaoImpl implements ParkingDao {
    private static final Logger logger = LoggerFactory.getLogger(ParkingDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addParking(Parking parking) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(parking);
        logger.info("The parking successfully saved. Parking details:" + parking);
    }

    @Override
    public void updateParking(Parking parking) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(parking);
        logger.info("The parking successfully updated. Parking updated details:" + parking);
    }

    @Override
    public void removeParking(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Parking parking = session.load(Parking.class, id);
        if (parking != null) {
            session.delete(parking);
        }
        logger.info("The parking successfully removed. Parking details:" + parking);


    }

    @Override
    public Parking getParkingById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Parking parking = session.load(Parking.class, id);
        logger.info("The parking successfully loaded. Parking details:" + parking);
        return parking;
    }

    @Override
    public List<Parking> getAllParkings() {
        Session session = this.sessionFactory.getCurrentSession();
//        List<Parking> list = session.createQuery("from parkings").list();
        return null;
    }
}
