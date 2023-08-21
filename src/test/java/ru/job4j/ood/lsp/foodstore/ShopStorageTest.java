package ru.job4j.ood.lsp.foodstore;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class ShopStorageTest {

    @Test
    public void whenFreshnessLess25PercentThenInShopAndWithDiscount() {
        Store<Food> shop = new Shop();
        Food food = new Food("Cheese", LocalDateTime.now().plusDays(1), LocalDateTime.now().minusDays(30), 100d, 10d);
        double expect = food.getPrice() * (1 - food.getDiscount() / 100);
        shop.check(food);
        assertThat(shop.getFoods().get(0).getPrice()).isEqualTo(expect);
    }

    @Test
    public void whenFreshnessMore25percentAndLess75PercentThenInShopAndWithoutDiscount() {
        Store<Food> shop = new Shop();
        Food food = new Food("Cheese", LocalDateTime.now().plusDays(50), LocalDateTime.now().minusDays(30), 100d, 10d);
        double expect = food.getPrice();
        shop.check(food);
        assertThat(shop.getFoods().get(0).getPrice()).isEqualTo(expect);
    }

    @Test
    public void whenFreshnessMore75PercentThenIsNotInShop() {
        Store<Food> shop = new Shop();
        Food food = new Food("Cheese", LocalDateTime.now().plusDays(100), LocalDateTime.now().minusDays(30), 100d, 10d);
        shop.check(food);
        assertThat(shop.getFoods().size()).isEqualTo(0);
    }

    @Test
    public void whenFreshnessLess0PercentThenIsNotInShop() {
        Store<Food> shop = new Shop();
        Food food = new Food("Cheese", LocalDateTime.now().minusDays(1), LocalDateTime.now().minusDays(30), 100d, 10d);
        shop.check(food);
        assertThat(shop.getFoods().size()).isEqualTo(0);
    }

}