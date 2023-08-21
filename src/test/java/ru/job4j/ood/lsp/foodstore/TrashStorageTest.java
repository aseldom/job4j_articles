package ru.job4j.ood.lsp.foodstore;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;


public class TrashStorageTest {

    @Test
    public void whenFreshnessMore0PercentThenIsNotInTrash() {
        Store<Food> trash = new Trash();
        Food food = new Food("Cheese", LocalDateTime.now().plusDays(1), LocalDateTime.now().minusDays(30), 100d, 10d);
        trash.check(food);
        assertThat(trash.getFoods().size()).isEqualTo(0);
    }

    @Test
    public void whenFreshnessLess0PercentThenInWareHouse() {
        Store<Food> trash = new Trash();
        Food food = new Food("Cheese", LocalDateTime.now().minusDays(1), LocalDateTime.now().minusDays(30), 100d, 10d);
        trash.check(food);
        assertThat(trash.getFoods().get(0)).isEqualTo(food);
    }
}