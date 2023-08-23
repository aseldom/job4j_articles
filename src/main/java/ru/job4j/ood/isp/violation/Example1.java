package ru.job4j.ood.isp.violation;

/**
 * В данном коде продемонстрировано нарушение принципа разделения интерфейсов.
 * Интерфейс Performer реализуют два класса Worker и Robot.
 * Нарушение заключается в том, что к классу Robot не применимы 2 метода: eat() и sleep(),
 * в них придется делать "заглушки"
 * Это является нарушением принципа разделения интерфейсов.
 *
 * Данное нарушение может быть исправлено путем разбиения интерфейса Performer на 2 или более интерфейсов.
 * Например:
 * interface Human {eat(); sleep();}
 * interface Working {work();}
 * interface Fixing {repair();}
 *
 * Тогда классы будут выглядеть так:
 * class Worker implements Human, Working {}
 * class Robot implements Working, Fixing {}
 *
 */

/*
public interface Performer {
    void work();
    void repair();
    void eat();
    void sleep();
}

class Human implements Worker {
    public void work() {
         работать
    }

    public void repair() {
         не применимо
    }

    public void eat() {
         есть
    }

    public void sleep() {
         спать
    }
}

class Robot implements Robot {
    public void work() {
         работать
    }

    public void repair() {
         ремонт
    }

    public void eat() {
         не применимо
    }

    public void sleep() {
         не применимо
    }
}
 */


