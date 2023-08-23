package ru.job4j.ood.lsp.carparking;

public interface Car {

    int getSize();

    boolean getTypeParkingPlace();

    void setTypeParkingPlace(boolean simpleParkingPlace);

    boolean park(Parking parking);

    boolean remove();

    Parking getParking();

    void setParking(Parking parking);

}