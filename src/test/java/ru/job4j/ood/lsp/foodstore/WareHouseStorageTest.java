package ru.job4j.ood.lsp.foodstore;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;


public class WareHouseStorageTest {

    @Test
    public void whenFreshnessMore75PercentThenInWareHouse() {
        Store<Food> warehouse = new Warehouse();
        Food food = new Food("Cheese", LocalDateTime.now().plusDays(100), LocalDateTime.now().minusDays(30), 100d, 10d);
        warehouse.check(food);
        assertThat(warehouse.getFoods().get(0)).isEqualTo(food);
    }

    @Test
    public void whenFreshnessLess75PercentThenInWareHouse() {
        Store<Food> warehouse = new Warehouse();
        Food food = new Food("Cheese", LocalDateTime.now().plusDays(10), LocalDateTime.now().minusDays(30), 100d, 10d);
        warehouse.check(food);
        assertThat(warehouse.getFoods().size()).isEqualTo(0);
    }

}