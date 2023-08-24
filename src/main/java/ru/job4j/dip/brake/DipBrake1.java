package ru.job4j.dip.brake;

/*
Нарушение DIP заключается в том, что в классе находится хранилище данных.
 */

import java.util.HashMap;
import java.util.Map;

public class DipBrake1 {

    Map<String, String> store = new HashMap<>();

    int id;
    String name;

    public DipBrake1(int id, String name) {
        this.id = id;
        this.name = name;
    }
}



