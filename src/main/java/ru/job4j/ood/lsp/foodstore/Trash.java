package ru.job4j.ood.lsp.foodstore;

import java.util.function.Predicate;

public class Trash extends AbstractStore {

    private final Predicate<Integer> predicate = x -> x <= 0;

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
