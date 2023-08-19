package ru.job4j;

public class ViolationLsp {

    /*
    Нарушение LSP - методы подтипов не могут объявлять новые исключения.
     */
    class Vehicle {
        void startEngine() {
            System.out.println("Starting the engine");
        }
    }
    class Car extends Vehicle {
        @Override
        void startEngine() {
            throw new UnsupportedOperationException("Bikes don't have engines");
        }
    }

    /*
    Нарушение LSP - аргументы методов должны быть контравариантны.
     */
    class Bike {
        void run(Long speed) {
            System.out.println("Starting the engine");
        }
    }
    class MiniBike extends Bike {
        void run(Integer speed) {
            System.out.println("Starting the car's engine");
        }
    }

    /*
    Нарушение LSP - предусловия не могут быть усилены в подклассе
     */

    class Container {
        void getItems(Integer a) {
            if (a > 10) {
                System.out.println("a > 10");
            }
        }
    }
    class SpecialContainer extends Container {
        @Override
        void getItems(Integer a) {
            if (a > 20) {
                System.out.println("a > 20");
            }
        }
    }
}
