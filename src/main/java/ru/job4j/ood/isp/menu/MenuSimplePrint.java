package ru.job4j.ood.isp.menu;

public class MenuSimplePrint implements MenuPrinter {

    @Override
    public String print(Menu menu) {
        StringBuilder res = new StringBuilder();
        for (Menu.MenuItemInfo i : menu) {
            int count = 4 * ((int) i.getNumber().chars().filter(ch -> ch == '.').count() - 1);
            res.append(String.format("%s %s %s\n", "-".repeat(count), i.getNumber(), i.getName()));
        }
        System.out.println(res);
        return res.toString();
    }
}
