package ru.job4j.ood.lsp.carparking;

public class PassengerCar extends AbstractCar {

    public PassengerCar(int size, String number) {
        super(size, number);
        setSimpleParkingPlace(true);
    }

    @Override
    public void setTypeParkingPlace(boolean simpleParkingPlace) {
        super.setTypeParkingPlace(simpleParkingPlace);
    }

    @Override
    public boolean park(Parking parking) {
        boolean res = false;
        int freeCarSpaces = parking.getFreeCarSpaces();
        if (freeCarSpaces >= 1) {
            this.setTypeParkingPlace(true);
            res = parking.addCar(this);
            freeCarSpaces--;
            parking.setFreeCarSpaces(freeCarSpaces);
        }
        if (res) {
            this.setParking(parking);
        }
        return res;
    }

    @Override
    public boolean remove() {
        boolean res = getParking().getAllCars().remove(this);
        if (res) {
            getParking().setFreeCarSpaces(getParking().getFreeCarSpaces() + 1);
        }
        return res;
    }
}
