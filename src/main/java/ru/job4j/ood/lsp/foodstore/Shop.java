package ru.job4j.ood.lsp.foodstore;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Shop extends AbstractStore {

    private final List<Food> foods = new ArrayList<>();
    private final Predicate<Integer> predicate1 = x -> x >= 25 && x <= 75;
    private final Predicate<Integer> predicate2 = x -> x > 0 && x < 25;

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
        if (predicate1.test(freshness)) {
            res = add(food);
        } else if (predicate2.test(freshness)) {
            food.setPrice(food.getPrice() * (1 - food.getDiscount() / 100));
            res = add(food);
        }
        return res;
    }


}
