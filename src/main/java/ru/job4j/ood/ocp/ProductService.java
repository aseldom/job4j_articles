package ru.job4j.ood.ocp;

class ProductService {
    void calculateDiscount(String product) {
        /*
         Вычисление скидки в зависимости от типа продукта
         */
        if (product.equals("BOOK")) {
            int a = 0;
            /*
             Вычисление скидки для книги
             */
        } else if (product.equals("ELECTRONICS")) {
            int b = 0;
            /*
             Вычисление скидки для электроники
             */
        }
        /*
         Нарушение OCP: при добавлении нового типа продукта нужно менять этот метод
         */
    }
}
