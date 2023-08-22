package ru.job4j.ood.lsp.carparking;

public class Track extends AbstractCar {

    public Track(int size, String number) {
        super(size, number);
    }

    @Override
    public void setTypeParkingPlace(boolean simpleParkingPlace) {
        super.setTypeParkingPlace(simpleParkingPlace);
    }
}
