package ru.job4j.ood.lsp.carparking;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ParkingCarTest {

    @Test
    public void parkingPassengerCarTest() {
        int carSpace = 2;
        int trackSpace = 3;
        Parking parking1 = new ParkingCar(carSpace, trackSpace);
        Car pas1 = new PassengerCar(1, "a1");
        Car pas2 = new PassengerCar(1, "a2");
        Car pas3 = new PassengerCar(1, "a3");
        assertThat(pas1.park(parking1)).isTrue();
        assertThat(pas2.park(parking1)).isTrue();
        assertThat(pas3.park(parking1)).isFalse();
        assertThat(parking1.getAllCars().contains(pas1)).isTrue();
        assertThat(parking1.getAllCars().contains(pas2)).isTrue();
        assertThat(parking1.getAllCars().contains(pas3)).isFalse();
        assertThat(parking1.getFreeTruckSpaces()).isEqualTo(trackSpace);

        assertThat(pas1.remove()).isTrue();
        assertThat(pas2.remove()).isTrue();
        assertThat(parking1.getFreeCarSpaces()).isEqualTo(carSpace);
        assertThat(parking1.getFreeTruckSpaces()).isEqualTo(trackSpace);
    }

    @Test
    public void parkingTrackTest() {
        Parking parking1 = new ParkingCar(3, 2);
        Car track1 = new Truck(2, "t1");
        Car track2 = new Truck(3, "t2");
        Car track3 = new Truck(2, "t3");
        Car track4 = new Truck(2, "t4");
        assertThat(track1.park(parking1)).isTrue();
        assertThat(track2.park(parking1)).isTrue();
        assertThat(track3.park(parking1)).isTrue();
        assertThat(track4.park(parking1)).isFalse();
        assertThat(parking1.getAllCars().contains(track1)).isTrue();
        assertThat(parking1.getAllCars().contains(track2)).isTrue();
        assertThat(parking1.getAllCars().contains(track3)).isTrue();
        assertThat(parking1.getAllCars().contains(track4)).isFalse();
        assertThat(parking1.getFreeCarSpaces()).isEqualTo(1);
        assertThat(parking1.getFreeTruckSpaces()).isEqualTo(0);

        assertThat(track1.remove()).isTrue();
        assertThat(parking1.getFreeCarSpaces()).isEqualTo(1);
        assertThat(parking1.getFreeTruckSpaces()).isEqualTo(1);

        assertThat(track3.remove()).isTrue();
        assertThat(parking1.getFreeCarSpaces()).isEqualTo(3);
        assertThat(parking1.getFreeTruckSpaces()).isEqualTo(1);
        assertThat(parking1.getAllCars().contains(track2)).isTrue();

        assertThat(track2.remove()).isTrue();
        assertThat(parking1.getFreeCarSpaces()).isEqualTo(3);
        assertThat(parking1.getFreeTruckSpaces()).isEqualTo(2);
        assertThat(parking1.getAllCars()).isEmpty();
    }
}