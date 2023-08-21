package ru.job4j.ood.lsp.foodstore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ControlQualityTest {
    List<Store<Food>> stores;
    ControlQuality control;

    @BeforeEach
    void setUp() {
        stores =  List.of(new Shop(), new Warehouse(), new Trash());
        control = new ControlQuality(stores);
    }

    @Test
    public void whenFreshnessLess0PercentThenInTrash() {
        Food food = new Food("Cheese", LocalDateTime.now().minusDays(1), LocalDateTime.now().minusDays(30), 100d, 10d);
        Store<Food> store = control.distribute(food);
        String storage = "Trash";
        assertThat(storage).isEqualTo(store.getClass().getSimpleName());
        assertThat(store.getFoods().get(0)).isEqualTo(food);
    }

    @Test
    public void whenFreshnessMore0AndLess25PercentThenInShopWithDiscount() {
        Food food = new Food("Cheese", LocalDateTime.now().plusDays(1), LocalDateTime.now().minusDays(30), 100d, 10d);
        double expectDiscount = food.getPrice() * (1 - food.getDiscount() / 100);
        Store<Food> store = control.distribute(food);
        String storage = "Shop";
        assertThat(storage).isEqualTo(store.getClass().getSimpleName());
        assertThat(store.getFoods().get(0)).isEqualTo(food);
        assertThat(store.getFoods().get(0).getPrice()).isEqualTo(expectDiscount);
    }

    @Test
    public void whenFreshnessMore25AndLess75PercentThenInShopWithoutDiscount() {
        Food food = new Food("Cheese", LocalDateTime.now().plusDays(40), LocalDateTime.now().minusDays(30), 100d, 10d);
        double expect = food.getPrice();
        Store<Food> store = control.distribute(food);
        String storage = "Shop";
        assertThat(storage).isEqualTo(store.getClass().getSimpleName());
        assertThat(store.getFoods().get(0)).isEqualTo(food);
        assertThat(store.getFoods().get(0).getPrice()).isEqualTo(expect);
    }

    @Test
    public void whenFreshnessMore75PercentThenInWareHouse() {
        Food food = new Food("Cheese", LocalDateTime.now().plusDays(100), LocalDateTime.now().minusDays(30), 100d, 10d);
        Store<Food> store = control.distribute(food);
        String storage = "Warehouse";
        assertThat(storage).isEqualTo(store.getClass().getSimpleName());
        assertThat(store.getFoods().get(0)).isEqualTo(food);
    }

}