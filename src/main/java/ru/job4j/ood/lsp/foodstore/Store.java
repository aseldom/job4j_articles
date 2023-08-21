package ru.job4j.ood.lsp.foodstore;

import java.util.List;

public interface Store<T> {

    boolean add(Food food);

    boolean check(Food food);

    List<T> getFoods();

}
