package ru.job4j.ood.ocp;

class OrderProcessor {
    void processOrder(String order) {
        if (order.equals("international")) {
            int a = 0;
            /*
            Дополнительная обработка для международных заказов
             */
        }
        /*
        Нарушение OCP: добавление новой логики через условные проверки
         */
    }
}