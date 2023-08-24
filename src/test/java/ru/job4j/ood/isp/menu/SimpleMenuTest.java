package ru.job4j.ood.isp.menu;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class SimpleMenuTest {

    public static final ActionDelegate STUB_ACTION = System.out::println;

    @Test
    public void whenAddThenReturnSame() {
        Menu menu = new SimpleMenu();
        MenuPrinter menuPrinter = new MenuSimplePrint();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add(Menu.ROOT, "Покормить собаку", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", STUB_ACTION);
        menu.add("Купить продукты", "Купить молоко", STUB_ACTION);
        menu.add(Menu.ROOT, "Выйти на улицу", STUB_ACTION);
        menu.add("Выйти на улицу", "Погулять", STUB_ACTION);

        assertThat(new Menu.MenuItemInfo("Сходить в магазин",
                List.of("Купить продукты"), STUB_ACTION, "1."))
                .isEqualTo(menu.select("Сходить в магазин").get());
        assertThat(new Menu.MenuItemInfo(
                "Купить продукты",
                List.of("Купить хлеб", "Купить молоко"), STUB_ACTION, "1.1."))
                .isEqualTo(menu.select("Купить продукты").get());
        assertThat(new Menu.MenuItemInfo(
                "Покормить собаку", List.of(), STUB_ACTION, "2."))
                .isEqualTo(menu.select("Покормить собаку").get());

        assertThat(new Menu.MenuItemInfo("Выйти на улицу",
                List.of("Погулять"), STUB_ACTION, "3."))
                .isEqualTo(menu.select("Выйти на улицу").get());

        menu.forEach(i -> System.out.println(i.getNumber() + i.getName()));
        assertThat(" 1. Сходить в магазин\n"
                + "---- 1.1. Купить продукты\n"
                + "-------- 1.1.1. Купить хлеб\n"
                + "-------- 1.1.2. Купить молоко\n"
                + " 2. Покормить собаку\n"
                + " 3. Выйти на улицу\n"
                + "---- 3.1. Погулять\n").isEqualTo(menuPrinter.print(menu));
    }
}