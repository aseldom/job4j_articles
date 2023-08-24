package ru.job4j.dip.brake;

/*
Нарушение DIP заключается в том, что в классе осуществляется ввод данных.
 */

import java.util.Scanner;

public class DipBrake3 {
    int id;
    String name;

    public DipBrake3(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        name = sc.nextLine();
    }
}

