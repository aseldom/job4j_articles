package ru.job4j.dip.brake;

/*
Нарушение DIP заключается в том, что в классе осуществляется вывод данных.
 */

public class DipBrake2 {

    int id;
    String name;

    public DipBrake2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void print() {
        System.out.println(name);
    }
}
