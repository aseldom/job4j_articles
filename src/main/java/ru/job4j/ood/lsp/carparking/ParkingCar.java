package ru.job4j.ood.lsp.carparking;

import java.util.ArrayList;
import java.util.List;

public class ParkingCar implements Parking {

    List<Car> allCars = new ArrayList<>();
    private int freeCarSpaces;
    private int freeTrackSpaces;

    public ParkingCar(int carSpaces, int trackSpaces) {
        this.freeCarSpaces = carSpaces;
        this.freeTrackSpaces = trackSpaces;
    }

    @Override
    public boolean park(Car car) {
        boolean res = false;
        int size = car.getSize();
        if (size > 1) {
            if (freeTrackSpaces > 0) {
                freeTrackSpaces--;
                car.setTypeParkingPlace(false);
                allCars.add(car);
                res = true;
            } else if (size <= freeCarSpaces) {
                freeCarSpaces -= size;
                car.setTypeParkingPlace(true);
                allCars.add(car);
                res = true;
            }
        } else if (size <= freeCarSpaces) {
            freeCarSpaces -= size;
            allCars.add(car);
            res = true;
        }
        if (res) {
            car.setParking(this);
        }
        return res;
    }

    @Override
    public boolean remove(String number) {
        boolean res = false;
        Car car = findByNumber(number);
        if (car != null) {
            res = allCars.remove(car);
            if (car.getTypeParkingPlace()) {
                freeCarSpaces += car.getSize();
            } else {
                freeTrackSpaces++;
            }
        }
        return res;
    }

    private Car findByNumber(String number) {
        Car res = null;
        for (Car car : allCars) {
            if (car.getNumber().equals(number)) {
                res = car;
                break;
            }
        }
        return res;
    }

    @Override
    public List<Car> getAllCars() {
        return allCars;
    }

    public int getFreeCarSpaces() {
        return freeCarSpaces;
    }

    public int getFreeTrackSpaces() {
        return freeTrackSpaces;
    }
}
