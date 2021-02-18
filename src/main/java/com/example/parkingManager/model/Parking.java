package com.example.parkingManager.model;
import javax.persistence.*;

@Entity
@Table(name = "parkings")
public class Parking {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "parking_name")
    private String name;

    @Column(name = "parking_places_total")
    private int placesTotal;

    @Column(name = "parking_coordinate_longitude")
    private double coordinateLongitude;

    @Column(name = "parking_coordinate_latitude")
    private double coordinateLatitude;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlacesTotal() {
        return placesTotal;
    }

    public void setPlacesTotal(int placesTotal) {
        this.placesTotal = placesTotal;
    }

    public double getCoordinateLongitude() {
        return coordinateLongitude;
    }

    public void setCoordinateLongitude(double coordinateLongitude) {
        this.coordinateLongitude = coordinateLongitude;
    }

    public double getCoordinateLatitude() {
        return coordinateLatitude;
    }

    public void setCoordinateLatitude(double coordinateLatitude) {
        this.coordinateLatitude = coordinateLatitude;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", placesTotal=" + placesTotal +
                ", coordinateLongitude=" + coordinateLongitude +
                ", coordinateLatitude=" + coordinateLatitude +
                '}';
    }
}
