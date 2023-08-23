package ru.job4j.ood.lsp.carparking;

import java.util.List;

public interface Parking {

    List<Car> getAllCars();

    int getFreeCarSpaces();

    void setFreeCarSpaces(int freeCarSpaces);

    int getFreeTruckSpaces();

    void setFreeTruckSpaces(int freeTrackSpaces);

    boolean addCar(Car car);

}
