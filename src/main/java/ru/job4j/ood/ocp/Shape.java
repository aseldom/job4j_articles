package ru.job4j.ood.ocp;

interface Shape {
    double area();
    /*
     Нарушение OCP: добавление нового метода потребует изменения всех реализующих интерфейс классов
     */
}