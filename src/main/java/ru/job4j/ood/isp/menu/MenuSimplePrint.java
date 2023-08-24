package ru.job4j.ood.isp.menu;

public class MenuSimplePrint implements MenuPrinter {

    @Override
    public void print(Menu menu) {
        for (Menu.MenuItemInfo i : menu) {
            int count = 4 * ((int) i.getNumber().chars().filter(ch -> ch == '.').count() - 1);
            System.out.printf("%s %s %s%n", "-".repeat(count), i.getNumber(), i.getName());
        }
    }
}
