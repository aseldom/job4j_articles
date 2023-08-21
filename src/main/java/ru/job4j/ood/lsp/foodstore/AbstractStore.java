package ru.job4j.ood.lsp.foodstore;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public abstract class AbstractStore implements Store<Food> {

    public int fresh(Food food) {
        long timeDelta = food.getCreateDate().until(food.getExpireDate(), ChronoUnit.SECONDS);
        long timeLeft = LocalDateTime.now().until(food.getExpireDate(), ChronoUnit.SECONDS);
        return (int) (100 * timeLeft / timeDelta);
    }
}
