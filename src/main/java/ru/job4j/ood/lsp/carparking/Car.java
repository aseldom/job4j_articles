package ru.job4j.ood.lsp.carparking;

public class Car {

    String name;
    int size;
    String number;

    public Car(String name, int size, String number) {
        this.name = name;
        this.size = size;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public String getNumber() {
        return number;
    }
}
