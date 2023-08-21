package ru.job4j.ood.lsp.foodstore;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store<Food> {

    final List<Food> foods = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        return foods.add(food);
    }

    @Override
    public List<Food> getFoods() {
        return foods;
    }

    public int fresh(Food food) {
        long timeDelta = food.getCreateDate().until(food.getExpireDate(), ChronoUnit.SECONDS);
        long timeLeft = LocalDateTime.now().until(food.getExpireDate(), ChronoUnit.SECONDS);
        return (int) (100 * timeLeft / timeDelta);
    }
}
