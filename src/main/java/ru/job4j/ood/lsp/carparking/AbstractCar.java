package ru.job4j.ood.lsp.carparking;

import java.util.Objects;

public abstract class AbstractCar implements Car {

    Parking parking;
    boolean simpleParkingPlace;
    int size;
    String number;

    public AbstractCar(int size, String number) {
        this.size = size;
        this.number = number;
    }

    public boolean getTypeParkingPlace() {
        return simpleParkingPlace;
    }

    public void setTypeParkingPlace(boolean simpleParkingPlace) {
        this.simpleParkingPlace = simpleParkingPlace;
    }

    public int getSize() {
        return size;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public boolean park(Parking parking) {
        return parking.park(this);
    }

    @Override
    public boolean remove() {
        return parking.remove(this.getNumber());
    }

    @Override
    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    @Override
    public String toString() {
        return "AbstractCar{"
                + "parking=" + parking
                + ", simpleParkingPlace=" + simpleParkingPlace
                + ", size=" + size
                + ", number='" + number + '\''
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AbstractCar that = (AbstractCar) o;
        return simpleParkingPlace == that.simpleParkingPlace
                && size == that.size
                && Objects.equals(parking, that.parking)
                && Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parking, simpleParkingPlace, size, number);
    }
}
