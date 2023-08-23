package ru.job4j.ood.isp.violation;


/**
 * В данном коде продемонстрировано нарушение принципа разделения интерфейсов.
 * Интерфейс Machine реализуют два класса Car и Truck.
 * Нарушение заключается в том, что к классу Car не применимы 2 метода: liftLoadArea() и lowerLoadArea(),
 * в них придется делать "заглушки".
 * Это является нарушением принципа разделения интерфейсов.
 *
 * Данное нарушение может быть исправлено путем разбиения интерфейса Machine на 2 или более интерфейсов.
 * Например:
 * interface WorkCargoArea { liftLoadArea(); lowerLoadArea();}
 * interface MachineArea { start(); stop();}
 *
 * Тогда классы будут выглядеть так:
 * class Truck implements MachineArea, WorkCargoArea {}
 * class Car implements MachineArea {}
 *
 */

/*
interface Machine {
    void start();
    void stop();
    void liftLoadArea();
    void lowerLoadArea();
}

class Truck implements Machine {
    public void start() {
         запустить машину
    }

    public void stop() {
         остановить машину
    }


    public void liftLoadArea() {
         поднять кузов
    }

    public void lowerLoadArea() {
         опустить кузов
    }
}

class Car implements Machine {
    public void start() {
         запустить машину
    }

    public void stop() {
         остановить машину
    }

    public void liftLoadArea() {
         не применимо для легковой машины
    }

    public void lowerLoadArea() {
         не применимо для легковой машины
    }
}
 */


