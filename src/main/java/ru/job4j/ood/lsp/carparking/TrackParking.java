package ru.job4j.ood.lsp.carparking;

import java.util.ArrayList;
import java.util.List;

public class TrackParking implements Parking {

    private final List<Car> storage;

    public TrackParking(int number) {
        storage = new ArrayList<>(number);
    }

    @Override
    public boolean park(Car car) {
        return false;
    }

    @Override
    public boolean remove(Car car) {
        return false;
    }
}
