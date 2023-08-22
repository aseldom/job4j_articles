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

}
