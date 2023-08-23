package ru.job4j.ood.lsp.carparking;

public class Truck extends AbstractCar {

    public Truck(int size, String number) {
        super(size, number);
    }

    @Override
    public void setTypeParkingPlace(boolean simpleParkingPlace) {
        super.setTypeParkingPlace(simpleParkingPlace);
    }

    @Override
    public boolean park(Parking parking) {
        boolean res = false;
        int size = this.getSize();
        int freeTruckSpaces = parking.getFreeTruckSpaces();
        int freeCarSpaces = parking.getFreeCarSpaces();
        if (freeTruckSpaces > 0) {
            this.setTypeParkingPlace(false);
            freeTruckSpaces--;
            res = parking.addCar(this);
            parking.setFreeTruckSpaces(freeTruckSpaces);
        } else if (size <= freeCarSpaces) {
            this.setTypeParkingPlace(true);
            freeCarSpaces -= size;
            parking.setFreeCarSpaces(freeCarSpaces);
            res = parking.addCar(this);
        }
        if (res) {
            this.setParking(parking);
        }

        return res;
    }

    @Override
    public boolean remove() {
        boolean res = getParking().getAllCars().remove(this);
        if (this.getTypeParkingPlace()) {
            getParking().setFreeCarSpaces(getParking().getFreeCarSpaces() + this.getSize());
        } else {
            getParking().setFreeTruckSpaces(getParking().getFreeTruckSpaces() + 1);
        }
        return res;
    }
}
