package ru.job4j.ood.lsp.foodstore;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Trash extends AbstractStore {

    private final List<Food> foods = new ArrayList<>();
    private final Predicate<Integer> predicate = x -> x <= 0;

    @Override
    public boolean add(Food food) {
        return foods.add(food);
    }

    @Override
    public List<Food> getFoods() {
        return foods;
    }

    @Override
    public boolean check(Food food) {
        boolean res = false;
        int freshness = fresh(food);
        if (predicate.test(freshness)) {
            add(food);
            res = true;
        }
        return res;
    }
}
