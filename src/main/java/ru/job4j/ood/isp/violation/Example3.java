package ru.job4j.ood.isp.violation;


/**
 * В данном коде продемонстрировано нарушение принципа разделения интерфейсов.
 * Интерфейс Ship реализуют два класса MotorBoat и Brigantine.
 * Нарушение заключается в том, что к классу MotorBoat не применимы 2 метода: raiseSails() и lowerSails(),
 * а к классу Brigantine не применим метод startEngine(),  в них придется делать "заглушки"
 * Это является нарушением принципа разделения интерфейсов.
 *
 * Данное нарушение может быть исправлено путем разбиения интерфейса Ship на 2 или более интерфейсов.
 * Например:
 * interface SailingShip {raiseSails(); lowerSails();}
 * interface Engine {startEngine();}
 * interface Ship {castOffLines(); mooring();}
 *
 * Тогда классы будут выглядеть так:
 * class MotorBoat implements Ship, Engine {}
 * class Brigantine implements Ship, SailingShip {}
 *
 */


/*
 interface Ship {
    void castOffLines();
    void mooring();
    void raiseSails();
    void lowerSails();
    void startEngine();
}

class MotorBoat implements Ship {
    void castOffLines() {
        отдать швартовы
     }

    void mooring() {
        пришвартоваться
    }
    void raiseSails() {
        поднять паруса (неприменимо)
    }
    void lowerSails() {
        спустить паруса (неприменимо)
    }
    void startEngine() {
        запустить двигатель
    }
}

class Brigantine implements Ship {
    void castOffLines() {
        отдать швартовы
     }
    void mooring() {
        пришвартоваться
    }
    void raiseSails() {
        поднять паруса
    }
    void lowerSails() {
        спустить паруса
    }
    void startEngine() {
        запустить двигатель (неприменимо)
    }
}
       
 */


