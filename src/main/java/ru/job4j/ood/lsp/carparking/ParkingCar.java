package ru.job4j.ood.lsp.carparking;

import java.util.ArrayList;
import java.util.List;

public class ParkingCar implements Parking {

    private final List<Car> allCars = new ArrayList<>();
    private int freeCarSpaces;
    private int freeTrackSpaces;

    public ParkingCar(int carSpaces, int trackSpaces) {
        this.freeCarSpaces = carSpaces;
        this.freeTrackSpaces = trackSpaces;
    }

    @Override
    public List<Car> getAllCars() {
        return allCars;
    }

    public int getFreeCarSpaces() {
        return freeCarSpaces;
    }

    public int getFreeTruckSpaces() {
        return freeTrackSpaces;
    }

    public void setFreeCarSpaces(int freeCarSpaces) {
        this.freeCarSpaces = freeCarSpaces;
    }

    public void setFreeTruckSpaces(int freeTrackSpaces) {
        this.freeTrackSpaces = freeTrackSpaces;
    }

    @Override
    public boolean addCar(Car car) {
        return allCars.add(car);
    }
}
