package ru.job4j.ood.lsp.carparking;

import java.util.List;

public interface Parking {

    boolean park(Car car);

    boolean remove(String number);

    List<Car> getAllCars();

    int getFreeCarSpaces();

    int getFreeTrackSpaces();

}
